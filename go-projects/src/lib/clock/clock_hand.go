package clock

import (
	"time"
	"math"
)

type Point struct {
	X float64
	Y float64
}

const (
	secondsInHalfClock = 30
	secondsInClock     = 2 * secondsInHalfClock
	minutesInHalfClock = 30
	minutesInClock     = 2 * minutesInHalfClock
	hoursInHalfClock   = 6
	hoursInClock       = 2 * hoursInHalfClock
	lengthOfSecondHand = 90.0
	lengthOfMinuteHand = 80.0
	lengthOfHourHand   = 50.0
	centerX            = 150
	centerY            = 150
)

func SecondHand(tm time.Time) Point {
	return scalePoint(secondHandPoint(tm.Second()), lengthOfSecondHand)
}

func MinuteHand(tm time.Time) Point {
	return scalePoint(minuteHandPoint(tm), lengthOfMinuteHand)
}

func HourHand(tm time.Time) Point {
	return scalePoint(hourHandPoint(tm), lengthOfHourHand)
}

func secondHandPoint(tm int) Point {
	return anglePoint(secondsRadian(tm))
}

func minuteHandPoint(tm time.Time) Point {
	return anglePoint(minutesRadian(tm))
}

func hourHandPoint(tm time.Time) Point {
	return anglePoint(hoursRadian(tm))
}

func secondsRadian(tm int) float64 {
	return math.Pi / (secondsInHalfClock / float64(tm))
}

func minutesRadian(tm time.Time) float64 {
	return math.Pi/(minutesInHalfClock/float64(tm.Minute())) + secondsRadian(tm.Second())/minutesInClock
}

func hoursRadian(tm time.Time) float64 {
	return math.Pi/(hoursInHalfClock/float64(tm.Hour()%hoursInClock)) + minutesRadian(tm)/hoursInClock
}

func scalePoint(point Point, length float64) Point {
	point = Point{point.X * length, point.Y * length}
	point = Point{point.X, -point.Y}
	point = Point{point.X + centerX, point.Y + centerY}
	return point
}

func anglePoint(angle float64) Point {
	return Point{math.Sin(angle), math.Cos(angle)}
}
