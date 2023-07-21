package org.hitro.binaryprotocol.services;

import org.hitro.binaryprotocol.exceptions.HymProtocolException;

import java.nio.ByteBuffer;

public class DoubleEncDec implements EncDec<Double>{
    @Override
    public Double decode(byte[] data) {
       if(data.length ==0)
           throw new HymProtocolException("Byte data provided is length 0",new RuntimeException());
        ByteBuffer doubleBuffer = ByteBuffer.wrap(data);
        return doubleBuffer.getDouble();
    }

    @Override
    public byte[] encode(Double data) {
        return new byte[0];
    }
}
