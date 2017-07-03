package main

import "fmt"

func f (from string) {

	for i := 0;i<10;i++ {
		fmt.Println(from , ":" , i)	
	}

}

func main() {
	//f("sync")
	go f("goroutine")
	var input string
	fmt.Scanln(&input)
    	fmt.Println("done")
}
