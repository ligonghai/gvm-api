package io.github.ligonghai.model.request.login;

import io.github.ligonghai.constant.HttpMethod;
import io.github.ligonghai.model.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class LoginRequest extends BaseRequest {

    private String login;

    private String password;

    public LoginRequest() {
        super(HttpMethod.POST, "login");
    }

}
