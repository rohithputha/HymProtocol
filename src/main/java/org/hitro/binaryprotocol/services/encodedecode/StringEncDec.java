package org.hitro.binaryprotocol.services.encodedecode;

import java.nio.charset.StandardCharsets;

public class StringEncDec extends EDCore<String> {
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return true;// think of any string focussed validation;
    }

    @Override
    protected boolean focusEncValidation(String data) {
        return true;
    }

    @Override
    protected String decode(byte[] data) {
        return new String(data, StandardCharsets.UTF_8);
    }

    @Override
    protected byte[] encode(String data) {
        return data.getBytes(StandardCharsets.UTF_8);
    }
}
