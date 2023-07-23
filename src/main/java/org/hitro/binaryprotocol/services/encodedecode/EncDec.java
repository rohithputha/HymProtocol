package org.hitro.binaryprotocol.services.encodedecode;

public interface EncDec<T> {
    public T validateAndDecode(byte[] data);
    public byte[] validateAndEncode(T data);
}
