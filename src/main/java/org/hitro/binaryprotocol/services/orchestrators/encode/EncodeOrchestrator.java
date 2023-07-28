package org.hitro.binaryprotocol.services.orchestrators.encode;

import org.hitro.binaryprotocol.coreconstants.Constants;
import org.hitro.binaryprotocol.coreconstants.DecodeSteps;
import org.hitro.binaryprotocol.coreconstants.Type;
import org.hitro.binaryprotocol.services.datapacker.DataPacket;
import org.hitro.binaryprotocol.services.orchestrators.Orchestrator;

import java.util.List;
import java.util.stream.Collectors;

public class EncodeOrchestrator<T> implements Orchestrator<byte[], T> {

    private DataEncProvider dataEncProvider;
    private DataPackerProvider dataPackerProvider;
    public EncodeOrchestrator(){
        this.dataEncProvider = new DataEncProvider(this);
        this.dataPackerProvider = new DataPackerProvider();
    }

    private byte[] encodeData(T data, Type prType){


        byte[] bytesData = dataEncProvider.getEncodedData(data, prType);
        DataPacket dataPacket = this.dataPackerProvider.getDataPacketByStepCode(bytesData,null, DecodeSteps.DATA);

        byte[] bytesSize = dataEncProvider.getEncodedData(bytesData.length,DecodeSteps.SIZE);
        dataPacket = this.dataPackerProvider.getDataPacketByStepCode(bytesSize,dataPacket,DecodeSteps.SIZE);
//        System.out.println(dataPacket.getByteList().size());
//        for(byte[] d: dataPacket.getByteList()){
//            for(byte b: d)
//                System.out.print(b +" ,");
//            System.out.println();
//        }

        byte[] bytesType = dataEncProvider.getEncodedData(prType,DecodeSteps.TYPE);
        dataPacket = this.dataPackerProvider.getDataPacketByStepCode(bytesType,dataPacket,DecodeSteps.TYPE);

        dataPacket = this.dataPackerProvider.getDataPacketByStepCode(Constants.getStartBytes(),dataPacket,DecodeSteps.START);
        dataPacket = this.dataPackerProvider.getDataPacketByStepCode(Constants.getPacketEndBytes(),dataPacket,DecodeSteps.END);
        return dataPacket.convertDataToBytes();
    }

    @Override
    public byte[] orchestrate(T data) {
        if(data.getClass()== String.class)
            return encodeData(data, Type.STRING);
        else if(data.getClass()==Double.class)
            return encodeData(data,Type.DOUBLE);
        else
            return encodeData(data, Type.ARRAY);
    }
}
