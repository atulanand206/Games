package iteration

import (
	"testing"
	"lib"
	"fmt"
)

func TestRepeat(t *testing.T) {
	t.Run("repeat a 5 times", func(t *testing.T) {
		lib.AssertEqual(t, Repeat("a", 5), "aaaaa")
	})
	t.Run("repeat fit 10 times", func(t *testing.T) {
		lib.AssertEqual(t, Repeat("fit", 10), "fitfitfitfitfitfitfitfitfitfit")
	})
}

func ExampleRepeat() {
	fmt.Print(Repeat("1", 5))
	// Output: 11111
}

func BenchmarkRepeat(b *testing.B) {
	lib.Bench(b, func() {
		Repeat("a", 10)
	})
}
