package main

import "fmt"

type person struct {
	name string
	age int8
}

// Method on struct peson

func (p *person)getAge() int8 {
	return p.age
}

func (p person)getName() string {
	return p.name
}

func main() {
	me := person{name:"soumen", age:45}
	fmt.Println(me)
	fmt.Println(me.getName())
}
