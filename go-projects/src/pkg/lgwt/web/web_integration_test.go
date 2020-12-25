package main

import (
	"testing"
	"net/http/httptest"
	"net/http"
)

func TestRecordingWinsAndRetrievingThem(t *testing.T) {
	database, cleanDatabase := createTempFile(t, `[
            {"Name": "Cleo", "Wins": 10},
            {"Name": "Chris", "Wins": 33}]`)
	defer cleanDatabase()
	store, err := NewFileSystemPlayerStore(database)
	AssertNoError(t, err)

	server := NewPlayerServer(store)
	player := "Tony"

	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))
	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))
	server.ServeHTTP(httptest.NewRecorder(), postRequest(player))

	t.Run("get scores", func(t *testing.T) {
		response := httptest.NewRecorder()
		server.ServeHTTP(response, getRequest(player))
		AssertStatus(t, response, http.StatusOK)
		AssertEqual(t, response.Body.String(), "3")
	})

	t.Run("get league", func(t *testing.T) {
		response := httptest.NewRecorder()
		server.ServeHTTP(response, getLeagueRequest())
		AssertStatus(t, response, http.StatusOK)
		AssertContentType(t, response)
		wantedLeague := []Player{
			{"Chris", 33},
			{"Cleo", 10},
			{"Tony", 3},
		}
		AssertLeague(t, response, wantedLeague)
	})
}
