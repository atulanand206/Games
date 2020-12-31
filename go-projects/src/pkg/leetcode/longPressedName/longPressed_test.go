package longPressedName

import (
	"testing"
	"fmt"
	"lib"
)

func TestLongPressed(t *testing.T) {
	cases := []struct {
		name  string
		typed string
		match bool
	}{
		{"alex", "aaleex", true},
		{"saeed", "ssaaedd", false},
		{"leelee", "lleeelee", true},
		{"laiden", "laiden", true},
		{"alex","aaleexa", false},
	}
	for _, c := range cases {
		t.Run(fmt.Sprintf("long pressed"), func(t *testing.T) {
			lib.AssertDeepEqual(t, isLongPressedName(c.name, c.typed), c.match)
		})
	}
}
