package geometry

import (
	"testing"
	"lib"
)

func TestPerimeter(t *testing.T) {
	t.Run("perimeter of a rectangle", func(t *testing.T) {
		lib.AssertEqualFloats(t, Perimeter(Rectangle{10.0, 10.0}), 40.0)
	})
}

func TestArea(t *testing.T) {
	checkArea := func(t *testing.T, shape Shape, want float64) {
		t.Helper()
		lib.AssertEqualDecimals(t, shape, shape.Area(), want)
	}
	t.Run("area of a rectangle", func(t *testing.T) {
		checkArea(t, Rectangle{2, 4}, 8)
	})
	t.Run("area of a circle", func(t *testing.T) {
		checkArea(t, Circle{10.0}, 314.1592653589793)
	})
	t.Run("area of shape struct slices", func(t *testing.T) {
		areaTests := []struct {
			name  string
			shape Shape
			want  float64
		}{
			{"Rectangle", Rectangle{5, 7}, 35},
			{"Circle", Circle{10}, 314.1592653589793},
			{"Triangle", Triangle{Base: 12, Height: 6}, 36},
		}
		for _, item := range areaTests {
			t.Run(item.name, func(t *testing.T) {
				checkArea(t, item.shape, item.want)
			})
		}
	})
}
