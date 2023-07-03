package io.github.ligonghai.gvm.model.request.target;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.ligonghai.gvm.constant.AliveTest;
import io.github.ligonghai.gvm.constant.HttpMethod;
import io.github.ligonghai.gvm.constant.TargetSource;
import io.github.ligonghai.gvm.model.request.BaseRequest;
import io.github.ligonghai.gvm.serializer.serializer.CommonEnumSerializer;
import io.github.ligonghai.gvm.serializer.serializer.NumericBooleanSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CreateTargetRequest extends BaseRequest {

    public CreateTargetRequest() {
        super(HttpMethod.POST, "create_target");
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("comment")
    private String comment;

    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonProperty("allow_simultaneous_ips")
    private boolean allowSimultaneousIps = true;

    @JsonSerialize(using = CommonEnumSerializer.class)
    @JsonProperty("target_source")
    private TargetSource targetSource = TargetSource.MANUAL;

    @JsonSerialize(using = CommonEnumSerializer.class)
    @JsonProperty("target_exclude_source")
    private TargetSource targetExcludeSource  = TargetSource.MANUAL;

    @JsonProperty("hosts")
    private String hosts;

    @JsonProperty("exclude_hosts")
    private String excludeHosts;

    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonProperty("reverse_lookup_only")
    private boolean reverseLookupOnly;

    @JsonSerialize(using = NumericBooleanSerializer.class)
    @JsonProperty("reverse_lookup_unify")
    private boolean reverseLookupUnify;

    @JsonProperty("port_list_id")
    private String portListId;

    @JsonSerialize(using = CommonEnumSerializer.class)
    @JsonProperty("alive_tests")
    private AliveTest aliveTest = AliveTest.SCAN_CONFIG_DEFAULT;

    @JsonProperty("port")
    private int port = 22;

    @JsonProperty("ssh_credential_id")
    private int sshCredentialId;

    @JsonProperty("ssh_elevate_credential_id")
    private int sshElevateCredentialId;

    @JsonProperty("smb_credential_id")
    private int smbCredentialId;

    @JsonProperty("esxi_credential_id")
    private int esxiCredentialId;

    @JsonProperty("snmp_credential_id")
    private int snmpCredentialId;
}
