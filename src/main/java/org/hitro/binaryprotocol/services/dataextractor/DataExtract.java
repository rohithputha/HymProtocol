package org.hitro.binaryprotocol.services.dataextractor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DataExtract {
    private byte[] extractedData;
    private int nextPointer;

}
