package main

import "fmt"

func main() {
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
}



