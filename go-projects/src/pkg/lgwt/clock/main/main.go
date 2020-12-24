package main

import (
	"time"
	"lib/clock"
	"os"
)

func main() {
	clock.SvgWriter(os.Stdout, time.Now())
}
