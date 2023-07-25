package org.hitro.binaryprotocol.services.orchestrators.decode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.services.dataextractor.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataExtractorProvider {
    private Map<DecodeSteps, ByteArrayExtractor> decodeStepsExtractorMap;
    public DataExtractorProvider(){
        decodeStepsExtractorMap = new HashMap<>();
        decodeStepsExtractorMap.put(DecodeSteps.START, new StartExctractor());
        decodeStepsExtractorMap.put(DecodeSteps.TYPE,  new TypeExtractor());
        decodeStepsExtractorMap.put(DecodeSteps.SIZE,  new SizeExtractor());
        decodeStepsExtractorMap.put(DecodeSteps.DATA,  new DataPacketExtractor());
        decodeStepsExtractorMap.put(DecodeSteps.END,   new StartExctractor());
    }

    public DataExtract getDataExtractByStepCode(byte[]data,int nextPointer, DecodeSteps step, Optional<Integer> bytesOption){
        return decodeStepsExtractorMap.get(step).extract(data,nextPointer, bytesOption);
    }
}
