package org.hitro.binaryprotocol.services.encodedecode;

import org.hitro.binaryprotocol.exceptions.HymProtocolException;

public abstract class EDCore<T> implements EncDec<T> {

    public T validateAndDecode(byte[] data){
        if(!decValidation(data)){
            raiseEncDecException("byte data validation failed");
            return null;
        }
        return decode(data);
    }

    public byte[] validateAndEncode(T data){
        if(!encValidation(data)){
            raiseEncDecException("encoding data validation failed");
        }
        return encode(data);
    }
    protected void raiseEncDecException(String message){
        throw new HymProtocolException("EncDec Exception: "+message,new RuntimeException());
    }

    protected boolean encValidation(T data){
        return data!=null && focusEncValidation(data);
    }
    protected boolean decValidation(byte[] data){
        return data.length>0 && focusDecValidation(data);
    }
    protected abstract boolean focusDecValidation(byte[] data);
    protected abstract boolean focusEncValidation(T data);
    protected abstract T decode(byte[] data);
    protected abstract byte[] encode(T data);
}
