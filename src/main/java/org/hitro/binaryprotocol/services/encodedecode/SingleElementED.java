package org.hitro.binaryprotocol.services.encodedecode;

import org.hitro.binaryprotocol.exceptions.HymProtocolException;

public abstract class SingleElementED<T> implements EncDec<T> {

    public T validateAndDecode(byte[] data){
        if(!decValidation(data)){
            raiseEncDecException("byte data validation failed");
            return null;
        }
        return decode(data);
    }

    public byte[] validateAndEncode(T data){
        //validation steps;
        return encode(data);
    }
    protected void raiseEncDecException(String message){
        throw new HymProtocolException("EncDec Exception: "+message,new RuntimeException());
    }
    protected boolean decValidation(byte[] data){
        if(data.length < 1)
            return false;
        return focusDecValidation(data);
    }
    protected abstract boolean focusDecValidation(byte[] data);
    protected abstract T decode(byte[] data);
    protected abstract byte[] encode(T data);
}
