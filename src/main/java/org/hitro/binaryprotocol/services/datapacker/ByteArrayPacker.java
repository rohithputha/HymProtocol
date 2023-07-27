package org.hitro.binaryprotocol.services.datapacker;

public interface ByteArrayPacker {
    public DataPacket packageIt (byte[] data, DataPacket dataPacket);
}
