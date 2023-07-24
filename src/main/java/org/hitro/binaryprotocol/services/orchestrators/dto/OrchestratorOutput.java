package org.hitro.binaryprotocol.services.orchestrators.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrchestratorOutput<T> {
    private T packet;
    private int nextPointer;
}
