package main

import "fmt"

func main() {
	sum (1,2,3,4)	
}

func sum (nums ... int) {
	fmt.Print(nums)
	total :=0
	for _,val := range nums {
		total = total + val
	}
	fmt.Println(total)
}
