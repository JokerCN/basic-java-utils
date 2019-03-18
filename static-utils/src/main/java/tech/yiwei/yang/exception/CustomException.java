package tech.yiwei.yang.exception;


import tech.yiwei.yang.rpc.RpcReturnCode;

public class CustomException extends RuntimeException{

    private Integer serviceId;
    private RpcReturnCode rpcReturnCode;
    private String detailedErrorCode;
    private Object payload;

    public CustomException(Integer serviceId, RpcReturnCode rpcReturnCode, String detailedErrorCode, Object payload){
        this.serviceId = serviceId;
        this.rpcReturnCode = rpcReturnCode;
        this.detailedErrorCode = detailedErrorCode;
        this.payload = payload;
    }

    @Override
    public String getMessage(){
        return String.format("detailedErrorCode: [%s], payload: [%s]", getDetailedErrorCode(), getPayload().toString());
    }

    public RpcReturnCode getRpcReturnCode(){
        return rpcReturnCode;
    }

    public Object getPayload(){
        return payload;
    }

    public String getDetailedErrorCode(){
        return detailedErrorCode;
    }

    public Integer getServiceId() {
        return serviceId;
    }
}
