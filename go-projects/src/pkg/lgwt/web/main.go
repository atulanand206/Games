package main

import (
	"net/http"
	"log"
)

func main() {
	store := NewInMemoryPlayerStore()
	server := &PlayerServer{store}
	handler := http.HandlerFunc(server.ServeHTTP)
	serve := http.ListenAndServe(":5000", handler)
	if serve != nil {
		log.Fatalf("could not listen on port 5000 %v", serve)
	}
}
