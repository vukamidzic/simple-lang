proc main(argc int) int {
    n := 0
    input(ptr(n))

    (n < 0)? {
        m := n * n
        (m > 20)? {
            println(m)
        }
    }
    (n > 0)? {
        println(n < 30)
    }
    ()? {
        println(false)
    }

    ret 0
}