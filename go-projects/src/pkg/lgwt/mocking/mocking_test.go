package main

import (
	"testing"
	"lib"
	"bytes"
	"time"
)

func TestCountDown(t *testing.T) {
	t.Run("write countdown and sleep 4 times", func(t *testing.T) {
		buffer := &bytes.Buffer{}
		spySleeper := &SpySleeper{}
		CountDown(buffer, spySleeper)
		want := `3
2
1
Go!`
		lib.AssertEqual(t, buffer.String(), want)
		lib.AssertEqualIntegers(t, spySleeper.Calls, 4)
	})
	t.Run("write countdown and sleep in order", func(t *testing.T) {
		countDownOperationsSpy := &CountDownOperationsSpy{}
		CountDown(countDownOperationsSpy, countDownOperationsSpy)
		want := []string{
			sleep,
			write,
			sleep,
			write,
			sleep,
			write,
			sleep,
			write,
		}
		lib.AssertEqualStringSlices(t, countDownOperationsSpy.Calls, want)
	})
}

func TestConfigurableSleeper(t *testing.T) {
	sleepTime := 5 * time.Second
	spyTime := &SpyTime{}
	sleeper := ConfigurableSleeper{sleepTime, spyTime.Sleep}
	sleeper.Sleep()
	lib.AssertEqual(t, spyTime.durationSlept, sleepTime)
}
