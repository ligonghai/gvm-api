package io.github.ligonghai.model.request.port;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.ligonghai.constant.HttpMethod;
import io.github.ligonghai.model.request.BaseRequest;
import io.github.ligonghai.serializer.serializer.NumericBooleanSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CreatePortListRequest extends BaseRequest {

    public CreatePortListRequest() {
        super(HttpMethod.POST, "create_port_list");
    }

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
    /**
     * 使用文件,默认0
     */
    @JsonProperty("from_file")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    private boolean fromFile;
    /**
     * 端口范围 ex: T:1-5,7,9,U:1-3,5,7,9
     */
    @JsonProperty("port_range")
    private String portRange;

}
