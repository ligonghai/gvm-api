package io.github.ligonghai.model.request.port;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.ligonghai.constant.HttpMethod;
import io.github.ligonghai.model.request.BasePageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class GetPortListRangeRequest extends BasePageRequest {

    public GetPortListRangeRequest() {
        super(HttpMethod.GET, "get_port_list");
    }

    @JsonProperty("port_list_id")
    private String id;

}
