package org.hitro.binaryprotocol.services.dataextractor;

import java.util.Arrays;
import java.util.Optional;

public class DataPacketExtractor implements ByteArrayExtractor{
    @Override
    public DataExtract extract(byte[] data, int l, Optional<Integer> numBytes) {
        int r = data.length;
        if(numBytes.orElseThrow()!=-1){
            System.out.println(l);
            System.out.println(numBytes.orElseThrow());
            return new DataExtract(Arrays.copyOfRange(data, l, l+numBytes.orElseThrow()),l+numBytes.orElseThrow()+1);
        }

        else
            return new DataExtract(Arrays.copyOfRange(data, l,data.length-2), data.length-1);
    }
}
