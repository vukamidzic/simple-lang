#import "Basic"

proc main(x int) int {
    n := 0
    errno := input(@n)

    i := 1
    while (i < n) {
        (i < 5)? {
            print(i * i)
        }
        ()? {
            print((-1) * i * i)
        }

        i := i + 1
    }

    for (j <- 1,n - 1) {
        (j < 5)? {
            print(j * j)
        }
        ()? {
            print((-1) * j * j)
        }
    }

    ret 0
}