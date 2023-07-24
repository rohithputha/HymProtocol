package org.hitro.binaryprotocol.services;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.services.dataextractor.*;
import org.hitro.binaryprotocol.services.encodedecode.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DecodeOrchestratorService<T> {
//    public DecodeOrchestratorService(){
//
//    }
//
//    private Type getType(byte[] data, DataExtract dataExtract){
//        return null;
//    }
//
//    public T decodeBytes(byte[] data){
//        DataExtract dataExtract = null;
//        dataExtract = decodeStepsExtractorMap.get(DecodeSteps.START).get().extract(data,0, Optional.empty());
//
//        dataExtract = decodeStepsExtractorMap.get(DecodeSteps.TYPE).get().extract(data, dataExtract.getNextPointer(), Optional.empty());
//        Type type = (Type) decodeStepsEncDecMap.get(DecodeSteps.TYPE).get().validateAndDecode(dataExtract.getExtractedData());
//        System.out.println(type);
//
//        dataExtract = decodeStepsExtractorMap.get(DecodeSteps.SIZE).get().extract(data,dataExtract.getNextPointer(), Optional.empty());
//        int size = (Integer) decodeStepsEncDecMap.get(DecodeSteps.SIZE).get().validateAndDecode(dataExtract.getExtractedData());
//        System.out.println(size);
//
//        dataExtract = decodeStepsExtractorMap.get(DecodeSteps.DATA).get().extract(data,dataExtract.getNextPointer(), Optional.of(size));
//
//        return (T) typeEncDecMap.get(type).get().validateAndDecode(dataExtract.getExtractedData());
//    }
}
