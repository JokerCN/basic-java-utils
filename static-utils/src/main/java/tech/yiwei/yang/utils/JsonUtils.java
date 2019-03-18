package tech.yiwei.yang.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
    public static class SerializationException extends RuntimeException{
        SerializationException(String message) {
            super(message);
        }

        SerializationException(Exception e){
            super(e);
        }
    }

    public static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public static String toJson(Object o) throws SerializationException {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
//            throw new SerializationException(String.format("Failed to decode: [%s]", o));
        }
    }

    public static Map<String, Object> fromJson(String context) throws SerializationException {
        Map<String, Object> resultMap = null;
        if (StringUtils.isNotBlank(context)) {
            JavaType type = getMapType(String.class, Object.class);
            try {
                resultMap = mapper.readValue(context, type);
            } catch (IOException e) {
                throw new SerializationException(String.format("Failed to decode: [%s]", context));
            }
        }
        return resultMap;
    }

    public static <T> T fromJson(Class<T> clazz, String context) throws SerializationException {
        try{
            return mapper.readValue(context, clazz);
        }catch (IOException e){
            throw new SerializationException(String.format("Failed to decode: [%s]", context));
        }
    }

    private static JavaType getMapType(Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(HashMap.class, elementClasses);
    }

}
