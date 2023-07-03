package io.github.ligonghai.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import io.github.ligonghai.constant.InUse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @author ligonghai
 */
@EqualsAndHashCode(callSuper = true)
public abstract class BasePageResponse<T extends BasePageResponse.BaseItem> extends BaseResponse {

    /**
     * 获取分页数据列表
     *
     * @return list
     */
    public abstract List<T> getList();

    /**
     * 获取分页信息
     *
     * @return PageInfo
     */
    public abstract PageInfo getPageInfo();

    @Data
    public static class BaseItem {

        @JacksonXmlProperty(localName = "id", isAttribute = true)
        private String id;

        @JacksonXmlProperty(localName = "name")
        private String name;

        @JacksonXmlProperty(localName = "comment")
        private String comment;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        @JacksonXmlProperty(localName = "creation_time")
        private Date creationTime;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        @JacksonXmlProperty(localName = "modification_time")
        private Date modificationTime;

        /**
         * writable
         */
        @JacksonXmlProperty(localName = "writable")
        private Integer writable;

        /**
         * @see InUse
         */
        @JacksonXmlProperty(localName = "in_use")
        private Integer inUse;
        /**
         * 所有者
         */
        @JacksonXmlProperty(localName = "owner")
        private Owner owner;

        @Data
        public static class Owner {

            @JacksonXmlProperty(localName = "name")
            private String name;

        }
    }

    @Data
    public abstract static class BaseStatusResponse {

        @JacksonXmlProperty(localName = "status", isAttribute = true)
        private Integer status;

        @JacksonXmlProperty(localName = "status_text", isAttribute = true)
        private String statusText;

        public abstract PageInfo getPageInfo();

    }

    @Data
    public static class PageInfo {

        @JacksonXmlText
        private Integer value;

        @JacksonXmlProperty(localName = "filtered")
        private Integer filtered;

        @JacksonXmlProperty(localName = "page")
        private Integer page;
    }
}
