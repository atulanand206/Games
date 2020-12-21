package lib

import (
	"testing"
	"fmt"
	"reflect"
)

func AssertEqualMessage(t *testing.T, a interface{}, b interface{}, message string) {
	t.Helper()
	if a == b {
		return
	}
	if len(message) == 0 {
		message = fmt.Sprintf("%v != %v", a, b)
	}
	t.Fatal(message)
}

func AssertEquals(t *testing.T, a interface{}, b interface{}) {
	t.Helper()
	if a == b {
		return
	}
	t.Errorf("got %q want %q", a, b)
}

func AssertEqual(t *testing.T, a interface{}, b interface{}) {
	t.Helper()
	if a == b {
		return
	}
	t.Errorf("got %q want %q", a, b)
}

func AssertEqualIntegers(t *testing.T, a int, b int) {
	t.Helper()
	if a == b {
		return
	}
	t.Errorf("got %d want %d", a, b)
}

func AssertEqualFloats(t *testing.T, a, b float64) {
	t.Helper()
	if a != b {
		t.Errorf("got %.2f want %.2f", a, b)
	}
}

func AssertEqualDecimals(t *testing.T, info interface{}, a, b float64) {
	t.Helper()
	if a != b {
		t.Errorf("%#v got %g want %g", info, a, b)
	}
}

func AssertEqualSlices(t *testing.T, a []int, b []int) {
	t.Helper()
	if !reflect.DeepEqual(a, b) {
		t.Errorf("got %v want %v", a, b)
	}
}

func AssertEqual2DSlices(t *testing.T, a [][]int, b [][]int) {
	t.Helper()
	if len(a) != len(b) {
		t.Error("size mismatch")
	}
	for i := 0; i < len(a); i++ {
		fmt.Println(i)
		AssertEqualSlices(t, a[i], b[i])
	}
}

func AssertEqualStringSlices(t *testing.T, a []string, b []string) {
	t.Helper()
	if !reflect.DeepEqual(a, b) {
		t.Errorf("got %v want %v", a, b)
	}
}

func AssertDeepEqual(t *testing.T, a interface{}, b interface{}) {
	t.Helper()
	if !reflect.DeepEqual(a, b) {
		t.Errorf("got %v want %v", a, b)
	}
}

func AssertSearch(t *testing.T, ok error, definition string, wantError error, wantDefinition string) {
	t.Helper()
	AssertEquals(t, ok, wantError)
	AssertEqual(t, definition, wantDefinition)
}

func AssertContains(t *testing.T, haystack []string, needle string)  {
	t.Helper()
	contains := false
	for _, x := range haystack {
		if x == needle {
			contains = true
		}
	}
	if !contains {
		t.Errorf("expected %+v to contain %q but it didn't", haystack, needle)
	}
}

func Bench(b *testing.B, f func()) {
	b.Helper()
	for i := 0; i < b.N; i++ {
		f()
	}
}
