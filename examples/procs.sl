proc add(x int, y int) int {
    ret x + y
}

proc sq(x int) int {
    ret x * x
}

proc main(argc int) int {
    a := 0 b := 0
    input(addr(a), addr(b))

    println(add(sq(a), sq(b)))

    ret 0
}