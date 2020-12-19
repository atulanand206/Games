package sum

import (
	"testing"
	"lib"
)

func TestSum(t *testing.T) {
	t.Run("add all the elements of the array", func(t *testing.T) {
		lib.AssertEqualIntegers(t, Sum([]int{1, 2, 3, 4, 5}), 15)
	})
}

func TestSumAll(t *testing.T) {
	t.Run("Return sum of each slice as an item in the slice", func(t *testing.T) {
		lib.AssertEqualSlices(t, SumAll([]int{1, 2, 3, 4, 5}, []int{1, 2, 3, 4, 5}), []int{15, 15})
	})
}

func TestSumAllTails(t *testing.T) {
	t.Run("Return sum of elements except the first element of the slices", func(t *testing.T) {
		lib.AssertEqualSlices(t, SumAllTails([]int{1, 2, 3, 4, 5}, [] int{5, 2, 4, 5}), [] int{14, 11})
	})
	t.Run("Return sum of elements except the first element of the slices", func(t *testing.T) {
		lib.AssertEqualSlices(t, SumAllTails([]int{}, [] int{5, 2, 4, 5}), [] int{0, 11})
	})
	t.Run("Return sum of elements except the first element of the slices", func(t *testing.T) {
		lib.AssertEqualSlices(t, SumAllTails([]int{2}, [] int{5, 2, 4, 5}), [] int{0, 11})
	})
}
