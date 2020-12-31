package main

import (
	"fmt"
	"time"
	"sync"
	"sync/atomic"
	"sort"
	"strings"
	"encoding/json"
)

type person struct {
	name string
	age  int
}

func worker(id int, jobs <-chan int, results chan<- int) {
	for i := range jobs {
		//time.Sleep(2 * time.Second)
		fmt.Printf("worker %d started job %d\n", id, i)
		time.Sleep(4 * time.Second)
		fmt.Printf("worker %d finished job %d\n", id, i)
		results <- i
	}
}

func jobs() {
	jobCount := 5
	jobs := make(chan int, jobCount)
	results := make(chan int, jobCount)

	for w := 1; w <= 3; w++ {
		go worker(w, jobs, results)
	}

	for j := 1; j <= jobCount; j++ {
		jobs <- j
	}
	close(jobs)

	for j := 1; j <= jobCount; j++ {
		<-results
	}
}

func atom() {
	var ops uint64
	var wg sync.WaitGroup
	for i := 0; i < 50; i++ {
		wg.Add(1)
		go func(i int) {
			for c := 0; c < 1000; c++ {
				atomic.AddUint64(&ops, 1)
				//ops++
			}
			wg.Done()
			fmt.Println("ops: ", atomic.LoadUint64(&ops), i)
			fmt.Println("ops - non: ", ops, i)
		}(i)
	}
	fmt.Println("ops: ", ops)
	wg.Wait()
}

type by []string

func (s by) Len() int {
	return len(s)
}

func (s by) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}
func (s by) Less(i, j int) bool {
	return len(s[i]) < len(s[j])
}

func sortBy() {
	fruits := []string{"peach", "kiwi", "banana"}
	sort.Sort(by(fruits))
	fmt.Println(fruits)
	sort.Strings(fruits)
	fmt.Println(fruits)
}
func main() {

	//sortBy()
json.Marshal()
	fmt.Println(strings.Replace("foo", "o", "0", 1))
	//b := []byte{'g', 'o', 'l', 'a', 'n', 'g'}
	//fmt.Println(b)
	//fmt.Println(b[:])

	//atom()
	//fmt.Println(&person{name: "Ann", age: 40})

	//i := 2
	//fmt.Print("Write ", i, " as ")
	//switch i {
	//case 1:
	//	fmt.Println("one")
	//case 2:
	//	fmt.Println("two")
	//case 3:
	//	fmt.Println("three")
	//}
	//
	//switch time.Now().Weekday() {
	//case time.Saturday, time.Sunday:
	//	fmt.Println("It's the weekend")
	//default:
	//	fmt.Println("It's a weekday")
	//}
	//
	//t := time.Now()
	//switch {
	//case t.Hour() < 12:
	//	fmt.Println("It's before noon")
	//default:
	//	fmt.Println("It's after noon")
	//}
	//
	//whatAmI := func(i interface{}) {
	//	switch t := i.(type) {
	//	case bool:
	//		fmt.Println("I'm a bool")
	//	case int:
	//		fmt.Println("I'm an int")
	//	case string:
	//		fmt.Println("I'm a string")
	//	default:
	//		fmt.Printf("Don't know type %T\n", t)
	//	}
	//}
	//whatAmI(true)
	//whatAmI(1)
	//whatAmI("hey")
	//
	//c := make([]string, 9)
	//copy()
}
