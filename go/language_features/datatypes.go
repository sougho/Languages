package main

import "fmt"

var b bool 
var s string

// int/uint are 32 bit on a 32 bit m/c
// and 64 bit on 64 bit m/c


var (
	i int
	i8 int8
	i16 int16
	i32 int32
	i64 int64
)

var (
        ui int
        ui8 int8
        ui16 int16
        ui32 int32
        ui64 int64
	uptr uintptr
)

var by byte // alias for unit8
var rr rune // alias for int32 - for unicode

var fl32 float32
var fl64 float64
var cl64 complex64
var cl128 complex128

const myage = 45

const MyBig = 1 << 100

func main() {
	cl64 = (2 + 3i)*(4+5i)
	fmt.Println(cl64)	
	// Uninitialized explicitly - zero value
	fmt.Println(i8)

        i = 42
	f := float64(i)
	u := uint(f)
	// u := f does not work - go does not do implicit conversion
	fmt.Println(u)

	// Type Inference

	v := 32
	fmt.Printf("%T\n", v);
	w := 32.0
	fmt.Printf("%T\n", w);
	m := w
	fmt.Printf("%T\n", m);

	fmt.Println(myage)

	// Can't assign to constant
	//myage = 3

	// Overflow
	fmt.Println(needInt(MyBig))

	
}


func needInt(x int) int { return x*10 + 1 }
func needFloat(x float64) float64 {
	return x * 0.1
}
