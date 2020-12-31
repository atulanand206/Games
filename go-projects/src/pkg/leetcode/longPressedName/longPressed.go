package longPressedName

import (
	"strings"
	"regexp"
)

func isLongPressedName(name string, typed string) bool {
	name = strings.ReplaceAll(name, "", "+")
	name = strings.TrimPrefix(name, "+")
	name = "^" + name + "$"
	compile, _ := regexp.Compile(name)
	b := compile.MatchString(typed)
	return b
}
