package io.github.ligonghai.gvm.model.response.port;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.common.collect.Lists;
import io.github.ligonghai.gvm.model.response.BasePageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * @author ligonghai
 */
@EqualsAndHashCode(callSuper = true)
public class GetPortListResponse extends BasePageResponse<GetPortListResponse.PortList.PortListsResponse.PortItem> {

    @Setter
    @JacksonXmlProperty(localName = "get_port_lists")
    private PortList portList;

    @Override
    public List<PortList.PortListsResponse.PortItem> getList() {
        if (Objects.isNull(portList) || Objects.isNull(portList.getPortListsResponse())) {
            return Lists.newArrayList();
        }
        return this.portList.getPortListsResponse().getPorts();
    }


    @Override
    public PageInfo getPageInfo() {
        if (Objects.isNull(portList) || Objects.isNull(portList.getPortListsResponse())) {
            return null;
        }
        return this.portList.getPortListsResponse().getPageInfo();
    }

    @Data
    public static class PortList {

        @JacksonXmlProperty(localName = "get_port_lists_response")
        private PortListsResponse portListsResponse;

        @Data
        @EqualsAndHashCode(callSuper = true)
        public static class PortListsResponse extends BasePageResponse.BaseStatusResponse {

            @JacksonXmlElementWrapper(useWrapping = false)
            @JacksonXmlProperty(localName = "port_list")
            private List<PortItem> ports;

            @JacksonXmlProperty(localName = "port_list_count")
            private PageInfo pageInfo;

            @Data
            @EqualsAndHashCode(callSuper = true)
            public static class PortItem extends BasePageResponse.BaseItem {

                @JacksonXmlProperty(localName = "port_count")
                private PortCount portCount;

                @Data
                public static class PortCount {

                    @JacksonXmlProperty(localName = "all")
                    private Integer all;

                    @JacksonXmlProperty(localName = "tcp")
                    private Integer tcp;

                    @JacksonXmlProperty(localName = "udp")
                    private Integer udp;

                }
            }
        }
    }
}
