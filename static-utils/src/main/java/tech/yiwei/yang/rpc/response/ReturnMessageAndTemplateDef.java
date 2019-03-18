package tech.yiwei.yang.rpc.response;

public interface ReturnMessageAndTemplateDef {
    enum Errors{
        ILLEGAL_REQUEST_BODY        ("00001", "方法调用格式错误, request body中的method、params均不能为空、空字符串或仅包含空格得字符串",      false),
        METHOD_NOT_FOUND            ("00002", "没有找到所指定的方法，建议调用/api/list来查看可以调用的方法"                            ,      false),
        REQUIRED_PARAM_NOT_FOUND    ("00003", "必须提供参数[%s]且不能为空字符串, 请参考相应的接口文档, 或者调用/api/info/{api_name}方法查看接口信息",    true),
        UNKNOWN_ERROR               ("00004", "未知错误, 请联系开发人员以便于解决该问题, 请帮助将相应日志内容[%s]给予开发人员, 谢谢",           true),
        EMPTY_PARALLEL_PARAMS       ("00005", "parallel接口参数集合列表为空, 请参考parallel接口调用格式",                                     false),
        PARAM_NOT_VALID             ("00006", "接口所需要的参数不符合要求的格式, 具体信息为[%s], 请查阅接口文档依照要求进行调用",               true)
        ;


        private String detailedErrorCode;
        private String message;
        private Boolean isTemplate;

        Errors(String detailedErrorCode, String message, Boolean isTemplate){
            this.detailedErrorCode = detailedErrorCode;
            this.message = message;
            this.isTemplate = isTemplate;
        }

        public String getDetailedErrorCode(){
            return detailedErrorCode;
        }

        public String getMessage(Object... params){
            return isTemplate
                    ? String.format(message, params)
                    : message;
        }
    }
}
