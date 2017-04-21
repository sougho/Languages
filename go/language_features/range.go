package main

import "fmt"

func main() {

	// Range over array
	nums := []int{2,3,4}
	// index: i, value : j
	for i,j := range nums {
		fmt.Println(i, j)
	}

	// ignore the index
	for _,j := range nums {
		fmt.Println(j)
	}

	// Range over maps
	// Iterates over key value pairs	

	kvs := map[string]string {"a":"apple", "o":"oranges"}

	fmt.Println(kvs)

	for k,v := range kvs {
		fmt.Println(k,v)
	}

	// Only keys

	for k := range kvs {
		fmt.Println(k)
	}
	
	// Range over string
	// Iterates over unicode 

	for s,t := range "khukibuki" {
		fmt.Println(s,t)
	}

}
