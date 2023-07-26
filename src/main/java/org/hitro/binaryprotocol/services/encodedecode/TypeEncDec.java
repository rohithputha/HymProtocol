package org.hitro.binaryprotocol.services.encodedecode;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.coreconstants.Type;

import java.util.Arrays;

public class TypeEncDec extends EDCore<Type> {

    private boolean isEqual(byte[] input, byte[] protocolStandard){
        return Arrays.equals(input,protocolStandard);
    }
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return data.length==2 && data[0]==Constants.getBackslash();
    }

    @Override
    protected boolean focusEncValidation(Type data) {
        return true;
    }

    @Override
    protected Type decode(byte[] data) {
        if(isEqual(data, Constants.getStringTypeBytes())){
            return Type.STRING;
        }
        else if(isEqual(data,Constants.getDoubleTypeBytes())){
            return Type.DOUBLE;
        }
        else if(isEqual(data,Constants.getArrayTypeBytes())){
            return Type.ARRAY;
        }
        return Type.ERROR;
    }

    @Override
    protected byte[] encode(Type data) {
        if(data == Type.STRING){
            return Constants.getStringTypeBytes();
        }
        else if(data == Type.DOUBLE){
            return Constants.getDoubleTypeBytes();
        }
        else if(data == Type.ARRAY){
            return Constants.getArrayTypeBytes();
        }
        return new byte[2]; // change to Error bytes...
    }

}
