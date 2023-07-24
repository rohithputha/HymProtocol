package org.hitro.binaryprotocol.services.dataextractor;

import java.util.Optional;

public class StartExctractor implements ByteArrayExtractor{
    @Override
    public DataExtract extract(byte[] data, int l, Optional<Integer> numBytes) {
        return new DataExtract(new byte[]{data[l],data[l+1]},l+2);
    }
}
