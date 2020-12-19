package add

import (
	"testing"
	"lib"
	"fmt"
)

func TestAdder(t *testing.T)  {
	t.Run("add 2 integers", func(t *testing.T) {
		lib.AssertEqualIntegers(t, Add(2, 4), 6)
	})

}

func ExampleAdd() {
	sum := Add(1, 5)
	fmt.Println(sum)
	// Output: 6
}
