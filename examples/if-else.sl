proc main(argc int) int {
    n := 0
    input(addr(n))

    (n < 0)? {
        m := n * n
        (m > 20)? {
            print(m)
        }
    }
    (n > 0)? {
        print(n < 30)
    }
    ()? {
        print(false)
    }

    ret 0
}