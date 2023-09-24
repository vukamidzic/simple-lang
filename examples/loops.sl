proc main(argc int) int {
    i := 1
    while (i < 10) {
        (i < 5)? {
            println(i * i)
        }
        ()? {
            println((-1) * i * i)
        }

        i := i + 1
    }

    for (j <- 1,9) {
        (j < 5)? {
            println(j * j)
        }
        ()? {
            println((-1) * j * j)
        }
    }

    ret 0
}