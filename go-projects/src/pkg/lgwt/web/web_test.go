package main

import (
	"testing"
	"net/http"
	"net/http/httptest"
	"lib"
	"fmt"
)

type StubPlayerStore struct {
	scores   map[string]int
	winCalls []string
}

func (s *StubPlayerStore) getPlayerScore(player string) int {
	score := s.scores[player]
	return score
}

func (s *StubPlayerStore) RecordWin(player string) {
	s.winCalls = append(s.winCalls, player)
}

func TestGetPlayers(t *testing.T) {
	store := StubPlayerStore{
		map[string]int{
			"Angelina": 20,
			"Floyd":    10,
		},
		nil,
	}
	cases := []struct {
		player string
		score  int
	}{
		{"Angelina", 20},
		{"Floyd", 10},
	}
	server := &PlayerServer{&store}
	for _, c := range cases {
		t.Run(testName(c.player), func(t *testing.T) {
			request := getRequest(c.player)
			response := httptest.NewRecorder()
			server.ServeHTTP(response, request)
			lib.AssertEqual(t, response.Body.String(), fmt.Sprint(c.score))
			lib.AssertEqualIntegers(t, response.Code, http.StatusOK)
		})
	}
	t.Run("404 on missing player", func(t *testing.T) {
		request := getRequest("Apollo")
		response := httptest.NewRecorder()
		server.ServeHTTP(response, request)
		lib.AssertEqualIntegers(t, response.Code, http.StatusNotFound)
	})
}

func TestPostPlayers(t *testing.T) {
	store := StubPlayerStore{
		map[string]int{}, []string{},
	}
	cases := []struct {
		player string
		score  int
	}{
		{"Angelina", 20},
		{"Floyd", 10},
	}
	server := &PlayerServer{&store}
	for _, c := range cases {
		t.Run(testName(c.player), func(t *testing.T) {
			request := postRequest(c.player)
			response := httptest.NewRecorder()
			server.ServeHTTP(response, request)
			lib.AssertEqualIntegers(t, response.Code, http.StatusAccepted)
			if !contains(store, c.player) {
				t.Errorf("%s score not present in the store", c.player)
			}
		})
	}
}

func contains(store StubPlayerStore, player string) bool {
	for _, call := range store.winCalls {
		if call == player {
			return true
		}
	}
	return false
}

func getRequest(player string) (*http.Request) {
	request, _ := http.NewRequest(http.MethodGet, getEndpoint(player), nil)
	return request
}

func postRequest(player string) (*http.Request) {
	request, _ := http.NewRequest(http.MethodPost, getEndpoint(player), nil)
	return request
}

func testName(player string) string {
	return fmt.Sprintf("returns %s's score", player)
}

func getEndpoint(player string) string {
	return "/players/" + player
}
