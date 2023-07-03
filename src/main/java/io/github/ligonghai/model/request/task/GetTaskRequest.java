package io.github.ligonghai.model.request.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.ligonghai.constant.HttpMethod;
import io.github.ligonghai.constant.UsageType;
import io.github.ligonghai.model.request.BasePageRequest;
import io.github.ligonghai.serializer.serializer.CommonEnumSerializer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class GetTaskRequest extends BasePageRequest {

    public GetTaskRequest() {
        super(HttpMethod.GET, "get_tasks");
    }

    /**
     *  usage_type
     */
    @JsonProperty("usage_type")
    @Setter(value = AccessLevel.PRIVATE)
    @JsonSerialize(using = CommonEnumSerializer.class)
    private UsageType usageType = UsageType.SCAN;

}
