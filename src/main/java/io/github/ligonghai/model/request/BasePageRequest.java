package io.github.ligonghai.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.ligonghai.constant.HttpMethod;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * @author ligonghai
 */

@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BasePageRequest extends BaseRequest {

    @JsonIgnore
    private String sort;

    @JsonIgnore
    private Integer current;

    @JsonIgnore
    private Integer size;


    public BasePageRequest(HttpMethod method, String cmd) {
        this(method, cmd, null, null, null);
    }

    public BasePageRequest(HttpMethod method, String cmd, String sort, Integer current, Integer size) {
        super(method, cmd);
        this.sort = sort;
        this.current = Objects.isNull(current) ? 1 : current;
        this.size = Objects.isNull(size) ? 10 : size;
    }

    /**
     * jackson调用
     *
     * @return filter
     */
    public String getFilter() {
        return String.format("sort=%s first=%d rows=%d", sort, (current - 1) * size + 1, size);
    }
}
