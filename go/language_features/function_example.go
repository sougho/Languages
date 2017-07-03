package main

import "fmt"

// Commong datatypes can be combined
// Can return multiple values

func main() {
	var i int
	i = add(3,4)
	fmt.Println(i)
	a, b := swap(2,3)
	fmt.Println(a,b)
	a, b = swap1(2,3)
	fmt.Println(a,b)
}

func add(i,j int) int {
	return i + j
}

func swap(i, j int) (int, int) {
	return j,i
}

// Named Return Values 

func swap1(i, j int) (x int, y int) {
	x = j
	y = i
	y = x + y
	k := x + 3 * y
	x = k
	return // Naked return - run by name match
}
