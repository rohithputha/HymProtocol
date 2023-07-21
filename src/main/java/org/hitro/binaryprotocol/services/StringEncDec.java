package org.hitro.binaryprotocol.services;

import java.nio.charset.StandardCharsets;

public class StringEncDec implements EncDec<String>{
    @Override
    public String decode(byte[] data) {
        return new String(data, StandardCharsets.UTF_8);
    }

    @Override
    public byte[] encode(String data) {
        return new byte[0];
    }
}
