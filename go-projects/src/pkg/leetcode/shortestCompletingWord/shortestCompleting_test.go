package shortestCompletingWord

import (
	"testing"
	"fmt"
)

func TestShortest(t *testing.T) {
	cases := []struct {
		plate  string
		words  []string
		output string
	}{
		{"1s3 PSt", []string{"step", "steps", "stripe", "stepple"}, "steps"},
		{"1s3 456", []string{"looks","pest","stew","show"}, "pest"},
		{"Ah71752", []string{"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"}, "husband"},
	}
	for _, c := range cases {
		t.Run("completion", func(t *testing.T) {
			got := shortestCompletingWord(c.plate, c.words)
			fmt.Println(got)
			if got != c.output {
				t.Errorf("fail %s", c.plate)
			}
		})
	}
}
