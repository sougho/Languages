package main
import "fmt"

func main() {
	// Use make for creating a new Map
	u := make(map[string]int8)
	fmt.Println(u)
	u["soumen"] = -127
	u["ghosh"] = -127
	u["sujit"] = 1 
	u["gauss"] = 0
	fmt.Println(u)
	fmt.Println(u["soumen"])

	// no of keys
	fmt.Println(len(u))
	// remove is called delete
	delete(u, "soumen") // good riddance
	fmt.Println(u)
	// Second argument returns if the key was present 
	// or not existing interpreted as 0
	// Q - no exception mechanism?
	a,b := u["soumen"]
	fmt.Println(a,b)
	a,b = u["gauss"]
	fmt.Println(a,b)
}
