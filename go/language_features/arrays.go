package main

import "fmt"

func main() {

	// Array types are the datatype + length
	// int[4] is different type than int[5]

	// Vanilla 
	var a[5] int;
	a[0] = 2;
	fmt.Println(a[0])
	fmt.Println(a)
	// Short declaration
	b := [5]int{1,2,3,4,5}
	fmt.Println(b);
	// Two D Array
	twod := [3][3] int {{1,2,3}, {2,3,4}, {3,4,5}}
	fmt.Println(twod);
	// Compiler calculates length
	c:=[...]int {1,2,3}
	fmt.Println(c)
}



