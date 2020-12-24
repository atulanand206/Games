package clock

import (
	"encoding/xml"
	"fmt"
	"io"
	"time"
)

type SVG struct {
	XMLName xml.Name `xml:"svg"`
	Text    string   `xml:",chardata"`
	Xmlns   string   `xml:"xmlns,attr"`
	Width   string   `xml:"width,attr"`
	Height  string   `xml:"height,attr"`
	ViewBox string   `xml:"viewBox,attr"`
	Version string   `xml:"version,attr"`
	Circle  Circle   `xml:"circle"`
	Line    []Line   `xml:"line"`
}

type Circle struct {
	Cx float64 `xml:"cx,attr"`
	Cy float64 `xml:"cy,attr"`
	R  float64 `xml:"r,attr"`
}

type Line struct {
	X1 float64 `xml:"x1,attr"`
	Y1 float64 `xml:"y1,attr"`
	X2 float64 `xml:"x2,attr"`
	Y2 float64 `xml:"y2,attr"`
}

const svgStart = `<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
<svg xmlns="http://www.w3.org/2000/svg"
     width="100%"
     height="100%"
     viewBox="0 0 300 300"
     version="2.0">`

const bezel = `<circle cx="150" cy="150" r="100" style="fill:#fff;stroke:#000;stroke-width:5px;"/>`

const svgEnd = `</svg>`

func secondHandTag(p Point) string {
	return fmt.Sprintf(`<line x1="150" y1="150" x2="%.3f" y2="%.3f" style="fill:none;stroke:#f00;stroke-width:3px;"/>`, p.X, p.Y)
}

func minuteHandTag(p Point) string {
	return fmt.Sprintf(`<line x1="150" y1="150" x2="%f" y2="%f" style="fill:none;stroke:#000;stroke-width:5px;"/>`, p.X, p.Y)
}

func hourHandTag(p Point) string {
	return fmt.Sprintf(`<line x1="150" y1="150" x2="%f" y2="%f" style="fill:none;stroke:#000;stroke-width:5px;"/>`, p.X, p.Y)
}

func SvgWriter(writer io.Writer, tm time.Time) {
	SvgHeader(writer)
	SvgClock(writer, tm)
	SvgFooter(writer)
}

func SvgClock(writer io.Writer, tm time.Time) {
	io.WriteString(writer, secondHandTag(SecondHand(tm)))
	io.WriteString(writer, minuteHandTag(MinuteHand(tm)))
	io.WriteString(writer, hourHandTag(HourHand(tm)))
}

func SvgHeader(writer io.Writer) {
	io.WriteString(writer, svgStart)
	io.WriteString(writer, bezel)
}

func SvgFooter(writer io.Writer) {
	io.WriteString(writer, svgEnd)
}
