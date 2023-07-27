package org.hitro.binaryprotocol.services.datapacker;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class FrontPacker implements ByteArrayPacker{
    public DataPacket packageIt (byte[] data, DataPacket dataPacket){
        LinkedList<byte[]> prevList = dataPacket!=null ?  dataPacket.getByteList() : new LinkedList<>();
        prevList.addFirst(data);
        return new DataPacket(new LinkedList<>(Arrays.asList(data)), data.length+ (dataPacket !=null? dataPacket.getTotalBytes(): 0));
    }
}
