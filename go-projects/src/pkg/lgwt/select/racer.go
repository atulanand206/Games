package _select

import (
	"net/http"
	"time"
	"fmt"
)

const tenSecondTimeout = 10 * time.Second

func Racer(slowUrl string, fastUrl string) (winner string, err error) {
	return ConfigurableRacer(slowUrl, fastUrl, tenSecondTimeout)
}

func ConfigurableRacer(slowUrl string, fastUrl string, timeout time.Duration) (winner string, err error) {
	select {
	case <-ping(slowUrl):
		return slowUrl, nil
	case <-ping(fastUrl):
		return fastUrl, nil
	case <-time.After(timeout):
		return "", fmt.Errorf("timed out waiting for %s and %s", slowUrl, fastUrl)

	}
}

func ping(url string) chan struct{} {
	ch := make(chan struct{})
	go func() {
		http.Get(url)
		close(ch)
	}()
	return ch
}
