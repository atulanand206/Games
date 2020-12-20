package permutations

import (
	"testing"
	"lib"
	"fmt"
)

func TestPermutation(t *testing.T) {
	testData := []struct {
		input  []int
		output [][]int
	}{
		{[]int{1, 2, 3}, [][]int{{3, 2, 1}, {2, 3, 1}, {3, 1, 2}, {1, 3, 2}, {2, 1, 3}, {1, 2, 3}}},
		{[]int{0, 1}, [][]int{{1, 0}, {0, 1}}},
		{[]int{1}, [][]int{{1}}},
	}
	fmt.Println(len(testData))
	for _, data := range testData {
		t.Run("", func(t *testing.T) {
			lib.AssertEqual2DSlices(t, permute(data.input), data.output)
		})
	}
}
