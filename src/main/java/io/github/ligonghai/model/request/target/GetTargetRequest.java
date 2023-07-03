package io.github.ligonghai.model.request.target;

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
public class GetTargetRequest extends BasePageRequest {

    public GetTargetRequest() {
        super(HttpMethod.GET, "get_targets");
    }

}
