package org.hitro.binaryprotocol.services.dataextractor;

import org.hitro.binaryprotocol.coreconstants.Constants;

import java.util.Arrays;
import java.util.Optional;

public class SizeExtractor implements ByteArrayExtractor{
    @Override
    public DataExtract extract(byte[] data, int l, Optional<Integer> numBytes) {
        int r = l+1;
        while(r<data.length && data[r]!=Constants.getSizeStartEndByte()){
            r++;
        }
        return new DataExtract(Arrays.copyOfRange(data,l,r+1),r+1);
    }
}
