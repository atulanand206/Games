package zigzag

import (
	"testing"
	"lib"
)

func TestZigzag(t *testing.T) {
	testData := []struct {
		input  []int
		output int
	}{
		{[]int {1, 7, 4, 9, 2, 5}, 6},
		{[]int { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }, 7},
		{[]int { 44 }, 1},
		{[]int { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 2},
	}
	for _, it := range testData {
		t.Run("test", func(t *testing.T) {
			lib.AssertEqualIntegers(t, zigzag(it.input), it.output)
		})
	}
}

