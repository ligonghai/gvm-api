package io.github.ligonghai.gvm.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.ligonghai.gvm.constant.HttpMethod;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BaseRequest {

    @JsonIgnore
    @Setter(value = AccessLevel.PRIVATE)
    private HttpMethod method;

    @Setter(value = AccessLevel.PRIVATE)
    private String cmd;

    private String token;

    public BaseRequest(HttpMethod method, String cmd) {
        this.method = method;
        this.cmd = cmd;
    }
}
