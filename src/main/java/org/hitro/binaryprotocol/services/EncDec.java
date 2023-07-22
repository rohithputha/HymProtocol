package org.hitro.binaryprotocol.services;

public interface EncDec<T> {
    public T validateAndDecode(byte[] data);

    public byte[] validateAndEncode(T data);
}
