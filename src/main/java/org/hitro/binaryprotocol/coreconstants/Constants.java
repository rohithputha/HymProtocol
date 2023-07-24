package org.hitro.binaryprotocol.coreconstants;

import lombok.Getter;

import java.nio.charset.StandardCharsets;



public class Constants {

    @Getter
    private static final byte backslash = 92;

    @Getter
    private static final byte hByte = 104;

    @Getter
    private static final String startConstant = "\\h";

    @Getter
    private static final byte[] startBytes = {backslash,hByte};

    @Getter
    private static final byte stringByte = 115;

    @Getter
    private static final String stringTypeConstant = "\\s";

    @Getter
    private static final byte[] stringTypeBytes = {backslash,stringByte};

    @Getter
    private static final byte doubleByte = 100;

    @Getter
    private static final String doubleTypeConstant = "\\d";

    @Getter
    private static final byte[] doubleTypeBytes = {backslash,doubleByte};

    @Getter
    private static final byte sizeStartEndByte = 36;

    @Getter
    private static final byte arrayByte = 97;

    @Getter
    private static final byte[] arrayTypeBytes = {backslash,arrayByte};
    @Getter
    private static final byte endByte = 113;

    @Getter
    static final byte[] packetEndBytes = {backslash,endByte};
}
