package main

import (
	"testing"
	"net/http/httptest"
	"lib"
	"encoding/json"
	"reflect"
)

func AssertLeague(t *testing.T, response *httptest.ResponseRecorder, wantedLeague []Player) {
	t.Helper()
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

func AssertNoError(t *testing.T, err error) {
	t.Helper()
	if err != nil {
		t.Fatalf("didn't expect an error but got one, %v", err)
	}
}

func AssertFileCreation(t *testing.T, err error) {
	t.Helper()
	if err != nil {
		t.Fatalf("could not create a temp file %v", err)
	}
}

func AssertPlayerInStore(t *testing.T, store []string, c struct {
	player string
	score  int
}) {
	t.Helper()
	if !contains(store, c.player) {
		t.Errorf("%s score not present in the store", c.player)
	}
}

func contains(store []string, player string) bool {
	for _, call := range store {
		if call == player {
			return true
		}
	}
	return false
}

func AssertDeepEqual(t *testing.T, a interface{}, b interface{}) {
	t.Helper()
	if !reflect.DeepEqual(a, b) {
		t.Errorf("got %v want %v", a, b)
	}
}

func AssertEqualIntegers(t *testing.T, a int, b int) {
	t.Helper()
	if a == b {
		return
	}
	t.Errorf("got %d want %d", a, b)
}

func AssertEqual(t *testing.T, a interface{}, b interface{}) {
	t.Helper()
	if a == b {
		return
	}
	t.Errorf("got %q want %q", a, b)
}
