package hello

import "testing"
import "lib"

func TestHello(t *testing.T) {
	lib.AssertEqualMessage(t, HelloWorld(), "Hello, World!", "Hello mismatch")
}

func TestHelloYou(t *testing.T) {
	t.Run("saying Hello to people", func(t *testing.T) {
		lib.AssertEqual(t, Hello("Atul", ""), "Hello, Atul!")
	})
	t.Run("say Hello world when an empty string is supplied", func(t *testing.T) {
		lib.AssertEqual(t, Hello("", ""), "Hello, World!")
	})
	t.Run("say Hello in spanish", func(t *testing.T) {
		lib.AssertEqual(t, Hello("Atul", "Spanish"), "Hola, Atul!")
	})
	t.Run("say Hello in french", func(t *testing.T) {
		lib.AssertEqual(t, Hello("Atul", "French"), "Bonjour, Atul!")
	})
}
