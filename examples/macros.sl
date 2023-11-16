#macro A { 10 }
#macro B { A! + A! }
#macro C { 2 * B! + 3 * A! }

proc main(argc int) int {
    a := A!
    b := B! + B!
    c := C!

    println(a, b, c)

    ret 0
}