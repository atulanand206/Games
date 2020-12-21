package decodeAtIndex

import (
	"testing"
	"lib"
)

func TestDecode(t *testing.T) {
	testData := []struct {
		input  string
		k      int
		output string
	}{
		{"leet2code3", 10, "o"},
		{"ha22", 5, "h"},
		{"a2345678999999999999999", 1, "a"},
		{"y959q969u3hb22odq595", 222280369, "a"},
	}
	for _, it := range testData {
		t.Run("test", func(t *testing.T) {
			lib.AssertEqual(t, decodeAtIndex(it.input, it.k), it.output)
		})
	}
}
