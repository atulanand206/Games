package main

import (
	"encoding/json"
	"os"
	"fmt"
	"sort"
)

type FileSystemPlayerStore struct {
	database *json.Encoder
	league   League
}

func initializePlayerDBFile(file *os.File) error {
	file.Seek(0, 0)
	info, err := file.Stat()
	if err != nil {
		return fmt.Errorf("problem getting file info from file %s, %v", file.Name(), err)
	}
	if info.Size() == 0 {
		file.Write([]byte("[]"))
		file.Seek(0, 0)
	}
	return nil
}

func NewFileSystemPlayerStore(file *os.File) (*FileSystemPlayerStore, error) {
	err := initializePlayerDBFile(file)
	if err != nil {
		return nil, fmt.Errorf("problem initializing player db file, %v", err)
	}
	league, err := NewLeague(file)
	if err != nil {
		return nil, fmt.Errorf("problem loading player store from file %s, %v", file.Name(), err)
	}
	return &FileSystemPlayerStore{json.NewEncoder(&Tape{file}), league}, nil
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
	i.database.Encode(i.league)
}

func (i *FileSystemPlayerStore) GetLeague() League {
	sort.SliceStable(i.league, func(k, j int) bool {
		return i.league[k].Wins > i.league[j].Wins
	})
	return i.league
}
