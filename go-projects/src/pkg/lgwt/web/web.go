package main

import (
	"net/http"
	"fmt"
	"encoding/json"
)

const (
	contentTypeKey             = "content-type"
	contentTypeApplicationJson = "application/json"
)

type Player struct {
	Name string
	Wins int
}

type PlayerStore interface {
	getPlayerScore(player string) int
	RecordWin(player string)
	GetLeague() League
}

type PlayerServer struct {
	store PlayerStore
	http.Handler
}

func NewPlayerServer(store PlayerStore) *PlayerServer {
	p := new(PlayerServer)
	p.store = store
	router := http.NewServeMux()
	router.Handle("/league", http.HandlerFunc(p.leagueHandler))
	router.Handle("/players/", http.HandlerFunc(p.playerHandler))
	p.Handler = router
	return p
}

func (server *PlayerServer) leagueHandler(writer http.ResponseWriter, request *http.Request) {
	json.NewEncoder(writer).Encode(server.getLeagueTable())
	writer.Header().Set(contentTypeKey, contentTypeApplicationJson)
}

func (server *PlayerServer) getLeagueTable() League {
	return server.store.GetLeague()
}

func (server *PlayerServer) playerHandler(writer http.ResponseWriter, request *http.Request) {
	player := playerNameFromRequest(*request)
	switch request.Method {
	case http.MethodPost:
		server.processWin(writer, player)
	case http.MethodGet:
		server.showScore(writer, player)
	}
}

func (server *PlayerServer) processWin(writer http.ResponseWriter, player string) {
	server.store.RecordWin(player)
	writer.WriteHeader(http.StatusAccepted)
}

func (server *PlayerServer) showScore(writer http.ResponseWriter, player string) {
	score := server.store.getPlayerScore(player)
	if score == 0 {
		writer.WriteHeader(http.StatusNotFound)
	}
	fmt.Fprint(writer, score)
}

func playerNameFromRequest(request http.Request) string {
	return request.URL.Path[len("/players/"):]
}
