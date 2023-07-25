package org.hitro.binaryprotocol.services.encodedecode;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.services.orchestrators.decode.DecodeOrchestrator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayEncDec<T> extends SingleElementED<List<T>> {
    private DecodeOrchestrator decodeOrchestratorService;
    public ArrayEncDec(DecodeOrchestrator decodeOrchestrator){
        this.decodeOrchestratorService= decodeOrchestrator;
    }
    @Override
    protected boolean focusDecValidation(byte[] data) {
        return true;
    }

    @Override
    protected List<T> decode(byte[] data) {
        List<byte[]> bytesData = this.getListOfByteData(data);
        return  bytesData.stream()
                .map(d-> (T) decodeOrchestratorService.decodeBytes(d))
                .collect(Collectors.toList());
    }
    private byte[] copyToByteArray(List<Byte> t){
        byte[] packet = new byte[t.size()];
        IntStream.range(0,t.size())
                .forEach((i)-> packet[i] = t.get(i).byteValue());
        return packet;
    }
    private List<byte[]> getListOfByteData(byte[] data){
        int l = 1;
        List<byte[]> bytesData = new ArrayList<>();
        List<Byte> t = new ArrayList<>();
        t.add(data[0]);
        while(l<data.length){
            t.add(data[l]);
            if(data[l]==Constants.getEndByte() && data[l-1]==Constants.getBackslash()){
                bytesData.add(copyToByteArray(t));
                t = new ArrayList<>();
            }
            l++;
        }
        return bytesData;
    }
    @Override
    protected byte[] encode(List<T> data) {
        return new byte[0];
    }
}