package main

import (
	"net/http"
	"fmt"
	"strings"
)

type PlayerStore interface {
	getPlayerScore(player string) int
	RecordWin(player string)
}

type PlayerServer struct {
	store PlayerStore
}

func (server *PlayerServer) ServeHTTP(writer http.ResponseWriter, request *http.Request) {
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
	return strings.TrimPrefix(request.URL.Path, "/players/")
}
