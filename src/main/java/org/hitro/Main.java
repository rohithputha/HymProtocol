package org.hitro;

import org.hitro.binaryprotocol.coreconstants.Constants;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        byte[] test = Constants.getStartBytes();
        System.out.println(test.length);
        for(byte t : test){
            System.out.println(t);
        }
    }

}