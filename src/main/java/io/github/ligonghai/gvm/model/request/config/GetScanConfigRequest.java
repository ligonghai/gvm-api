package io.github.ligonghai.gvm.model.request.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.ligonghai.gvm.constant.HttpMethod;
import io.github.ligonghai.gvm.constant.UsageType;
import io.github.ligonghai.gvm.model.request.BasePageRequest;
import io.github.ligonghai.gvm.serializer.serializer.CommonEnumSerializer;
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
public class GetScanConfigRequest extends BasePageRequest {

    public GetScanConfigRequest() {
        super(HttpMethod.GET, "get_configs");
    }

    @JsonProperty("usage_type")
    @Setter(value = AccessLevel.PRIVATE)
    @JsonSerialize(using = CommonEnumSerializer.class)
    private UsageType usageType = UsageType.SCAN;

}
