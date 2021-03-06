package sn.saint.bambilorjava.exception;

public enum ErrorCodes {
  USER_NOT_FOUND(1000),
  USER_NOT_VALID(1001),
  USER_NOT_EXIST(1002),

  POST_NOT_FOUND(2000),
  POST_NOT_VALID(2001),


  BAD_CREDENTIALS(0000),
  //ADMIN_ALREADY_IN_USE(2002),
  ;


  private int code;

  ErrorCodes(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
