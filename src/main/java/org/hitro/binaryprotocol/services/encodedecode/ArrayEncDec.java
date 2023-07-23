package org.hitro.binaryprotocol.services.encodedecode;

import org.hitro.binaryprotocol.services.DecodeOrchestratorService;

public class ArrayEncDec<T> extends EncDecCore<T>{
    private ThreadLocal<StringEncDec> stringEncDec = ThreadLocal.withInitial(()-> null);
    private ThreadLocal<DoubleEncDec> doubleEncDec = ThreadLocal.withInitial(()->null);

    DecodeOrchestratorService decodeOrchestratorService;
    public ArrayEncDec(DecodeOrchestratorService decodeOrchestratorService){
        stringEncDec.set(new StringEncDec());
        doubleEncDec.set(new DoubleEncDec());
        this.decodeOrchestratorService = decodeOrchestratorService;
    }
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return true;
    }

    @Override
    protected T decode(byte[] data) {

        return null;
    }

    @Override
    protected byte[] encode(T data) {
        return new byte[0];
    }
}
