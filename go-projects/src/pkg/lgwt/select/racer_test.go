package _select

import (
	"testing"
	"lib"
	"net/http/httptest"
	"net/http"
	"time"
)

func TestRacer(t *testing.T) {
	t.Run("race 2 urls", func(t *testing.T) {
		slowServer := delayedServer(20)
		fastServer := delayedServer(10)

		defer slowServer.Close()
		defer fastServer.Close()

		slowUrl := slowServer.URL
		fastUrl := fastServer.URL

		want := fastUrl
		got, _ := Racer(slowUrl, fastUrl)

		lib.AssertEqual(t, got, want)
	})
	t.Run("error if server does not response within 1 sec", func(t *testing.T) {
		serverA := delayedServer(1000)
		defer serverA.Close()
		serverB := delayedServer(1100)
		defer serverB.Close()

		_, err := ConfigurableRacer(serverA.URL, serverB.URL, 1 * time.Second)
		if err == nil {
			t.Error("expected an error but didn't get one")
		}
	})
}

func delayedServer(delayInMillis time.Duration) *httptest.Server {
	return httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		time.Sleep(delayInMillis * time.Millisecond)
		w.WriteHeader(http.StatusOK)
	}))
}
