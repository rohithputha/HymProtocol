package org.hitro.binaryprotocol.services.encodedecode;

import java.nio.charset.StandardCharsets;

public class StringEncDec extends EncDecCore<String> {
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return true;// think of any string focussed validation;
    }

    @Override
    protected String decode(byte[] data) {
        return new String(data, StandardCharsets.UTF_8);
    }

    @Override
    protected byte[] encode(String data) {
        return new byte[0];
    }
}
