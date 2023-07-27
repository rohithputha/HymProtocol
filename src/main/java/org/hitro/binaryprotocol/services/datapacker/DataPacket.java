package org.hitro.binaryprotocol.services.datapacker;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
@AllArgsConstructor
public class DataPacket {
    private LinkedList<byte[]> byteList;
    private int totalBytes;

    public byte[] convertDataToBytes(){
        byte[] resBytes = new byte[totalBytes];
        int l= 0;
        for(byte[] bytArray: byteList){
            for (int i=0;i<bytArray.length;i++){
                resBytes[l] = bytArray[i];
                l++;
            }
        }

        return resBytes;
    }
}
