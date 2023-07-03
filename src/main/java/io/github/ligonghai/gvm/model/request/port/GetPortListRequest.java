package io.github.ligonghai.gvm.model.request.port;

import io.github.ligonghai.gvm.constant.HttpMethod;
import io.github.ligonghai.gvm.model.request.BasePageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class GetPortListRequest extends BasePageRequest {

    public GetPortListRequest() {
        super(HttpMethod.GET, "get_port_lists");
    }

}
