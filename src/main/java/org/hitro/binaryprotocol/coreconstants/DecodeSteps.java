package org.hitro.binaryprotocol.coreconstants;

public enum DecodeSteps {
    START,
    TYPE,
    SIZE,
    DATA,
    END,
    TERMINATE
}
