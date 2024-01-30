#!/bin/bash

set -x

# ----------- PATHS FOR THE LIBS AND CONFIG ----------
CONFIG="src/main/java/org/library/config.h"
LIB="src/main/java/org/library/lib.c"
# ----------------------------------------------------

# ------------------ REMOVE COMMENTS --------------------------
echo $(cat $1.sl) | perl -pe "s{\-\-\{.*\}\-\-}{}g" > tmp.sl
# -------------------------------------------------------------

# -------- WRITE #import INFO INTO CONFIG -------
# -------- AND REMOVE IT FROM FINAL FILE --------
grep -oE "\#import\s*\"[^\"]*?\"" tmp.sl |\
perl -pe "s{\#import\s*\"([^\"]*?)\"}{\1}g" |\
tr [[:lower:]] [[:upper:]] |\
perl -pe "s{([A-Z]+)}{\#define \1}g" > $CONFIG
perl -pe "s{\#import\s*\"(.*?)\"}{}g" tmp.sl > final.sl
# ------------------------------------------------


# ------------ BUILD LIB FUNCTIONS ----------------
# ------ AND LINK LIBS WITH COMPILED PROGRAM ------
diff -w tmp.sl prev.sl
if [[ $? -eq 1 || $? -eq 2 ]]; then 
    cat tmp.sl > prev.sl
    clang -S -emit-llvm $LIB -o lib.ll
    java -jar target/simple-lang.jar final.sl > $1.ll
    clang lib.ll $1.ll -o $1
    rm -rf tmp.sl final.sl
fi;
# -------------------------------------------------