package main

import (
	"testing"
	"bytes"
	"lib"
)

func TestGreet(t *testing.T) {
	buffer := bytes.Buffer{}
	Greet(&buffer, "Rachel")
	lib.AssertEqual(t, buffer.String(), "Hello, Rachel!")
}
