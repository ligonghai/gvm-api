package io.github.ligonghai.gvm;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.ligonghai.gvm.config.GvmConfig;
import io.github.ligonghai.gvm.constant.HttpMethod;
import io.github.ligonghai.gvm.exception.ThirdApiException;
import io.github.ligonghai.gvm.model.request.BaseRequest;
import io.github.ligonghai.gvm.model.request.login.LoginRequest;
import io.github.ligonghai.gvm.model.response.login.LoginResponse;
import io.github.ligonghai.gvm.utils.XmlUtil;
import io.github.ligonghai.gvm.utils.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;

/**
 * @author ligonghai
 */
@Slf4j
public class GvmApiClient {

    private String token;

    private final GvmConfig config;

    public GvmApiClient(GvmConfig config) throws IOException {
        this.config = config;
        this.login();
    }

    private void login() throws IOException {
        BaseRequest request = new LoginRequest().setLogin(config.getUsername()).setPassword(config.getPassword());
        LoginResponse response = this.execute(request, new TypeReference<LoginResponse>() {
        });
        if (!response.isSuccess()) {
            throw new ThirdApiException(response.getMessage());
        }
        this.token = response.getToken();
    }

    private <T> T execute(BaseRequest request, TypeReference<T> valueType) throws IOException {
        //设置token
        request.setToken(this.token);
        //发起请求
        String result;
        if (request.getMethod().equals(HttpMethod.GET)) {
            result = HttpClient.get(config.getApi(), request, new HashMap<>(0));
        } else {
            result = HttpClient.post(config.getApi(), request, new HashMap<>(0), true);
        }
        if (StringUtils.isEmpty(result)) {
            throw new ThirdApiException(MessageFormat.format("Gvm api cmd: {0}, error: response is null.", request.getCmd()));
        }
        return XmlUtil.readValue(result, valueType);
    }

    /**
     * 调用gvm接口
     *
     * @param request   request
     * @param valueType valueType
     * @param <T>       T
     * @return T
     * @throws IOException IOException
     */
    public <T> T call(BaseRequest request, TypeReference<T> valueType) throws IOException {
        //存在token失效的情况,需要重新登录后再试
        for (int count = 1, retry = 2; count <= retry; count++) {
            try {
                return this.execute(request, valueType);
            } catch (Exception e) {
                if (count < retry) {
                    //重新登录再试
                    this.login();
                } else {
                    throw e;
                }
            }
        }
        //这里肯定执行不到。
        throw new ThirdApiException("May be there's a bug.");
    }

}
