#macro A |[ 5 ]|
#macro B |[ A! + A! ]|
#macro C |[ 2 * B! + 3 * A! ]|

#import "Basic"

proc main(x int) int {
    a := A!
    b := B! + B!
    c := C!

    print(a, b, c)

    ret 0
}
