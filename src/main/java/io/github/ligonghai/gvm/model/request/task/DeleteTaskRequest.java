package io.github.ligonghai.gvm.model.request.task;

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
public class DeleteTaskRequest extends BaseRequest {

    public DeleteTaskRequest() {
        super(HttpMethod.POST, "delete_task");
    }

    @JsonProperty("task_id")
    private String id;

}
