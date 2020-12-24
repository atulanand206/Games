package context

import (
	"net/http"
	"context"
	"fmt"
)

type Store interface {
	Fetch(ctx context.Context) (string, error)
}

func Server(store Store) http.HandlerFunc {
	return func(w http.ResponseWriter, request *http.Request) {
		data, err := store.Fetch(request.Context())
		if err != nil {
			return // todo: log error however you like
		}
		fmt.Fprintf(w, data)
	}
}
