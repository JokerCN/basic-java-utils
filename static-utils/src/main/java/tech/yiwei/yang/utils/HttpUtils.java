package tech.yiwei.yang.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import tech.yiwei.yang.rpc.response.RpcResponse;

import java.util.Map;

public class HttpUtils {

    public static class HttpUtilsException extends RuntimeException{
        HttpUtilsException(String message) {
            super(message);
        }
    }

    public static RpcResponse getApiRpc(String ip, String port, String token, Map<String, Object> param){
        String url = String.format("http://%s:%s/api/rpc", ip, port);
        String TOKEN = token;
        if(StringUtils.isNotBlank(token)){
            if(!token.startsWith("Bearer"))
                TOKEN = "Bearer " + token;
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", TOKEN);

        StringEntity entity = new StringEntity(JsonUtils.toJson(param), ContentType.create("application/json", "UTF-8"));

        httpPost.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                return RpcResponse.fromString(result);
            else
                throw new HttpUtilsException(result);
        }catch (Exception e){
            throw new HttpUtilsException(e.getMessage());
        }
    }
}
