package main

import "fmt"

func incFunc (k int) func() int {
	i := k
	return func() int {
		i+=1
		return i
	}
}

func main() {
	f1 := incFunc(1)
	f2 := incFunc(20)

	fmt.Println(f1())
	fmt.Println(f1())
	fmt.Println(f2())
	fmt.Println(f2())
}
