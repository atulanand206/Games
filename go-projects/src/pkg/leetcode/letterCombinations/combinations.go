package letterCombinations

import (
	"strings"
)

type NumberMapping map[string][]string

var mapping = NumberMapping{}

func mapNumbers() {
	mapping["2"] = strings.Split("abc", "")
	mapping["3"] = strings.Split("def", "")
	mapping["4"] = strings.Split("ghi", "")
	mapping["5"] = strings.Split("jkl", "")
	mapping["6"] = strings.Split("mno", "")
	mapping["7"] = strings.Split("pqrs", "")
	mapping["8"] = strings.Split("tuv", "")
	mapping["9"] = strings.Split("wxyz", "")
}

func letterCombinations(digits string) []string {
	mapNumbers()
	return letters(strings.Split(digits, ""))
}

func letters(digits []string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	var result []string
	prefixes := mapping[digits[0]]
	if len(digits) == 1 {
		for i := 0; i < len(prefixes); i++ {
			result = append(result, prefixes[i])
		}
		return result
	}
	letters := letters(digits[1:])
	for i := 0; i < len(prefixes); i++ {
		for _, letter := range letters {
			result = append(result, prefixes[i]+letter)
		}
	}
	return result
}
