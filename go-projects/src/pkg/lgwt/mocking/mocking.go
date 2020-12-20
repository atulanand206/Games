package main

import (
	"io"
	"fmt"
	"os"
	"time"
)

type Sleeper interface {
	Sleep()
}

type SpySleeper struct {
	Calls int
}

func (s *SpySleeper) Sleep() {
	s.Calls++
}

type CountDownOperationsSpy struct {
	Calls []string
}

func (s *CountDownOperationsSpy) Sleep() {
	s.Calls = append(s.Calls, sleep)
}

func (s *CountDownOperationsSpy) Write(p []byte) (n int, err error) {
	s.Calls = append(s.Calls, write)
	return
}

type ConfigurableSleeper struct {
	duration time.Duration
	sleep func(time.Duration)
}

type SpyTime struct {
	durationSlept time.Duration
}

func (s *SpyTime) Sleep(duration time.Duration) {
	s.durationSlept = duration
}

func (c *ConfigurableSleeper) Sleep() {
	c.sleep(c.duration)
}

const write = "write"
const sleep = "sleep"

func CountDown(w io.Writer, s Sleeper) {
	for i := 3; i > 0; i-- {
		s.Sleep()
		fmt.Fprintln(w, i)
	}
	s.Sleep()
	fmt.Fprint(w, "Go!")
}

func main() {
	CountDown(os.Stdout, &ConfigurableSleeper{3 * time.Second, time.Sleep})
}
