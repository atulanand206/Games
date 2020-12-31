package shortestCompletingWord

import (
	"regexp"
	"strings"
)

func shortestCompletingWord(licensePlate string, words []string) string {
	plateMap := wordMap(licensePlate)
	min := 15
	minIndex := -1
	for i, word := range words {
		iterationMap := wordMap(word)
		if isValid(plateMap, iterationMap) {
			if len(word) < min {
				min = len(word)
				minIndex = i
			}
		}
	}
	return words[minIndex]
}
func isValid(base map[string]int, new map[string]int) bool {
	for k, v := range base {
		max := new[k]
		if max < v {
			return false
		}
	}
	return true
}

var IsLetter = regexp.MustCompile(`^[a-zA-Z]+$`).MatchString

func wordMap(word string) map[string]int {
	wordMap := map[string]int{}
	for i := 0; i < len(word); i++ {
		char := strings.ToLower(string(word[i]))
		if IsLetter(char) {
			count := wordMap[char]
			wordMap[char] = count + 1
		}
	}
	return wordMap
}
