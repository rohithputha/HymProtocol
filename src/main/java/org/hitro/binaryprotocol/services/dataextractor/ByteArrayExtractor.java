package org.hitro.binaryprotocol.services.dataextractor;

import java.util.Optional;

public interface ByteArrayExtractor {
    public DataExtract extract(byte[] data, int l, Optional<Integer> numbytes);
}
