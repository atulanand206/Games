package main

import (
	"testing"
	"net/http/httptest"
	"lib"
	"net/http"
)

func TestRecordingWinsAndRetrievingThem(t *testing.T) {
	store := NewInMemoryPlayerStore()
	server := PlayerServer{store}
	player := "Tony"

	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))
	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))
	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))

	response := httptest.NewRecorder()
	server.ServeHTTP(response, getRequest(player))
	lib.AssertEqualIntegers(t, response.Code, http.StatusOK)
	lib.AssertEqual(t, response.Body.String(), "3")
}


