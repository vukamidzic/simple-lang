# SimpleLang

## About

(**WORK IN PROGRESS!!**) Another hobby language with goal of improving knowledge about compilers. It translates to LLVM IR and, later on, into an executable.
## Technologies used

- Front-end -> [ANTLR](https://www.antlr.org/) (Java)
- Back-end -> [LLVM](https://llvm.org/)

## Info about the language

- arithmetic operations ('+', '-', '\*', '/')
- comparing operations ('>', '<', '=', '/=')
- logic operations ('and', 'or')
- if-else, for-loop and while-loop statements
- fixed-size arrays 
- pointers ('@', *only used for passing the address*)
- functions
- libraries (*yet to be expanded*)
- macros (```#import``` for including libraries into compilation and ```#macro |[ (expression | statements) ]|``` for custom user-defined macros)

## Requirements
Java| LLVM
---|---
20 (preferably) |17.0.1
## Examples

You can find the examples in the ```examples``` folder.
