package org.hitro.binaryprotocol.services.encodedecode;

import org.hitro.binaryprotocol.coreconstants.Constants;

public class SizeEncDec extends EDCore<Integer> {
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return data.length>2 && data[0]== Constants.getSizeStartEndByte() && data[data.length-1] ==Constants.getSizeStartEndByte();
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
        String stringVer = Integer.toString(data);
        byte[] sizeBytes = new byte[stringVer.length()+2];
        int l = 0;
        while(l<stringVer.length()){
            sizeBytes[l+1]= stringVer.
        }
        return
    }
}
