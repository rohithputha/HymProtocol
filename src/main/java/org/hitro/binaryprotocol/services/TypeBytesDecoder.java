package org.hitro.binaryprotocol.services;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.coreconstants.Type;

import java.util.Arrays;

public class TypeBytesDecoder {

    private static boolean isEqual(byte[] input, byte[] protocolStandard){
        return Arrays.equals(input,protocolStandard);
    }
    private static byte[] convertToByteArray(byte a, byte b){
        return new byte[]{a,b};
    }
    public static Type getDatatypeFromBytes(byte a, byte b){
        return getDatatypeFromByteArray(convertToByteArray(a,b));
    }
    public static Type getDatatypeFromByteArray(byte[] input){
        if(isEqual(input, Constants.getStringTypeBytes())){
            return Type.STRING;
        }
        else if(isEqual(input,Constants.getDoubleTypeBytes())){
            return Type.DOUBLE;
        }
        return Type.ERROR;
    }
}
