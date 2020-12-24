package main

import (
	"testing"
	"net/http"
	"net/http/httptest"
	"lib"
	"encoding/json"
)

func TestLeague(t *testing.T) {
	t.Run("returns 200 on /league", func(t *testing.T) {
		wantedLeague := []Player{
			{"Cleo", 32},
			{"Chris", 20},
			{"Tiest", 14},
		}
		store := &StubPlayerStore{nil, nil, wantedLeague}
		server := NewPlayerServer(store)

		request := getLeagueRequest()
		response := httptest.NewRecorder()

		server.ServeHTTP(response, request)

		AssertStatus(t, response, http.StatusOK)
		AssertContentType(t, response)
		AssertLeague(t, response, wantedLeague)
	})
}

func getLeagueRequest() *http.Request {
	request, _ := http.NewRequest(http.MethodGet, "/league", nil)
	return request
}

func AssertLeague(t *testing.T, response *httptest.ResponseRecorder, wantedLeague []Player) {
	got := getLeagueFromResponse(t, response)
	lib.AssertDeepEqual(t, got, wantedLeague)
}

func getLeagueFromResponse(t *testing.T, response *httptest.ResponseRecorder) (league []Player) {
	t.Helper()
	err := json.NewDecoder(response.Body).Decode(&league)
	if err != nil {
		t.Errorf("Response can't be parsed into a json")
	}
	return
}

func AssertStatus(t *testing.T, response *httptest.ResponseRecorder, status int) {
	t.Helper()
	lib.AssertEqualIntegers(t, response.Code, status)
}

func AssertContentType(t *testing.T, response *httptest.ResponseRecorder) {
	t.Helper()
	if response.Header().Get(contentTypeKey) != contentTypeApplicationJson {
		t.Errorf("response did not have content-type of application/json, got %v", response.Result().Header)
	}
}
