package sync

import (
	"testing"
	"lib"
	"sync"
)

func TestCounter(t *testing.T) {
	t.Run("incrementing the counter 3 times leaves it at 3", func(t *testing.T) {
		counter := Counter{}
		counter.Inc()
		counter.Inc()
		counter.Inc()
		lib.AssertEqualIntegers(t, counter.Value(), 3)
	})

	t.Run("increment runs safely concurrently", func(t *testing.T) {
		wantedCounter := 1000
		counter := Counter{}

		wg := sync.WaitGroup{}
		wg.Add(wantedCounter)

		for i := 0; i < wantedCounter; i++ {
			go func(w *sync.WaitGroup) {
				counter.Inc()
				w.Done()
			}(&wg)
		}

		wg.Wait()
		lib.AssertEqualIntegers(t, counter.Value(), wantedCounter)
	})
}
