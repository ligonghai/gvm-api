package io.github.ligonghai.model.request.port;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.ligonghai.constant.HttpMethod;
import io.github.ligonghai.constant.PortType;
import io.github.ligonghai.model.request.BaseRequest;
import io.github.ligonghai.serializer.serializer.CommonEnumSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CreatePortRangeRequest extends BaseRequest {

    public CreatePortRangeRequest() {
        super(HttpMethod.POST, "create_port_range");
    }

    /**
     * list id
     */
    @JsonProperty("port_list_id")
    private String portListId;
    /**
     * 开始
     */
    @JsonProperty("port_range_start")
    private int portRangeStart;
    /**
     * 结束
     */
    @JsonProperty("port_range_end")
    private int portRangeEnd;
    /**
     * 端口类型
     */
    @JsonProperty("port_type")
    @JsonSerialize(using = CommonEnumSerializer.class)
    private PortType portType;

}
