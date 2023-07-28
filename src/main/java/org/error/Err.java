package org.error;

public class Err {
    public enum Errno {
        OK,
        ERR_VAR,
        ERR_TY,
        ERR_COND,
        ERR_CONST
    }
    public Errno errno;
    public int lineno;
    public String errMsg;

    public Err(Errno _errno, int _lineno, String _errMsg) {
        errno = _errno;
        lineno = _lineno;
        errMsg = _errMsg;
    }
}
