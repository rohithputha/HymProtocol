package org.hitro.binaryprotocol.services.dataextractor;

public class TypeExtractor implements ByteArrayExtractor{
    @Override
    public DataExtract extract(byte[] data, int l) {
        return new DataExtract(new byte[]{data[l],data[l+1]},l+2);
    }
}
