package main

import "sync"

type InMemoryPlayerStore struct {
	store map[string]int
	lock sync.RWMutex
}

func NewInMemoryPlayerStore() *InMemoryPlayerStore {
	return &InMemoryPlayerStore{map[string]int{}, sync.RWMutex{}}
}

func (i *InMemoryPlayerStore) getPlayerScore(player string) int {
	i.lock.Lock()
	defer i.lock.Unlock()
	return i.store[player]
}

func (i *InMemoryPlayerStore) RecordWin(player string) {
	i.lock.RLock()
	defer i.lock.RUnlock()
	i.store[player]++
}
