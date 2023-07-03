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
public class UpdatePortListRequest extends BaseRequest {

    public UpdatePortListRequest() {
        super(HttpMethod.POST, "save_port_list");
    }
    /**
     * id
     */
    @JsonProperty("port_list_id")
    private String id;
    /**
     * 名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 备注
     */
    @JsonProperty("comment")
    private String comment;

}
