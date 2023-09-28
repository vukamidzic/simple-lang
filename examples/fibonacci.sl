proc fib(n int) int {
    (n < 2)? { 
        ret n 
    }
    ()? { 
        ret fib(n - 1) + fib(n - 2)
    }
}

proc main(n int) int {
    n := 0
    input(addr(n))

    println(fib(n))

    ret 0
}