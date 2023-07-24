package org.hitro.binaryprotocol.services.encodedecode;

public interface EncDec<T> {
    default T validateAndDecode(byte[] data){
        return null;
    }

    default T validateAndDecodeWithElementsInfo(byte[] data, int num){
        return validateAndDecode(data);
    }
    public byte[] validateAndEncode(T data);
}
