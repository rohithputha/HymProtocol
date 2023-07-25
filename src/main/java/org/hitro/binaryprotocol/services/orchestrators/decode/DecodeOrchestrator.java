package org.hitro.binaryprotocol.services.orchestrators.decode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.services.dataextractor.*;
import org.hitro.binaryprotocol.services.encodedecode.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DecodeOrchestrator<T> {

    private ThreadLocal<DataEncDecProvider> dataEncDecProvider =  ThreadLocal.withInitial(()-> null);
    private ThreadLocal<DataExtractorProvider> dataExtractorProvider = ThreadLocal.withInitial(()->  null);
    public DecodeOrchestrator(){
        dataEncDecProvider.set(new DataEncDecProvider<>(this));
        dataExtractorProvider.set(new DataExtractorProvider());
    }

    public T decodeBytes(byte[] data){
        DataExtract dataExtract = null;
        dataExtract = dataExtractorProvider.get().getDataExtractByStepCode(data,0,DecodeSteps.START, Optional.empty());

        dataExtract = dataExtractorProvider.get().getDataExtractByStepCode(data, dataExtract.getNextPointer(),DecodeSteps.TYPE, Optional.empty());
        Type type = (Type) dataEncDecProvider.get().getDecodedData(dataExtract.getExtractedData(),DecodeSteps.TYPE);
        System.out.println(type);

        dataExtract = dataExtractorProvider.get().getDataExtractByStepCode(data, dataExtract.getNextPointer(), DecodeSteps.SIZE,Optional.empty());
        int size = (Integer) dataEncDecProvider.get().getDecodedData(dataExtract.getExtractedData(),DecodeSteps.SIZE);
        System.out.println(size);

        dataExtract = dataExtractorProvider.get().getDataExtractByStepCode(data, dataExtract.getNextPointer(), DecodeSteps.DATA,type == Type.ARRAY ? Optional.of(-1) : Optional.of(size));
        return (T) dataEncDecProvider.get().getDecodedData(dataExtract.getExtractedData(),type);
    }
}
