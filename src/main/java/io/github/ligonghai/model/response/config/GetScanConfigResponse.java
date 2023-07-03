package io.github.ligonghai.model.response.config;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.common.collect.Lists;
import io.github.ligonghai.model.response.BasePageResponse;
import io.github.ligonghai.constant.UsageType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * @author ligonghai
 */
@EqualsAndHashCode(callSuper = true)
public class GetScanConfigResponse extends BasePageResponse<GetScanConfigResponse.ConfigList.ScanConfigResponse.ConfigItem> {

    @Setter
    @JacksonXmlProperty(localName = "get_configs")
    private ConfigList configList;

    @Override
    public List<ConfigList.ScanConfigResponse.ConfigItem> getList() {
        if (Objects.isNull(configList) || Objects.isNull(configList.getScanConfigResponse())) {
            return Lists.newArrayList();
        }
        return this.configList.getScanConfigResponse().getConfigs();
    }

    @Override
    public PageInfo getPageInfo() {
        if (Objects.isNull(configList) || Objects.isNull(configList.getScanConfigResponse())) {
            return null;
        }
        return this.configList.getScanConfigResponse().getPageInfo();
    }

    @Data
    public static class ConfigList {

        @JacksonXmlProperty(localName = "get_configs_response")
        private ScanConfigResponse scanConfigResponse;

        @Data
        @EqualsAndHashCode(callSuper = true)
        public static class ScanConfigResponse extends BasePageResponse.BaseStatusResponse {

            @JacksonXmlElementWrapper(useWrapping = false)
            @JacksonXmlProperty(localName = "config")
            private List<ConfigItem> configs;

            @JacksonXmlProperty(localName = "config_count")
            private PageInfo pageInfo;

            @Data
            @EqualsAndHashCode(callSuper = true)
            public static class ConfigItem extends BasePageResponse.BaseItem {

                @JacksonXmlProperty(localName = "type")
                private Integer type;
                /**
                 * @see UsageType
                 */
                @JacksonXmlProperty(localName = "usage_type")
                private String usageType;

                @JacksonXmlProperty(localName = "predefined")
                private Integer predefined;

            }
        }
    }
}
