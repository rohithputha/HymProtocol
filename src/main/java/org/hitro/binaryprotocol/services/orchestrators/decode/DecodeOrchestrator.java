package org.hitro.binaryprotocol.services.orchestrators.decode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.services.dataextractor.*;
import org.hitro.binaryprotocol.services.encodedecode.*;
import org.hitro.binaryprotocol.services.orchestrators.Orchestrator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DecodeOrchestrator<T> implements Orchestrator<T,byte[]> {

    private DataEncDecProvider dataEncDecProvider;
    private DataExtractorProvider dataExtractorProvider;
    public DecodeOrchestrator(){
        dataEncDecProvider = new DataEncDecProvider<>(this);
        dataExtractorProvider = new DataExtractorProvider();
    }

    public T decodeBytes(byte[] data){
        System.out.println("-> "+ data.length);
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ,");
        }
        System.out.println();
        DataExtract dataExtract = null;
        dataExtract = dataExtractorProvider.getDataExtractByStepCode(data,0,DecodeSteps.START, Optional.empty());

        dataExtract = dataExtractorProvider.getDataExtractByStepCode(data, dataExtract.getNextPointer(),DecodeSteps.TYPE, Optional.empty());
        Type type = (Type) dataEncDecProvider.getDecodedData(dataExtract.getExtractedData(),DecodeSteps.TYPE);

        dataExtract = dataExtractorProvider.getDataExtractByStepCode(data, dataExtract.getNextPointer(), DecodeSteps.SIZE,Optional.empty());
        int size = (Integer) dataEncDecProvider.getDecodedData(dataExtract.getExtractedData(),DecodeSteps.SIZE);


        dataExtract = dataExtractorProvider.getDataExtractByStepCode(data, dataExtract.getNextPointer(), DecodeSteps.DATA,type == Type.ARRAY ? Optional.of(-1) : Optional.of(size));
        return (T) dataEncDecProvider.getDecodedData(dataExtract.getExtractedData(),type);
    }

    @Override
    public T orchestrate(byte[] data) {
        return decodeBytes(data);
    }
}
