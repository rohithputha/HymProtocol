package org.hitro.binaryprotocol.services.orchestrators.encode;

import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.services.dataextractor.*;
import org.hitro.binaryprotocol.services.datapacker.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class DataPackerProvider {
    private Map<DecodeSteps, ByteArrayPacker> encodeStepsToPackerMap;
    public DataPackerProvider(){
        encodeStepsToPackerMap = new ConcurrentHashMap<>();
        encodeStepsToPackerMap.put(DecodeSteps.START, new StartPacker());
        encodeStepsToPackerMap.put(DecodeSteps.TYPE,  new TypePacker());
        encodeStepsToPackerMap.put(DecodeSteps.SIZE,  new SizePacker());
        encodeStepsToPackerMap.put(DecodeSteps.DATA,  new DataPacker());
        encodeStepsToPackerMap.put(DecodeSteps.END,   new EndPacker());
    }

    public DataPacket getDataPacketByStepCode(byte[] data, DataPacket prevDataPacket, DecodeSteps step){
        return encodeStepsToPackerMap.get(step).packageIt(data,prevDataPacket);
    }
}
