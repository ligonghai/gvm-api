package io.github.ligonghai.gvm.model.request.port;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.ligonghai.gvm.constant.HttpMethod;
import io.github.ligonghai.gvm.model.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DeletePortRangeRequest extends BaseRequest {

    public DeletePortRangeRequest() {
        super(HttpMethod.POST, "delete_port_range");
    }

    /**
     * id
     */
    @JsonProperty("port_range_id")
    private String id;

}
