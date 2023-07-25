package org.hitro.binaryprotocol.services.orchestrators.decode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.services.dataextractor.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataExtractorProvider {
    private Map<DecodeSteps, ThreadLocal<ByteArrayExtractor>> decodeStepsExtractorMap;
    public DataExtractorProvider(){
        decodeStepsExtractorMap = new HashMap<>();
        decodeStepsExtractorMap.put(DecodeSteps.START,ThreadLocal.withInitial(()->  new StartExctractor()));
        decodeStepsExtractorMap.put(DecodeSteps.TYPE, ThreadLocal.withInitial(()-> new TypeExtractor()));
        decodeStepsExtractorMap.put(DecodeSteps.SIZE, ThreadLocal.withInitial(()-> new SizeExtractor()));
        decodeStepsExtractorMap.put(DecodeSteps.DATA, ThreadLocal.withInitial(()-> new DataPacketExtractor()));
        decodeStepsExtractorMap.put(DecodeSteps.END, ThreadLocal.withInitial(()-> new StartExctractor()));
    }

    public DataExtract getDataExtractByStepCode(byte[]data,int nextPointer, DecodeSteps step, Optional<Integer> bytesOption){
        return decodeStepsExtractorMap.get(step).get().extract(data,nextPointer, bytesOption);
    }
}
