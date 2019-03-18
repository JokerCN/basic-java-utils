package tech.yiwei.yang.rpc;

public enum ServiceEnum {

    AUTH_SERVICE(16010, "auth_service"),
    QUANT_SERVICE(16011, "quant_service"),
    TRADE_SERVICE(16012, "trade_service"),
    MARKET_DATA_SERVICE(16015, "market_data_service"),
    MODEL_SERVICE(16017, "model_service"),
    PRICING_SERVICE(16018, "pricing_service"),
    REPORT_SERVICE(16019, "report_service"),
    STATIC_DATA_SERVICE(16021, "static_data_service"),
    COLLATERAL_SERVICE(16022, "collateral_service"),
    WORK_FLOW_SERVICE(16023, "work_flow_service"),
    BUSINESS_SERVICE(16007, "business_service"),
    DOCUMENT_SERVICE(5001, "document_service");

    private Integer serviceId;
    private String serviceName;

    ServiceEnum(Integer serviceId, String serviceName){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getRpcServiceName(){
        return serviceName.replace("_","-");
    }
}
