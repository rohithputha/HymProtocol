package org.hitro.binaryprotocol.services.encodedecode;

import org.hitro.binaryprotocol.exceptions.HymProtocolException;

public abstract class MultiElementED<T> implements EncDec<T> {
    protected boolean decValidation(byte[] data){
        if(data.length < 1)
            return false;
        return focusDecValidation(data);
    }

    public T validateAndDecodeWithElementsInfo(byte[] data,int numElements){
        if(!decValidation(data)){
            raiseEncDecException("byte data validation failed");
            return null;
        }
        return decode(data, numElements);
    }

    public byte[] validateAndEncode(T data){
        //validation steps;
        return encode(data);
    }
    protected void raiseEncDecException(String message){
        throw new HymProtocolException("EncDec Exception: "+message,new RuntimeException());
    }
    protected abstract boolean focusDecValidation(byte[] data);
    protected abstract T decode(byte[] data, int numElements);
    protected abstract byte[] encode(T data);
}
