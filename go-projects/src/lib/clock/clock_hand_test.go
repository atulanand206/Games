package clock

import (
	"testing"
	"time"
	"math"
)

const equalityThreshold = 1e-7

func roughlyEqualFloat64(a, b float64) bool {
	return math.Abs(a-b) < equalityThreshold
}

func assertRoughlyEqualFloats(t *testing.T, a, b float64) {
	if !roughlyEqualFloat64(a, b) {
		t.Fatalf("Wanted %v, but got %v", b, a)
	}
}

func roughlyEqualPoint(a, b Point) bool {
	return roughlyEqualFloat64(a.X, b.X) &&
		roughlyEqualFloat64(a.Y, b.Y)
}

func assertRoughlyEqualPoints(t *testing.T, a, b Point) {
	if !roughlyEqualPoint(a, b) {
		t.Fatalf("Wanted %v Point, but got %v", b, a)
	}
}

//
//every clock has a centre of (150, 150)
//the hour hand is 50 long
//the minute hand is 80 long
//the second hand is 90 long.
//
func simpleTime(hours, minutes, seconds int) time.Time {
	return time.Date(312, time.October, 28, hours, minutes, seconds, 0, time.UTC)
}

func testName(t time.Time) string {
	return t.Format("12:04:05")
}

type Angle struct {
	time  time.Time
	angle float64
}

type Case struct {
	time  time.Time
	point Point
}

func TestSecondRadian(t *testing.T) {
	cases := []Angle{
		{simpleTime(0, 0, 0), 0},
		{simpleTime(0, 0, 30), math.Pi},
		{simpleTime(0, 0, 45), math.Pi * 3 / 2},
		{simpleTime(0, 0, 7), (math.Pi / 30) * 7},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := secondsRadian(c.time.Second())
			assertRoughlyEqualFloats(t, got, c.angle)
		})
	}
}

func TestSecondHandVector(t *testing.T) {
	cases := []Case{
		{simpleTime(0, 0, 0), Point{0, 1}},
		{simpleTime(0, 0, 30), Point{0, -1}},
		{simpleTime(0, 0, 45), Point{-1, 0}},
		//{simpleTime(0, 0, 7), Point{0,1}},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := secondHandPoint(c.time.Second())
			assertRoughlyEqualPoints(t, got, c.point)
		})
	}
}

func TestSecondHand(t *testing.T) {
	cases := []Case{
		{simpleTime(0, 0, 0), Point{150, 60}},
		{simpleTime(0, 0, 30), Point{150, 240}},
		{simpleTime(0, 0, 45), Point{60, 150}},
		{simpleTime(0, 0, 15), Point{240, 150}},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := SecondHand(c.time)
			assertRoughlyEqualPoints(t, got, c.point)
		})
	}
}

func angleMinute(minutes, seconds int) float64 {
	return math.Pi/(minutesInHalfClock/float64(minutes)) + math.Pi/(minutesInHalfClock*secondsInClock/float64(seconds))
}

func TestMinuteRadian(t *testing.T) {
	cases := []Angle{
		{simpleTime(0, 0, 0), angleMinute(0, 0)},
		{simpleTime(0, 0, 7), angleMinute(0, 7)},
		{simpleTime(0, 30, 30), angleMinute(30, 30)},
		{simpleTime(0, 45, 45), angleMinute(45, 45)},
		{simpleTime(0, 15, 15), angleMinute(15, 15)},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := minutesRadian(c.time)
			assertRoughlyEqualFloats(t, got, c.angle)
		})
	}
}

func TestMinuteHandVector(t *testing.T) {
	cases := []Case{
		{simpleTime(0, 0, 0), Point{0, 1}},
		{simpleTime(0, 30, 0), Point{0, -1}},
		{simpleTime(0, 45, 0), Point{-1, 0}},
		{simpleTime(0, 15, 0), Point{1, 0}},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := minuteHandPoint(c.time)
			assertRoughlyEqualPoints(t, got, c.point)
		})
	}
}

func TestMinuteHand(t *testing.T) {
	cases := []Case{
		{simpleTime(0, 0, 0), Point{150, 70}},
		{simpleTime(0, 30, 0), Point{150, 230}},
		{simpleTime(0, 45, 0), Point{70, 150}},
		{simpleTime(0, 15, 0), Point{230, 150}},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := MinuteHand(c.time)
			assertRoughlyEqualPoints(t, got, c.point)
		})
	}
}

func angleHour(hours, minutes, seconds int) float64 {
	return math.Pi/(hoursInHalfClock/float64(hours%hoursInClock)) + angleMinute(minutes, seconds)/hoursInClock
}

func TestHourRadian(t *testing.T) {
	cases := []Angle{
		{simpleTime(0, 0, 0), angleHour(0, 0, 0)},
		{simpleTime(6, 0, 30), angleHour(6, 0, 30)},
		{simpleTime(9, 0, 45), angleHour(9, 0, 45)},
		{simpleTime(21, 0, 45), angleHour(9, 0, 45)},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := hoursRadian(c.time)
			assertRoughlyEqualFloats(t, got, c.angle)
		})
	}
}

func TestHourVector(t *testing.T) {
	cases := []Case{
		{simpleTime(0, 0, 0), Point{0, 1}},
		{simpleTime(6, 0, 0), Point{0, -1}},
		{simpleTime(9, 0, 0), Point{-1, 0}},
		{simpleTime(3, 0, 0), Point{1, 0}},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := hourHandPoint(c.time)
			assertRoughlyEqualPoints(t, got, c.point)
		})
	}
}

func TestHourHand(t *testing.T) {
	cases := []Case{
		{simpleTime(0, 0, 0), Point{150, 100}},
		{simpleTime(6, 0, 0), Point{150, 200}},
		{simpleTime(9, 0, 0), Point{100, 150}},
		{simpleTime(3, 0, 0), Point{200, 150}},
	}
	for _, c := range cases {
		t.Run(testName(c.time), func(t *testing.T) {
			got := HourHand(c.time)
			assertRoughlyEqualPoints(t, got, c.point)
		})
	}
}
