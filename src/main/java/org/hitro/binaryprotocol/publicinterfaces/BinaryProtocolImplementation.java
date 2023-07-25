package org.hitro.binaryprotocol.publicinterfaces;

import org.hitro.binaryprotocol.services.orchestrators.decode.DecodeOrchestrator;

public class BinaryProtocolImplementation<T> implements BinaryProtocol<T>{
    private DecodeOrchestrator decodeOrchestrator;
    private BinaryProtocolImplementation(){
        this.decodeOrchestrator =new DecodeOrchestrator<>();
    }

    @Override
    public T decode(byte[] data) {
        return (T)this.decodeOrchestrator.decodeBytes(data);
    }

    @Override
    public byte[] encode(T data) {
        return new byte[0];
    }

    private static BinaryProtocol binaryProtocol;
    public BinaryProtocol getInstance(){
        if(binaryProtocol==null){
            synchronized (BinaryProtocolImplementation.class){
                if(binaryProtocol==null){
                    binaryProtocol = new BinaryProtocolImplementation();
                }
            }
        }
        return binaryProtocol;
    }
}
