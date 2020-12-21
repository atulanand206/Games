package decodeAtIndex

import (
	"regexp"
	"fmt"
	"strconv"
)

var digitCheck = regexp.MustCompile(`[0-9]`)
var alphaCheck = regexp.MustCompile(`[a-z]`)

func decodeAtIndex(S string, K int) string {
	var decodedString []string
	for i := 0; i < len(S); i++ {
		if sliceLength(decodedString) > K {
			break
		}
		char := string(S[i])
		if digitCheck.MatchString(char) {
			stringToCopy := decodedString
			count, _ := strconv.Atoi(char)
			for j := 1; j < count; j++ {
				for _, k := range stringToCopy {
					decodedString = append(decodedString, k)
				}
			}
		}
		if alphaCheck.MatchString(char) {
			decodedString = append(decodedString, char)
		}
	}
	fmt.Println(S)
	fmt.Println(decodedString)
	return getChar(decodedString, K-1)
}
func getChar(strings []string, k int) string {
	i := 0
	for _, it := range strings {
		fmt.Println(it)
		if i+len(it) > k {
			return string(it)
		}
		i = i + len(it)
	}
	return ""
}

func sliceLength(slices []string) int {
	length := int(0)
	for _, i := range slices {
		length += len(i)
	}
	return length
}
