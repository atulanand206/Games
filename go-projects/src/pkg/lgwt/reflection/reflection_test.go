package reflection

import (
	"testing"
	"lib"
)

type Person struct {
	Name    string
	Profile Profile
}

type Profile struct {
	Age  int
	City string
}

func TestWalk(t *testing.T) {
	cases := [] struct {
		Name          string
		Input         interface{}
		ExpectedCalls []string
	}{
		{
			"Struct with one string field",
			struct {
				Name string
			}{"Gosling"},
			[]string{"Gosling"},
		},
		{
			"Struct with two string field",
			struct {
				Name string
				City string
			}{"Gosling", "Berlin"},
			[]string{"Gosling", "Berlin"},
		},
		{
			"Struct with non string field",
			struct {
				Name string
				Age  int
			}{"Chris", 33},
			[]string{"Chris"},
		},
		{
			"Nested fields",
			Person{"James", Profile{33, "Frankfurt"}},
			[]string{"James", "Frankfurt"},
		},
		{
			"Pointers to things",
			&Person{"James", Profile{33, "Frankfurt"}},
			[]string{"James", "Frankfurt"},
		},
		{
			"Slices",
			[]Profile{
				{33, "Millie"},
				{34, "Nastasya"},
			},
			[]string{"Millie", "Nastasya"},
		},
		{
			"Arrays",
			[2]Profile{
				{33, "Millie"},
				{34, "Nastasya"},
			},
			[]string{"Millie", "Nastasya"},
		},
	}

	for _, test := range cases {
		t.Run(test.Name, func(t *testing.T) {
			var got []string
			walk(test.Input, func(input string) {
				got = append(got, input)
			})
			lib.AssertDeepEqual(t, got, test.ExpectedCalls)
		})
	}

	t.Run("with maps", func(t *testing.T) {
		aMap := map[string]string{
			"Foo": "Bar",
			"Baz": "Boz",
		}

		var got []string
		walk(aMap, func(input string) {
			got = append(got, input)
		})

		lib.AssertContains(t, got, "Bar")
		lib.AssertContains(t, got, "Boz")
	})

	t.Run("with channels", func(t *testing.T) {
		channel := make(chan Profile)

		go func() {
			channel <- Profile{23, "Amsterdam"}
			channel <- Profile{25, "Paris"}
		}()

		var got []string
		want := []string{"Amsterdam", "Paris"}
		walk(channel, func(input string) {
			got = append(got, input)
		})

		lib.AssertDeepEqual(t, got, want)
	})

	t.Run("with functions", func(t *testing.T) {
		function := func() (Profile, Profile) {
			return Profile{33, "Berlin"}, Profile{34, "Katowice"}
		}

		var got []string
		want := []string{"Berlin", "Katowice"}

		walk(function, func(input string) {
			got = append(got, input)
		})

		lib.AssertDeepEqual(t, got, want)
	})
}
