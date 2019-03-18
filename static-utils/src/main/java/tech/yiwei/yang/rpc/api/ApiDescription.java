package tech.yiwei.yang.rpc.api;

import tech.yiwei.yang.utils.JsonUtils;

import java.util.List;

public class ApiDescription {

    private String retName;
    private String retType;
    private String description;
    private List<Arg> args;
    private String method;

    public ApiDescription(String method, String retName, String retType, String description, List<Arg> args) {
        this.retName = retName;
        this.retType = retType;
        this.description = description;
        this.args = args;
        this.method = method;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }

    public String getRetName() {
        return retName;
    }

    public String getRetType() {
        return retType;
    }

    public String getDescription() {
        return description;
    }

    public List<Arg> getArgs() {
        return args;
    }

    public String getMethod() {
        return method;
    }
}
