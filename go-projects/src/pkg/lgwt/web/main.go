package main

import (
	"net/http"
	"log"
	"os"
)

const dbFileName = "db.game.json"
func main() {
	db, err := os.OpenFile(dbFileName, os.O_CREATE|os.O_RDWR, 0666)
	if err != nil {
		log.Fatalf("problem opening %s %v", dbFileName, err)
	}
	store := NewFileSystemPlayerStore(db)
	server := NewPlayerServer(store)
	handler := http.HandlerFunc(server.ServeHTTP)
	serve := http.ListenAndServe(":5000", handler)
	if serve != nil {
		log.Fatalf("could not listen on port 5000 %v", serve)
	}
}
