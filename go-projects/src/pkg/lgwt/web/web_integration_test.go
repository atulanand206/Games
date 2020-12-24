package main

import (
	"testing"
	"net/http/httptest"
	"lib"
	"net/http"
)

func TestRecordingWinsAndRetrievingThem(t *testing.T) {
	store := NewInMemoryPlayerStore()
	server := NewPlayerServer(store)
	player := "Tony"

	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))
	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))
	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))

	t.Run("get scores", func(t *testing.T) {
		response := httptest.NewRecorder()
		server.ServeHTTP(response, getRequest(player))
		AssertStatus(t, response, http.StatusOK)
		lib.AssertEqual(t, response.Body.String(), "3")
	})

	t.Run("get league", func(t *testing.T) {
		response := httptest.NewRecorder()
		server.ServeHTTP(response, getLeagueRequest())
		AssertStatus(t, response, http.StatusOK)
		AssertContentType(t, response)
		wantedLeague := []Player{
			{"Tony", 3},
		}
		AssertLeague(t, response, wantedLeague)
	})
}
