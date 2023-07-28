package org.hitro;

import org.hitro.binaryprotocol.publicinterfaces.BinaryProtocol;
import org.hitro.binaryprotocol.publicinterfaces.BinaryProtocolImplementation;
import org.hitro.binaryprotocol.services.orchestrators.decode.DecodeOrchestrator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DecodeOrchestrator decodeOrchestrator = new DecodeOrchestrator<>();
        BinaryProtocol binaryProtocol = BinaryProtocolImplementation.getInstance();
        byte[] data = new byte[]{92,104,92,97,36,49,36,92,104,92,115,36,49,49,36,104,101,108,108,111,32,119,111,114,108,100,92,113,92,113};
        List<Object> dl = new ArrayList<>();
        dl.add("hello");
        dl.add(1);
        byte[] encodedData  = binaryProtocol.encode(dl);
        for(byte d: encodedData){
            System.out.print(d +" ,");
        }

        System.out.println(decodeOrchestrator.decodeBytes(encodedData));
    }

}