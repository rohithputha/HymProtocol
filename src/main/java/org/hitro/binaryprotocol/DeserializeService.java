package org.hitro.binaryprotocol;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.exceptions.HymProtocolException;

public class DeserializeService<T> implements Runnable{

    private byte[] bitData;
    private int l;
    private int r;

    public DeserializeService(byte[] bitData, int l, int r){
        this.bitData= bitData;//should it clone the array
        this.l = l;
        this.r = r;
    }

    public <T> T start(){
        try{
            if(this.bitData[l]== Constants.getBackslash() && this.bitData[l+1]== Constants.getHByte()){
                this.l+=2;
                return this.getDatatype();
            }
        }
        catch (Exception e){
            throw new HymProtocolException("Message does not start with the protocol standards", e);
        }
        throw new HymProtocolException("Message does not start with the protocol standards", new RuntimeException());
    }
    private <T> T getDatatype(){
        return null;
    }
    @Override
    public void run() {

    }
}
