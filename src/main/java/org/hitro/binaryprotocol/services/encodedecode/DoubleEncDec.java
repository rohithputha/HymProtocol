package org.hitro.binaryprotocol.services.encodedecode;

import java.nio.ByteBuffer;

public class DoubleEncDec extends EDCore<Double> {
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return true; //think of any double data validations
    }

    @Override
    protected boolean focusEncValidation(Double data) {
        return true;
    }

    @Override
    protected Double decode(byte[] data) {
        ByteBuffer doubleBuffer = ByteBuffer.wrap(data);
        return doubleBuffer.getDouble();
    }
    @Override
    protected byte[] encode(Double data) {
        ByteBuffer buffer = ByteBuffer.allocate(Double.BYTES);
        buffer.putDouble(data);
        return buffer.array();
    }
}
