package main

import (
	"io"
	"encoding/json"
)

type FileSystemPlayerStore struct {
	database io.ReadWriteSeeker
	league   League
}

func NewFileSystemPlayerStore(database io.ReadWriteSeeker) *FileSystemPlayerStore {
	database.Seek(0, 0)
	league, _ := NewLeague(database)
	return &FileSystemPlayerStore{database, league}
}

func (i *FileSystemPlayerStore) getPlayerScore(player string) int {
	play := i.GetLeague().Find(player)
	if play != nil {
		return play.Wins
	}
	return 0
}

func (i *FileSystemPlayerStore) RecordWin(player string) {
	play := i.league.Find(player)
	if play != nil {
		play.Wins++
	} else {
		i.league = append(i.league, Player{player, 1})
	}
	i.database.Seek(0, 0)
	json.NewEncoder(i.database).Encode(i.league)
}

func (i *FileSystemPlayerStore) GetLeague() League {
	return i.league
}
