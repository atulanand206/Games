package clock

import (
	"testing"
	"bytes"
	"encoding/xml"
	"time"
)

type TimeLine struct {
	time time.Time
	line Line
}

func containsLine(line Line, lines []Line) bool {
	for _, l := range lines {
		if line == l {
			return true
		}
	}
	return false
}

func assertContainsLine(c TimeLine, svg *SVG, t *testing.T, b bytes.Buffer) {
	if !containsLine(c.line, svg.Line) {
		t.Errorf("Expected to find the hand in the SVG output %v", b.String())
	}
}

func TestSvgWriter(t *testing.T) {
	cases := []TimeLine{
		{simpleTime(0, 0, 0), Line{centerX, centerY, 150, 60}},
		{simpleTime(0, 0, 30), Line{centerX, centerY, 150, 240}},
		{simpleTime(0, 0, 45), Line{centerX, centerY, 60, 150}},
		{simpleTime(0, 0, 15), Line{centerX, centerY, 240, 150}},
		{simpleTime(0, 15, 15), Line{centerX, centerY, 240, 150}},
		{simpleTime(0, 15, 0), Line{centerX, centerY, 230, 150}},
		{simpleTime(3, 15, 0), Line{centerX, centerY, 230, 150}},
		{simpleTime(3, 0, 0), Line{centerX, centerY, 200, 150}},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			b := bytes.Buffer{}
			SvgWriter(&b, c.time)
			svg := &SVG{}
			xml.Unmarshal(b.Bytes(), &svg)
			assertContainsLine(c, svg, t, b)
		})
	}
}
