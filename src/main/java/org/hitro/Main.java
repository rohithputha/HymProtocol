package org.hitro;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.services.DecodeOrchestratorService;
import org.hitro.binaryprotocol.services.orchestrators.decode.DecodeOrchestrator;

public class Main {
    public static void main(String[] args) {
        DecodeOrchestrator decodeOrchestrator = new DecodeOrchestrator<>();
        byte[] data = new byte[]{92,104,92,97,36,49,36,92,104,92,115,36,49,49,36,104,101,108,108,111,32,119,111,114,108,100,92,113,92,113};
        System.out.println(decodeOrchestrator.decodeBytes(data));
    }

}