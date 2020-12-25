package main

import (
	"testing"
	"lib"
	"io"
	"io/ioutil"
	"os"
)

func TestFileSystemStore(t *testing.T) {
	t.Run("/league from a reader", func(t *testing.T) {
		database, cleanDatabase := createTempFile(t, `[
            {"Name": "Cleo", "Wins": 10},
            {"Name": "Chris", "Wins": 33}]`)
		defer cleanDatabase()
		store := NewFileSystemPlayerStore(database)

		got := store.GetLeague()

		want := League{
			{"Cleo", 10},
			{"Chris", 33},
		}

		lib.AssertDeepEqual(t, got, want)

		got = store.GetLeague()
		lib.AssertDeepEqual(t, got, want)
	})

	t.Run("get player score", func(t *testing.T) {
		database, cleanDatabase := createTempFile(t,`[
            {"Name": "Cleo", "Wins": 10},
            {"Name": "Chris", "Wins": 33}]`)
		defer cleanDatabase()
		store := NewFileSystemPlayerStore(database)

		got := store.getPlayerScore("Cleo")

		want := 10
		lib.AssertEqualIntegers(t, got, want)
	})

	t.Run("store wins for existing players", func(t *testing.T) {
		database, cleanDatabase := createTempFile(t, `[
            {"Name": "Cleo", "Wins": 10},
            {"Name": "Chris", "Wins": 33}]`)
		defer cleanDatabase()
		store := NewFileSystemPlayerStore(database)

		store.RecordWin("Chris")
		got := store.getPlayerScore("Chris")

		want := 34
		lib.AssertEqualIntegers(t, got, want)
	})

	t.Run("store wins for new players", func(t *testing.T) {
		database, cleanDatabase := createTempFile(t, `[
            {"Name": "Cleo", "Wins": 10},
            {"Name": "Chris", "Wins": 33}]`)
		defer cleanDatabase()
		store := NewFileSystemPlayerStore(database)

		store.RecordWin("Jack")
		got := store.getPlayerScore("Jack")
		want := 1
		lib.AssertEqualIntegers(t, got, want)
	})
}

func createTempFile(t *testing.T, seedData string) (io.ReadWriteSeeker, func()) {
	t.Helper()
	tmpFile, err := ioutil.TempFile("", "db")
	if err != nil {
		t.Fatalf("could not create a temp file %v", err)
	}
	tmpFile.Write([]byte(seedData))
	removeFile := func() {
		tmpFile.Close()
		os.Remove(tmpFile.Name())
	}
	return tmpFile, removeFile
}
