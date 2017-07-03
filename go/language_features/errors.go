package  main

import "fmt"
import "errors"

/*
   go handles errors by a specific return value
   which is the last one and of type error 
   or any interface which implements error
   
*/

/* Custom error types are possible, all they need to do 
   is to implement the Error() method in them
*/

type argError struct {
	arg int
	msg string
}

func (e *argError) Error() string {
	return fmt.Sprintf("%d - %s", e.arg, e.msg)
}

func f(arg int) (int, error) {
	if arg == 42 {
		return -1,errors.New("OMG!! 42")
	} else {
		return 2*arg, nil
	}
}

func f(arg int) (int, error) {
        if arg == 42 {
                return -1,errors.New("OMG!! 42")
        } else {
                return 2*arg, nil
        }
}


func main() {
	for _,i := range [] int {7,42} {
		if r,e := f(i); e!= nil {
			fmt.Println("Fail!! :" , e)
		} else {
			fmt.Println("Worked: " , r)
		}
		
	}
}
