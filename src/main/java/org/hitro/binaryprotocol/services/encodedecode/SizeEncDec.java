package org.hitro.binaryprotocol.services.encodedecode;

import org.hitro.binaryprotocol.coreconstants.Constants;

public class SizeEncDec extends EDCore<Integer> {
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return data.length>2 && data[0]== Constants.getSizeStartEndByte() && data[data.length-1] == Constants.getSizeStartEndByte();
    }

    @Override
    protected boolean focusEncValidation(Integer data) {
        return true;
    }

    private boolean isValidSizeContent(byte st){
        return st>=48 && st<=57;
    }
    @Override
    protected Integer decode(byte[] data) {
        int l=1;
        int size = 0;
        while(isValidSizeContent(data[l])){
            size = (size*10)+(data[l]-48);
            l+=1;
        }
        return size;
    }

    @Override
    protected byte[] encode(Integer data) {
        char[] sizeChar = Integer.toString(data).toCharArray();
        byte[] sizeBytes = new byte[sizeChar.length+2];
        int l = 0;
        while(l<sizeChar.length){
            sizeBytes[l+1] =(byte) sizeChar[l];
            l++;
        }
        sizeBytes[0] = Constants.getSizeStartEndByte();
        sizeBytes[sizeBytes.length-1]= Constants.getSizeStartEndByte();
        return sizeBytes;
    }
}
