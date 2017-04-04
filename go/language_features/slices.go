package main

import "fmt"

func main() {
	// Slices are typed only by the element types
	// Not the length, unlike arrays
	// Slice looks like an arraylist,
	// with slice operator

	s:= make([]string, 3)
	fmt.Println(s)
	// Element access is just like arrays
	s[0] = "a"
	s[1] = "b"
	s[2] = "c"
	fmt.Println(s)

	// Append 
	s=append(s,"d")
	fmt.Println(s)

	// Copy
	c:=make([]string, 1)
	copy(c,s)

	// Slice Op
	// Starting from first, less than last
	// 0, 1 in this case
	c=s[0:2]
	fmt.Println(c)

	// 0,1,2	
	c=s[:3]
	fmt.Println(c)

	// Short declaration for slice
	t:=[]string {"a", "b", "c"}
	fmt.Println(t)

	// 2d slices
	// 1d components can be of different length
	// Unlike Arrays
	twoD := make([][]int, 3)
    	for i := 0; i < 3; i++ {
        innerLen := i + 1
        twoD[i] = make([]int, innerLen)
        for j := 0; j < innerLen; j++ {
            twoD[i][j] = i + j
        }
    }
    fmt.Println("2d: ", twoD)
}
