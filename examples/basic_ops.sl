proc main(argc int) int {
    a := 1
    b := a + a + a
    print(a, b * b)

    c := b > 5
    d := c and true
    print(c or d)

    ret 0
}