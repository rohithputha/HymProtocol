package org.hitro.binaryprotocol.services.orchestrators.encode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.services.encodedecode.*;
import org.hitro.binaryprotocol.services.orchestrators.Orchestrator;
import org.hitro.binaryprotocol.services.orchestrators.decode.DecodeOrchestrator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataEncProvider<T> {
    private Map<DecodeSteps,EncDec> decodeStepsEncDecMap;
    private Map<Type,EncDec> typeEncDecMap;
    public DataEncProvider(Orchestrator orchestrator){
        decodeStepsEncDecMap = new ConcurrentHashMap<>();
        typeEncDecMap = new ConcurrentHashMap<>();

//        decodeStepsEncDecMap.put(DecodeSteps.START, null);
        decodeStepsEncDecMap.put(DecodeSteps.TYPE,  new TypeEncDec());
        decodeStepsEncDecMap.put(DecodeSteps.SIZE,  new SizeEncDec());

        typeEncDecMap.put(Type.STRING, new StringEncDec());
        typeEncDecMap.put(Type.DOUBLE, new DoubleEncDec());
        typeEncDecMap.put(Type.ARRAY,  new ArrayEncDec(orchestrator));
    }

    public byte[] getEncodedData(T data, DecodeSteps step){
        return decodeStepsEncDecMap.get(step).validateAndEncode(data);
    }
    public byte[] getEncodedData(T data, Type dataType){
        return typeEncDecMap.get(dataType).validateAndEncode(data);
    }
}
