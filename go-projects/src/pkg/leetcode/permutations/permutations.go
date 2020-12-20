package permutations

func permute(nums []int) [][]int {
	return permuteLen(nums, len(nums))
}

func permuteLen(nums []int, len int) [][]int {
	var result [][]int
	if len == 0 {
		return result
	}
	if len == 1 {
		for _, it := range nums {
			result = append(result, []int{it})
		}
		return result
	}
	for _, it := range nums {
		permut := permuteLen(nums, len-1)
		for _, perm := range permut {
			if !contains(perm, it) {
				result = append(result, append(perm, it))
			}
		}
	}
	return result
}

func contains(items []int, item int) bool {
	for _, it := range items {
		if it == item {
			return true
		}
	}
	return false
}
