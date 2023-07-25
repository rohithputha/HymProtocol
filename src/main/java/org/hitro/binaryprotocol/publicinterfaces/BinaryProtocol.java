package org.hitro.binaryprotocol.publicinterfaces;

public interface BinaryProtocol<T> {
    public T decode(byte[] data);

    public byte[] encode(T data);
}
