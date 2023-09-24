proc main(argc int) int {
    a := 1
    b := a + a + a
    println(a, b * b)

    c := b > 5
    d := c and true
    println(c or d)

    ret 0
}