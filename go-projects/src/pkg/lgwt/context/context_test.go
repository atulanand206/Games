package context

import (
	"testing"
	"net/http/httptest"
	"net/http"
	"lib"
	"time"
	"context"
	"errors"
)

type SpyStore struct {
	response  string
	t *testing.T
}

func (s *SpyStore) Fetch(ctx context.Context) (string, error) {
	data := make(chan string, 1)

	go func() {
		var result string
		for _, c := range s.response {
			select {
			case <-ctx.Done():
				s.t.Log("spy store got cancelled")
				return
			default:
				time.Sleep(10 * time.Millisecond)
				result += string(c)
			}
		}
		data <- result
	}()

	select {
	case <-ctx.Done():
		return "", ctx.Err()
	case res := <-data:
		return res, nil
	}
}

type SpyResponseWriter struct {
	written bool
}

func (s *SpyResponseWriter) Header() http.Header {
	s.written = true
	return nil
}

func (s *SpyResponseWriter) Write([]byte) (int, error) {
	s.written = true
	return 0, errors.New("not implemented")
}

func (s *SpyResponseWriter) WriteHeader(statusCode int) {
	s.written = true
}


func TestServer(t *testing.T) {
	t.Run("fetch from server", func(t *testing.T) {
		data := "Hello, world"
		store := &SpyStore{data, t}
		server := Server(store)

		request := httptest.NewRequest(http.MethodGet, "/", nil)
		response := httptest.NewRecorder()

		server.ServeHTTP(response, request)
		lib.AssertEqual(t, response.Body.String(), data)
	})

	t.Run("tells store to cancel work if request is cancelled", func(t *testing.T) {
		store := &SpyStore{response: "Hello, world"}
		server := Server(store)

		request := httptest.NewRequest(http.MethodGet, "/", nil)
		ctx, cancel := context.WithCancel(request.Context())

		time.AfterFunc(5*time.Millisecond, cancel)
		request = request.WithContext(ctx)

		response := &SpyResponseWriter{}

		server.ServeHTTP(response, request)

		if response.written {
			t.Error("a response should not have been written")
		}
	})
}
