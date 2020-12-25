package main

import (
	"fmt"
	"log"
)

func ErrorParseLeague(err error) error {
	if err != nil {
		err = fmt.Errorf("problem parsing league, %v", err)
	}
	return err
}

func ErrorFileOpening(err error) {
	if err != nil {
		log.Fatalf("problem opening %s %v", dbFileName, err)
	}
}

func ErrorFileCreation(err error) {
	if err != nil {
		log.Fatalf("problem creating file system player store, %v ", err)
	}
}

func ErrorListenAndServe(err error) {
	if err != nil {
		log.Fatalf("could not listen on port 5000 %v", err)
	}
}
