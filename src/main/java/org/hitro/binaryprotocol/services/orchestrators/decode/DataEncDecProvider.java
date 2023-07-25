package org.hitro.binaryprotocol.services.orchestrators.decode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.services.encodedecode.*;

import java.util.HashMap;
import java.util.Map;

public class DataEncDecProvider<T> {
    private Map<DecodeSteps, ThreadLocal<EncDec>> decodeStepsEncDecMap;
    private Map<Type,ThreadLocal<EncDec>> typeEncDecMap;

    public DataEncDecProvider(DecodeOrchestrator decodeOrchestrator){
        decodeStepsEncDecMap = new HashMap<>();
        typeEncDecMap = new HashMap<>();

        decodeStepsEncDecMap.put(DecodeSteps.START, null);
        decodeStepsEncDecMap.put(DecodeSteps.TYPE, ThreadLocal.withInitial(()-> new TypeEncDec()));
        decodeStepsEncDecMap.put(DecodeSteps.SIZE,ThreadLocal.withInitial(()->new SizeEncDec()));

        typeEncDecMap.put(Type.STRING,ThreadLocal.withInitial(()->new StringEncDec()));
        typeEncDecMap.put(Type.DOUBLE,ThreadLocal.withInitial(()-> new DoubleEncDec()));
        typeEncDecMap.put(Type.ARRAY, ThreadLocal.withInitial(()->new ArrayEncDec(decodeOrchestrator)));
    }

    public T getDecodedData(byte[]data,DecodeSteps step){
        return (T)decodeStepsEncDecMap.get(step).get().validateAndDecode(data);
    }
    public T getDecodedData(byte[] data, Type dataType){
        return (T)typeEncDecMap.get(dataType).get().validateAndDecode(data);
    }

}
