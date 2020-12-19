package sum

func Sum(array []int) int {
	sum := 0
	for _, number := range array {
		sum += number
	}
	return sum
}

func SumAll(arrays ...[]int) (sums []int) {
	for _, numbers := range arrays {
		sums = append(sums, Sum(numbers))
	}
	return
}

func SumAllTails(arrays ...[]int) (sums []int) {
	for _, numbers := range arrays {
		if len(numbers) == 0 {
			sums = append(sums, 0)
		} else {
			sums = append(sums, Sum(numbers[1:]))
		}
	}
	return
}
