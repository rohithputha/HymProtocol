package org.hitro;

import org.hitro.binaryprotocol.coreconstants.StartConst;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        byte[] test = StartConst.getByteData();
        System.out.println(test.length);
        for(byte t : test){
            System.out.println(t);
        }
        System.out.println(StartConst.getByteData());
    }

}