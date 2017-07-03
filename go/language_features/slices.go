package main

import "fmt"

func main() {
	// Slices are typed only by the element types
	// Not the length, unlike arrays
	// Slice looks like an arraylist,
	// with slice operator
	// Type of int slice is []int

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

	// 1,2,3	
	c=s[1:]
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

    // Slice with len and capacity

    var p []int8
    p = make([]int8, 5, 10)
    fmt.Println(p, len(p), cap(p))
	
    // Nil Slice
    p = nil
    fmt.Println(p, len(p), cap(p))

    // Create a slice from an array
    m := [3]int {1,2,3}
    sl 	:= m[:]
    fmt.Println(sl)

    // Changing slice changes the original underlying array
    // Since slice points to the same data area

    p1 := [] int {1,2,3,4,5,6,7,8}
    p2 := p1[0:3]
    fmt.Println(p1)
    p2[0] = 99
    fmt.Println(p1)
}
