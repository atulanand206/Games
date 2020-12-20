package dictionary

import (
	"testing"
	"lib"
)

func TestSearch(t *testing.T) {
	t.Run("finding item in a dictionary", func(t *testing.T) {
		dictionary := Dictionary{"test": "this is a test string"}
		definition, ok := dictionary.Search("test")
		lib.AssertSearch(t, ok, definition, nil, "this is a test string")
	})
	t.Run("finding item not present in the dictionary throws error", func(t *testing.T) {
		dictionary := Dictionary{"test": "this is a test string"}
		definition, ok := dictionary.Search("te2st")
		lib.AssertSearch(t, ok, definition, ErrWordNotFound, "")
	})
}

func TestAdd(t *testing.T) {
	t.Run("add word to the dictionary", func(t *testing.T) {
		dictionary := Dictionary{}
		definition, ok := dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, ErrWordNotFound, "")

		dictionary.Add("drama", "play enacted by actors")
		definition, ok = dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, nil, "play enacted by actors")
	})
	t.Run("add word to the dictionary if already present throws error", func(t *testing.T) {
		dictionary := Dictionary{}
		definition, ok := dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, ErrWordNotFound, "")

		dictionary.Add("drama", "play enacted by actors")
		definition, ok = dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, nil, "play enacted by actors")

		ok = dictionary.Add("drama", "play enacted by actresses")
		definition, _ = dictionary.Search("drama")
		lib.AssertEquals(t, ok, ErrWordAlreadyPresent)
		lib.AssertEqual(t, definition, "play enacted by actors")
	})
}

func TestUpdate(t *testing.T) {
	t.Run("update word if present", func(t *testing.T) {
		dictionary := Dictionary{}
		dictionary.Add("drama", "play enacted by actors")
		definition, ok := dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, nil, "play enacted by actors")

		dictionary.Update("drama", "play enacted by actresses")
		definition, ok = dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, nil, "play enacted by actresses")
	})
	t.Run("update word if not present throws error", func(t *testing.T) {
		dictionary := Dictionary{}
		ok := dictionary.Update("drama", "play enacted by actresses")
		definition, _ := dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, ErrWordNotFound, "")
	})
}

func TestDelete(t *testing.T) {
	t.Run("delete word if present", func(t *testing.T) {
		dictionary := Dictionary{}
		dictionary.Add("drama", "play enacted by actors")
		definition, ok := dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, nil, "play enacted by actors")

		dictionary.Delete("drama")
		definition, ok = dictionary.Search("drama")
		lib.AssertSearch(t, ok, definition, ErrWordNotFound, "")
	})
}