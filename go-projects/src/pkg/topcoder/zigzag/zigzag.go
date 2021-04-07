package zigzag

import (
	"math"
	"fmt"
)

func zigzag(numbers []int) int {
	length := len(numbers)
	if length < 2 {
		return length
	}
	var dp [length][2]int
	for i := 0; i <= length; i++ {
		dp[i][0] = 1
		dp[i][1] = 1
		for j := 0; j < i; j++ {
			if numbers[i] > numbers[j] {
				dp[i][0] = int(math.Max(float64(dp[j][1])+1, float64(dp[i][0])))
			} else if numbers[i] < numbers[j] {
				dp[i][1] = int(math.Max(float64(dp[j][0])+1, float64(dp[i][1])))
			}
		}
	}
	return int(math.Max(float64(dp[length-1][0]), float64(dp[length-1][1])))
}
