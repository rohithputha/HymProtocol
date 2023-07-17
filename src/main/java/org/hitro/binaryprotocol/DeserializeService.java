package org.hitro.binaryprotocol;

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
            if(this.bitData[l]==92 && this.bitData[l+1]==104){
                this.l +=2;
                return this.getDatatype();
            }
        }
        catch (Exception e){
            throw e;
        }
        return null;
    }
    public <T> T getDatatype(){
        return null;
    }
    @Override
    public void run() {

    }
}
