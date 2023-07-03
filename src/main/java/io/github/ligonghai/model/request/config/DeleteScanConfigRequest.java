package io.github.ligonghai.model.request.config;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DeleteScanConfigRequest extends BaseRequest {

    public DeleteScanConfigRequest() {
        super(HttpMethod.POST, "delete_config");
    }

    @JsonProperty("config_id")
    private String id;

}
