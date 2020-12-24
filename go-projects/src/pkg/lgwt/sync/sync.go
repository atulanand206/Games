package sync

import "sync"

type Counter struct {
	mu sync.Mutex
	value int
}

func (counter *Counter) Inc() {
	counter.mu.Lock()
	defer counter.mu.Unlock()
	counter.value++
}

func (counter *Counter) Value() int {
	return counter.value
}
