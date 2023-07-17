package org.hitro.binaryprotocol.coreconstants;

import lombok.Getter;

import java.nio.charset.StandardCharsets;


@Getter
public class Constants {

    @Getter
    private static final byte backslash = 92;

    @Getter
    private static final byte hByte = 104;

    @Getter
    private static final String startConstant = "\\h";

    @Getter
    private static final byte[] startBytes = {backslash,hByte};
}
