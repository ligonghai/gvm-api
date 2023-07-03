package io.github.ligonghai.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.github.ligonghai.constant.Constant;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

/**
 * @author ligonghai
 */
@Data
@JacksonXmlRootElement(localName = "envelope")
public class BaseResponse {

    @JacksonXmlProperty(localName = "version")
    private String version;

    @JacksonXmlProperty(localName = "vendor_version")
    private String vendorVersion;

    @JacksonXmlProperty(localName = "token")
    private String token;

    @JacksonXmlProperty(localName = "time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE MMM dd HH:mm:ss yyyy zzz", locale = "en")
    private Date time;

    @JacksonXmlProperty(localName = "timezone")
    private String timezone;

    @JacksonXmlProperty(localName = "login")
    private String login;

    @JacksonXmlProperty(localName = "session")
    private Long session;

    @JacksonXmlProperty(localName = "role")
    private String role;

    @JacksonXmlProperty(localName = "i18n")
    private String i18n;

    @JacksonXmlProperty(localName = "client_address")
    private String clientAddress;

    @JacksonXmlProperty(localName = "backend_operation")
    private String backendOperation;

    @Getter(value = AccessLevel.PRIVATE)
    @JacksonXmlProperty(localName = "gsad_response")
    private Error error;

    @Data
    public static class Error {
        @JacksonXmlProperty(localName = "title")
        private String title;

        @JacksonXmlProperty(localName = "message")
        private String message;
    }


    @Setter
    @JacksonXmlProperty(localName = "action_result")
    private BaseDeleteResponse.ActionResult result;

    /**
     * 是否成功
     *
     * @return boolean
     */
    public boolean isSuccess() {
        if (Objects.nonNull(this.error)) {
            return false;
        }
        return Objects.isNull(this.result) || Constant.STR_OK.equals(result.message);
    }

    /**
     * 获取结果信息
     *
     * @return message
     */
    public String getMessage() {
        if (Objects.nonNull(this.error)) {
            return this.error.message;
        }
        if (Objects.nonNull(this.result)) {
            return result.getMessage();
        }
        return null;
    }


    @Data
    public static class ActionResult {

        @JacksonXmlProperty(localName = "action")
        private String action;

        @JacksonXmlProperty(localName = "message")
        private String message;

    }

}
