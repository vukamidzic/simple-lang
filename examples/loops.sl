proc main(argc int) int {
    n := 0
    input(addr(n))

    i := 1
    while (i < n) {
        (i < 5)? {
            println(i * i)
        }
        ()? {
            println((-1) * i * i)
        }

        i := i + 1
    }

    for (j <- 1,n - 1) {
        (j < 5)? {
            println(j * j)
        }
        ()? {
            println((-1) * j * j)
        }
    }

    ret 0
}