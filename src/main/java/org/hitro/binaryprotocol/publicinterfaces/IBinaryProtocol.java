package org.hitro.binaryprotocol.publicinterfaces;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.services.orchestrators.Orchestrator;
import org.hitro.binaryprotocol.services.orchestrators.decode.DecodeOrchestrator;
import org.hitro.binaryprotocol.services.orchestrators.encode.EncodeOrchestrator;

public class IBinaryProtocol<T> implements BinaryProtocol<T>{
    private DecodeOrchestrator decodeOrchestrator;

    private Orchestrator encodeOrchestrator;
    private IBinaryProtocol(){
        this.decodeOrchestrator =new DecodeOrchestrator<>();
        this.encodeOrchestrator = new EncodeOrchestrator<>();
    }

    @Override
    public T decode(byte[] data) {
        return (T)this.decodeOrchestrator.decodeBytes(data);
    }

    @Override
    public byte[] encode(T data) {
        byte[] dataModule =  (byte[]) encodeOrchestrator.orchestrate(data);
        byte[] commandSep = Constants.getModuleTerminationBytes();
        byte[] combinedArray = new byte[dataModule.length + commandSep.length];
        System.arraycopy(dataModule, 0, combinedArray, 0, dataModule.length);
        System.arraycopy(commandSep, 0, combinedArray, dataModule.length, commandSep.length);
        return combinedArray;
    }

    private static BinaryProtocol binaryProtocol;
    public static BinaryProtocol getInstance(){
        if(binaryProtocol==null){
            synchronized (IBinaryProtocol.class){
                if(binaryProtocol==null){
                    binaryProtocol = new IBinaryProtocol();
                }
            }
        }
        return binaryProtocol;
    }
}
