package main

import (
	"fmt"
	"os"
	"io"
	"net/http"
)

func Greet(writer io.Writer, name string) {
	fmt.Fprintf(writer, "Hello, %s!", name)
}

func GreetHandler(w http.ResponseWriter, r *http.Request) {
	Greet(w, "Toaby")
}

func main() {
	Greet(os.Stdout, "Elodie")
	http.ListenAndServe(":5000", http.HandlerFunc(GreetHandler))
}
