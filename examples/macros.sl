#macro A begin 
    10 
end
#macro B begin 
    A! + A! 
end
#macro C begin 
    2 * B! + 3 * A! 
end

proc main(argc int) int {
    a := A!
    b := B! + B!
    c := C!

    print(a, b, c)

    ret 0
}