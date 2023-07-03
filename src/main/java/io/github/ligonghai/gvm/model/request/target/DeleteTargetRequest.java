package io.github.ligonghai.gvm.model.request.target;

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
public class DeleteTargetRequest extends BaseRequest {

    public DeleteTargetRequest() {
        super(HttpMethod.POST, "delete_target");
    }

    @JsonProperty("target_id")
    private String id;

}
