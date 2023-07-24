package org.hitro.binaryprotocol.services.encodedecode;

import java.nio.ByteBuffer;

public class DoubleEncDec extends SingleElementED<Double> {
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return true; //think of any double data validations
    }
    @Override
    protected Double decode(byte[] data) {
        ByteBuffer doubleBuffer = ByteBuffer.wrap(data);
        return doubleBuffer.getDouble();
    }
    @Override
    protected byte[] encode(Double data) {
        return new byte[0];
    }
}
