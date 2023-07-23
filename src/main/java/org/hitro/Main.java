package org.hitro;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.services.DecodeOrchestratorService;

public class Main {
    public static void main(String[] args) {
        DecodeOrchestratorService decodeOrchestratorService = new DecodeOrchestratorService<>();
        byte[] data = new byte[]{92,104,92,115,36,49,49,36,104,101,108,108,111,32,119,111,114,108,100,92,113};
        System.out.println(decodeOrchestratorService.decodeBytes(data));
    }

}