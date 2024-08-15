package com.utils;

public class UnexpectedValueException extends Exception {
   public UnexpectedValueException( String s ) {
      super(s);
   }
   
   public UnexpectedValueException(  ) {
      super();
   }
}
