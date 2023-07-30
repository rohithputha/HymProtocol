package org.hitro.binaryprotocol.services.datapacker;
import java.util.LinkedList;

public abstract class FrontPacker implements ByteArrayPacker{
    public DataPacket packageIt (byte[] data, DataPacket dataPacket){
        LinkedList<byte[]> prevList = dataPacket!=null ?  dataPacket.getByteList() : new LinkedList<>();
        prevList.addFirst(data);
        return new DataPacket(prevList, data.length+ (dataPacket !=null? dataPacket.getTotalBytes(): 0));
    }
}