package xOfAKind

import (
	"testing"
	"fmt"
	"lib"
)

func TestWiggle(t *testing.T) {
	cases := []struct {
		arr    []int
		length bool
	}{
		{[]int{1, 1, 2, 2, 2, 2}, true},
		{[]int{1, 1}, true},
		{[]int{1}, false},
		{[]int{1, 1, 1, 2, 2, 2, 3, 3}, false},
		{[]int{1, 2, 3, 4, 4, 3, 2, 1}, true},
		{[]int{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, true},
	}
	for _, c := range cases {
		t.Run(fmt.Sprintf("wiggle %v", c.arr), func(t *testing.T) {
			lib.AssertDeepEqual(t, hasGroupsSizeX(c.arr), c.length)
		})
	}
}
