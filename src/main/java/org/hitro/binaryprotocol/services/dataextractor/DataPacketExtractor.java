package org.hitro.binaryprotocol.services.dataextractor;

import java.util.Arrays;

public class DataPacketExtractor implements ByteArrayExtractor{
    @Override
    public DataExtract extract(byte[] data, int l) {
        int r = data.length;
        return new DataExtract(Arrays.copyOfRange(data, l, r-2),r-2);
    }
}
