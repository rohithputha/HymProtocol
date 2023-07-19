package org.hitro.binaryprotocol.services;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.exceptions.HymProtocolException;

public class SizeBytesDecoder {
    private static boolean isValidSizePacket(byte st){
        return Constants.getSizeStartEndByte() == st;
    }
    private static boolean isValidSizeContent(byte st){
        return st>=48 && st<=57;
    }
    public static int[] getSizeFromBytesArray(byte[] input, int l){
        if(!isValidSizePacket(input[l]))
            throw new HymProtocolException("Size packet is not according to the standard protocol",new RuntimeException());
        l+=1;
        int size = 0;
        while(!isValidSizeContent(input[l])){
            size = (size*10)+(input[l]-48);
            l+=1;
        }
        if(!isValidSizePacket(input[l]))
            throw new HymProtocolException("Size packet is not according to the standard protocol",new RuntimeException());
        l+=1;
        return new int[]{size,l};
    }
}
