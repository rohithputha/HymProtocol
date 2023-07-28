package org.hitro.binaryprotocol.publicinterfaces;

import org.hitro.binaryprotocol.services.orchestrators.Orchestrator;
import org.hitro.binaryprotocol.services.orchestrators.decode.DecodeOrchestrator;
import org.hitro.binaryprotocol.services.orchestrators.encode.EncodeOrchestrator;

public class BinaryProtocolImplementation<T> implements BinaryProtocol<T>{
    private DecodeOrchestrator decodeOrchestrator;

    private Orchestrator encodeOrchestrator;
    private BinaryProtocolImplementation(){
        this.decodeOrchestrator =new DecodeOrchestrator<>();
        this.encodeOrchestrator = new EncodeOrchestrator<>();
    }

    @Override
    public T decode(byte[] data) {
        return (T)this.decodeOrchestrator.decodeBytes(data);
    }

    @Override
    public byte[] encode(T data) {
        return (byte[]) encodeOrchestrator.orchestrate(data);
    }

    private static BinaryProtocol binaryProtocol;
    public static BinaryProtocol getInstance(){
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
