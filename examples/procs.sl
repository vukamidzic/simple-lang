proc f(a array, x int) int {
    n := len(a)
    l := 0
    d := n - 1

    while (l < d or l = d) {
        s := (l + d) / 2
        e := get(a, s)

        (e = x)? { ret s }
        (e > x)? { d := s }
        ()? { l := s + 1 }
    }    

    ret -1
}

proc main(argc int) int {
    n := 0
    input(addr(n))

    a := newArray(n, 0)
    for (i <- 0,n - 1) {
        t := 0
        input(addr(t))
        put(a, i, t)
    }

    x := 0
    input(addr(x))

    b := f(a, x)
    println(b)

    ret 0
}