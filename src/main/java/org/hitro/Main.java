package org.hitro;

import org.hitro.binaryprotocol.publicinterfaces.BinaryProtocol;
import org.hitro.binaryprotocol.publicinterfaces.IBinaryProtocol;
import org.hitro.binaryprotocol.services.orchestrators.decode.DecodeOrchestrator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DecodeOrchestrator decodeOrchestrator = new DecodeOrchestrator<>();
        BinaryProtocol binaryProtocol = IBinaryProtocol.getInstance();
        byte[] data = new byte[]{92,104,92,97,36,49,36,92,104,92,115,36,49,49,36,104,101,108,108,111,32,119,111,114,108,100,92,113,92,113};

        Thread t1= new Thread(()->{
            List<Object> dl = new ArrayList<>();
            List<Object> sdl = new ArrayList<>();
            sdl.add("b");
            sdl.add(2D);
            dl.add("b");
            dl.add(sdl);
            dl.add("b");
            byte[] encodedData  = binaryProtocol.encode(dl);
            for(byte d: encodedData){
                System.out.print(d +" ,");
            }
            System.out.println();
            System.out.println("ans t1--> "+decodeOrchestrator.decodeBytes(encodedData));
        });
        Thread t2 = new Thread(()->{
            List<Object> dl = new ArrayList<>();
            List<Object> sdl = new ArrayList<>();
            sdl.add("lad");
            sdl.add("croockd");
            dl.add("cbt");
            dl.add(sdl);
            dl.add(1D);
            byte[] encodedData  = binaryProtocol.encode(dl);
            for(byte d: encodedData){
                System.out.print(d +" ,");
            }
            System.out.println();
            System.out.println("ans t2--> "+decodeOrchestrator.decodeBytes(encodedData));
        });
        t2.start();
        t1.start();

    }

}