package org.hitro.binaryprotocol.services;

public interface EncDec<T> {
    public T decode(byte[] data);

    public byte[] encode(T data);
}
