package main

import "fmt"

func main() {

  /**** LOOPS *****/
  
  // Open Loop
  for {
  	fmt.Println("Breaking.. ");
  	break;
  }
  
  // Single condition basic loop
  var i int8 = 0;
  for i<=3 {
  	fmt.Println(i);
  	i=i+1
  }
  
  // Conventional for loop
  for n:=0; n<=10; n++ {
  	if (n%2==0) {
  		fmt.Println(n);
  	}
  }
  
  /***** IF *****/
  
  // Normal IF
  // brackets are not needed around conditions
  // but can be given
  
  if 7%2==0 {
  	fmt.Println("even")
  } else {
  	fmt.Println("odd")
  }
  
  if (7%2==0) {
  	fmt.Println("even")
  } else {
  	fmt.Println("odd")
  }
  
  // Statement before conditional
  
  if fmt.Println("before..");2 > 0 {
  	fmt.Println("Num positive")
  }
  
  /******* SWITCH ********/
  // Vanilla Switch
  j := 2
  switch j {
  	case 1,2,3: 
  		fmt.Println("First Case")
  	default :
  		fmt.Println("Default")
  }
  
  // Switch w/o expression is allowed
  // A way to implement IF

  switch {
	case ((j > 0) && (2 > 1)): 
		fmt.Println("Positive")
        default :
		fmt.Println("NegOr0")	
  }

  knowMe := func(i interface{}) {
	switch t:=i.(type) {
		case bool: 
			fmt.Println("Boolean")
		case int:
			fmt.Println("Integer")
		default :
			fmt.Println("%T", t)
	}
  }

  knowMe(1)
  knowMe("String")
}
