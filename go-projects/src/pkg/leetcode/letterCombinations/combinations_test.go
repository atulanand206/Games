package letterCombinations

import (
	"testing"
	"lib"
	"fmt"
)

func TestMapping(t *testing.T) {
	mapNumbers()
	for key, value := range mapping {
		fmt.Printf("%s : %q\n", key, value)
	}
}

func TestCombinations(t *testing.T) {
	combinationTest := []struct {
		digits string
		output []string
	}{
		{"23", []string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}},
		{"", []string{}},
		{"2", []string{"a", "b", "c"}},
	}
	for _, item := range combinationTest {
		t.Run("", func(t *testing.T) {
			combinations := letterCombinations(item.digits)
			for _, comb := range combinations {
				fmt.Println(comb)
			}
			lib.AssertEqualStringSlices(t, combinations, item.output)
		})
	}
}
