package org.hitro.binaryprotocol.services.orchestrators.decode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.services.encodedecode.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataEncDecProvider<T> {
    private Map<DecodeSteps,EncDec> decodeStepsEncDecMap;
    private Map<Type,EncDec> typeEncDecMap;

    public DataEncDecProvider(DecodeOrchestrator decodeOrchestrator){
        decodeStepsEncDecMap = new ConcurrentHashMap<>();
        typeEncDecMap = new ConcurrentHashMap<>();

//        decodeStepsEncDecMap.put(DecodeSteps.START, null);
        decodeStepsEncDecMap.put(DecodeSteps.TYPE,  new TypeEncDec());
        decodeStepsEncDecMap.put(DecodeSteps.SIZE,  new SizeEncDec());

        typeEncDecMap.put(Type.STRING, new StringEncDec());
        typeEncDecMap.put(Type.DOUBLE, new DoubleEncDec());
        typeEncDecMap.put(Type.ARRAY,  new ArrayEncDec(decodeOrchestrator));
    }

    public T getDecodedData(byte[]data,DecodeSteps step){
        return (T)decodeStepsEncDecMap.get(step).validateAndDecode(data);
    }
    public T getDecodedData(byte[] data, Type dataType){
        return (T)typeEncDecMap.get(dataType).validateAndDecode(data);
    }

}
