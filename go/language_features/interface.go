package main

import "fmt"
import "math"

type geometry interface {
	area () float64
	perim () float64
}

type rect struct {
	width, height float64
}

type circle struct {
	radius float64
}

func (r rect) perim () float64 {
	return (2*r.width + 2*r.height)
}

func (r rect) area () float64 {
	return r.width * r.height
}

func (c circle) area () float64 {
	return math.Pi*c.radius*c.radius
}

func (c circle) perim () float64 {
	return 2*math.Pi*c.radius
}

type triangle struct {
	base, height float64
}

func (t triangle) area() float64 {
	return 2
}

func (t triangle) perim() float64 {
	return 3
}

/*
func (t triangle) perim() (float64,float64) {
	return 3,3
}
*/

func measure(g geometry) {
	fmt.Println(g.area())
	fmt.Println(g.perim())	
}

func somefunc(interface {}) (int) {
	return 1
}

func main()  {

	fmt.Println("Interfaces");
	c := circle{radius:5}
	r := rect{width:3, height: 4}
	t := triangle{base:2, height:3}
	measure(c)
	measure(r)
	measure(t)
}
