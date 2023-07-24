package org.hitro.binaryprotocol.services.orchestrators.decode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.services.dataextractor.*;
import org.hitro.binaryprotocol.services.encodedecode.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DecodeOrchestrator<T> {
    private Map<DecodeSteps, ThreadLocal<EncDec>> decodeStepsEncDecMap;
    private Map<Type,ThreadLocal<EncDec>> typeEncDecMap;
    private Map<DecodeSteps, ThreadLocal<ByteArrayExtractor>> decodeStepsExtractorMap;

    public DecodeOrchestrator(){
        decodeStepsEncDecMap = new HashMap<>();
        typeEncDecMap = new HashMap<>();
        decodeStepsExtractorMap = new HashMap<>();
        decodeStepsEncDecMap.put(DecodeSteps.START, null);
        decodeStepsEncDecMap.put(DecodeSteps.TYPE, ThreadLocal.withInitial(()-> new TypeEncDec()));
        decodeStepsEncDecMap.put(DecodeSteps.SIZE,ThreadLocal.withInitial(()->new SizeEncDec()));

        typeEncDecMap.put(Type.STRING,ThreadLocal.withInitial(()->new StringEncDec()));
        typeEncDecMap.put(Type.DOUBLE,ThreadLocal.withInitial(()-> new DoubleEncDec()));
        typeEncDecMap.put(Type.ARRAY, ThreadLocal.withInitial(()->new ArrayEncDec(this)));

        decodeStepsExtractorMap.put(DecodeSteps.START,ThreadLocal.withInitial(()->  new StartExctractor()));
        decodeStepsExtractorMap.put(DecodeSteps.TYPE, ThreadLocal.withInitial(()-> new TypeExtractor()));
        decodeStepsExtractorMap.put(DecodeSteps.SIZE, ThreadLocal.withInitial(()-> new SizeExtractor()));
        decodeStepsExtractorMap.put(DecodeSteps.DATA, ThreadLocal.withInitial(()-> new DataPacketExtractor()));
        decodeStepsExtractorMap.put(DecodeSteps.END, ThreadLocal.withInitial(()-> new StartExctractor()));
    }

    public T decodeBytes(byte[] data){
        DataExtract dataExtract = null;
        dataExtract = decodeStepsExtractorMap.get(DecodeSteps.START).get().extract(data,0, Optional.empty());

        dataExtract = decodeStepsExtractorMap.get(DecodeSteps.TYPE).get().extract(data, dataExtract.getNextPointer(), Optional.empty());
        Type type = (Type) decodeStepsEncDecMap.get(DecodeSteps.TYPE).get().validateAndDecode(dataExtract.getExtractedData());
        System.out.println(type);

        dataExtract = decodeStepsExtractorMap.get(DecodeSteps.SIZE).get().extract(data,dataExtract.getNextPointer(), Optional.empty());
        int size = (Integer) decodeStepsEncDecMap.get(DecodeSteps.SIZE).get().validateAndDecode(dataExtract.getExtractedData());
        System.out.println(size);

        dataExtract = decodeStepsExtractorMap.get(DecodeSteps.DATA).get().extract(data,dataExtract.getNextPointer(),type==Type.ARRAY?Optional.of(-1):Optional.of(size));

        return (T) typeEncDecMap.get(type).get().validateAndDecode(dataExtract.getExtractedData());
    }
}
