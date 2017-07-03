package main

import "fmt"

type person struct {
	name string
	age int
}

func main() {

	p1 := person { name : "ABC", age : 39}
	fmt.Println(p1)
	fmt.Println(p1.name)
	sp := &p1
	fmt.Println(sp.name)
	
}
