package tech.yiwei.yang.rpc.api;

import tech.yiwei.yang.utils.JsonUtils;

public class Arg {

    private String name;
    private String type;
    private String description;

    public Arg(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
