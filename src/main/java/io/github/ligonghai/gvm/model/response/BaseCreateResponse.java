package io.github.ligonghai.gvm.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ligonghai
 */
@EqualsAndHashCode(callSuper = true)
public class BaseCreateResponse extends BaseResponse {

    @Setter
    @JacksonXmlProperty(localName = "action_result")
    private BaseCreateResponse.ActionResult result;

    @Override
    public boolean isSuccess() {
        return super.isSuccess() && StringUtils.isNotBlank(this.getId());
    }

    public String getId() {
        return result.getId();
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class ActionResult extends  BaseDeleteResponse.ActionResult{

        @JacksonXmlProperty(localName = "id")
        private String id;

    }
}