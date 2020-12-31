package xOfAKind

import (
	"fmt"
)

func hasGroupsSizeX(deck []int) bool {
	nums := map[int]int{}
	for _, c := range deck {
		count := nums[c]
		nums[c] = count + 1
	}
	fmt.Println(nums)
	max := 0
	for _, v := range nums {
		if v < 2 {
			return false
		}
		if v > max {
			max = v
		}
	}
	possible := false
	for i := 2; i <= max; i++ {
		count := 0
		for _, v := range nums {
			if v%i == 0 {
				count++
			}
		}
		if count == len(nums) {
			possible = true
			break
		}
	}
	return possible
}
