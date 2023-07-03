package io.github.ligonghai.model.response.target;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.common.collect.Lists;
import io.github.ligonghai.model.response.BasePageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * @author ligonghai
 */
@EqualsAndHashCode(callSuper = true)
public class GetTargetResponse extends BasePageResponse<GetTargetResponse.TargetList.TargetsResponse.TargetItem> {

    @Setter
    @JacksonXmlProperty(localName = "get_targets")
    private TargetList targetList;

    @Override
    public List<TargetList.TargetsResponse.TargetItem> getList() {
        if (Objects.isNull(targetList) || Objects.isNull(targetList.getTargetsResponse())) {
            return Lists.newArrayList();
        }
        return this.targetList.getTargetsResponse().getTargets();
    }


    @Override
    public PageInfo getPageInfo() {
        if (Objects.isNull(targetList) || Objects.isNull(targetList.getTargetsResponse())) {
            return null;
        }
        return this.targetList.getTargetsResponse().getPageInfo();
    }

    @Data
    public static class TargetList {

        @JacksonXmlProperty(localName = "get_targets_response")
        private TargetsResponse targetsResponse;

        @Data
        @EqualsAndHashCode(callSuper = true)
        public static class TargetsResponse extends BasePageResponse.BaseStatusResponse {

            @JacksonXmlElementWrapper(useWrapping = false)
            @JacksonXmlProperty(localName = "target")
            private List<TargetItem> targets;

            @JacksonXmlProperty(localName = "target_count")
            private PageInfo pageInfo;

            @Data
            @EqualsAndHashCode(callSuper = true)
            public static class TargetItem extends BasePageResponse.BaseItem {

                @JacksonXmlProperty(localName = "allow_simultaneous_ips")
                private Integer allowSimultaneousIps;

                @JacksonXmlProperty(localName = "reverse_lookup_only")
                private Integer reverseLookupOnly;

                @JacksonXmlProperty(localName = "reverse_lookup_unify")
                private Integer reverseLookupUnify;

                @JacksonXmlProperty(localName = "alive_tests")
                private String aliveTest;

                @JacksonXmlProperty(localName = "port_list")
                private PortList portList;

                @JacksonXmlProperty(localName = "ssh_credential")
                private SshCredential sshCredential;

                @JacksonXmlProperty(localName = "smb_credential")
                private SmbCredential smbCredential;

                @JacksonXmlProperty(localName = "esxi_credential")
                private EsxiCredential esxiCredential;

                @JacksonXmlProperty(localName = "snmp_credential")
                private SnmpCredential snmpCredential;

                @JacksonXmlProperty(localName = "ssh_elevate_credential")
                private SshElevateCredential sshElevateCredential;

                @Data
                public static class PortList {

                    @JacksonXmlProperty(localName = "id", isAttribute = true)
                    private String id;

                    @JacksonXmlProperty(localName = "name")
                    private String name;
                }

                @Data
                public static class Credential {

                    @JacksonXmlProperty(localName = "id", isAttribute = true)
                    private String id;

                    @JacksonXmlProperty(localName = "name")
                    private String name;

                    @JacksonXmlProperty(localName = "trash")
                    private Integer trash;

                }

                @Data
                @EqualsAndHashCode(callSuper = true)
                public static class SshCredential extends Credential {

                    @JacksonXmlProperty(localName = "port")
                    private Integer port;

                }

                @Data
                @EqualsAndHashCode(callSuper = true)
                public static class SmbCredential extends Credential {

                }

                @Data
                @EqualsAndHashCode(callSuper = true)
                public static class EsxiCredential extends Credential {

                }

                @Data
                @EqualsAndHashCode(callSuper = true)
                public static class SnmpCredential extends Credential {

                }

                @Data
                @EqualsAndHashCode(callSuper = true)
                public static class SshElevateCredential extends Credential {

                }

            }
        }
    }
}
