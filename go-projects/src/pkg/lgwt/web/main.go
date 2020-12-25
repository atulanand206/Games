package main

import (
	"net/http"
	"os"
)

const dbFileName = "db.game.json"

func main() {
	db, err := os.OpenFile(dbFileName, os.O_CREATE|os.O_RDWR, 0666)
	ErrorFileOpening(err)
	store, err := NewFileSystemPlayerStore(db)
	ErrorFileCreation(err)
	server := NewPlayerServer(store)
	handler := http.HandlerFunc(server.ServeHTTP)
	err = http.ListenAndServe(":5000", handler)
	ErrorListenAndServe(err)
}