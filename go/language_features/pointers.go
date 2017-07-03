package main

import "fmt"

// Pointers - like good old days
// 

func main() {
	i := 4
	j := 5
	fmt.Println(swap(&i,&j))
}

func swap(i *int, j *int)(int, int) {
	tmp := *i
	*i = *j;
	*j = tmp
	return *i, *j
}
