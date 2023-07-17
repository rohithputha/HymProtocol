package org.hitro.binaryprotocol.exceptions;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
public class HymProtocolException extends RuntimeException{
    private String message;
    private Exception exception;

    public HymProtocolException(String message, Exception e){
        super(message);
        this.message  = message;
        this.exception = e;
    }
    public HymProtocolException(Exception e){
        super(e.getCause());
        this.exception = e;
    }
}
