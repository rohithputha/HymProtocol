package org.hitro.binaryprotocol.coreconstants;

import java.nio.charset.StandardCharsets;

public class StartConst {
    private static final String constant = "\\h";

    public static byte[] getByteData(){
        byte[] byteData = constant.getBytes(StandardCharsets.UTF_8);
        return byteData;
    }

}
