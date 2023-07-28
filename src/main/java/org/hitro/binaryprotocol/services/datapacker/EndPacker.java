package org.hitro.binaryprotocol.services.datapacker;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EndPacker implements ByteArrayPacker{
    public DataPacket packageIt (byte[] data, DataPacket dataPacket){
        LinkedList<byte[]> prevList = dataPacket!=null ? dataPacket.getByteList() : new LinkedList<>();
        prevList.addLast(data);
        return new DataPacket(prevList, data.length+ (dataPacket !=null? dataPacket.getTotalBytes(): 0));
    }
}
