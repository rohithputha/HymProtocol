package org.hitro.binaryprotocol;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.exceptions.HymProtocolException;
import org.hitro.binaryprotocol.services.TypeBytesDecoder;

public class DeserializeService<T> implements Runnable{

    private byte[] bitData;
    private int l;
    private int r;

//    public DeserializeService(byte[] bitData, int l, int r){
//        this.bitData= bitData;//should it clone the array
//        this.l = l;
//        this.r = r;
//    }

    public static <T> T start(byte[] byteData, int l, int r){
        try{
            if(byteData[l]== Constants.getBackslash() && byteData[l+1]== Constants.getHByte()){
                return getDatatype(byteData, l+2,r);
            }
        }
        catch (Exception e){
            throw new HymProtocolException("Message does not start with the protocol standards", e);
        }
        throw new HymProtocolException("Message does not start with the protocol standards", new RuntimeException());
    }

    private static <T> T getDatatype(byte[] byteData, int l, int r){
        Type datatype = TypeBytesDecoder.getDatatypeFromBytes(byteData[l],byteData[l+1]);
        return getSize(byteData,l+2, r,datatype);
    }

    private static <T> T getSize(byte[] byteData, int l, int r, Type datatype){

    }
    @Override
    public void run() {

    }
}
