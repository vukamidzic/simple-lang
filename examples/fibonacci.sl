#import "Basic"

proc fib(n int) int {
    (n < 2)? { 
        ret n 
    }
    ()? { 
        ret fib(n - 1) + fib(n - 2)
    }
}

proc main(x int) int {
    n := 0
    input(@n)

    print(fib(n))

    ret 0
}