package org.hitro.binaryprotocol.services.dataextractor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DataExtract {
    private byte[] extractedData;
    private int nextPointer;

}
