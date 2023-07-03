package io.github.ligonghai.model.request.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ligonghai.gvm.constant.*;
import io.github.ligonghai.model.request.BaseRequest;
import io.github.ligonghai.serializer.serializer.CommonEnumSerializer;
import io.github.ligonghai.serializer.serializer.NumericBooleanSerializer;
import io.github.ligonghai.constant.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author ligonghai
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class UpdateTaskRequest extends BaseRequest {

    public UpdateTaskRequest() {
        super(HttpMethod.POST, "save_task");
    }

    /**
     * 任务id
     */
    @JsonProperty("task_id")
    private String id;

    /**
     * 任务名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 备注
     */
    @JsonProperty("comment")
    private String comment;

    /**
     * 目标id
     */
    @JsonProperty("target_id")
    @Setter(value = AccessLevel.PRIVATE)
    private String targetId = Constant.STR_ZERO;

    /**
     * 告警策略id
     */
    @JsonProperty("alert_ids")
    private String alertIds;

    /**
     * 调度策略id
     */
    @JsonProperty("schedule_id")
    private String scheduleId = Constant.STR_ZERO;

    /**
     * 是否运行一次
     */
    @JsonProperty("schedule_periods")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    private boolean schedulePeriods;
    /**
     * 自动将目标填加到资产列表
     */
    @JsonProperty("in_assets")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    private boolean inAssets = true;

    @JsonProperty("apply_overrides")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    private boolean applyOverrides = true;

    @JsonProperty("min_qod")
    private int minQod = 70;

    @JsonProperty("alterable")
    @JsonSerialize(using = NumericBooleanSerializer.class)
    private boolean alterable;

    /**
     * 是否自动删除报告
     */
    @JsonProperty("auto_delete")
    @JsonSerialize(using = CommonEnumSerializer.class)
    private AutoDelete autoDelete = AutoDelete.NO;
    /**
     * 保存前n条报告
     */
    @JsonProperty("auto_delete_data")
    private int autoDeleteData = 5;

    @JsonProperty("scanner_type")
    @JsonSerialize(using = CommonEnumSerializer.class)
    private ScannerType scannerType = ScannerType.DEFAULT;

    /**
     * 扫描器id
     */
    @JsonProperty("scanner_id")
    @Setter(value = AccessLevel.PRIVATE)
    private String scannerId = Constant.STR_ZERO;
    /**
     * 扫描配置id
     */
    @JsonProperty("config_id")
    @Setter(value = AccessLevel.PRIVATE)
    private String configId = Constant.STR_ZERO;
    /**
     * Network Source Interface
     */
    @JsonProperty("source_iface")
    private String networkInterface = Constant.STR_EMPTY;
    /**
     * 排序
     */
    @JsonProperty("hosts_ordering")
    @JsonSerialize(using = CommonEnumSerializer.class)
    private HostOrdering hostsOrdering = HostOrdering.SEQUENTIAL;

    /**
     * Maximum concurrently executed NVTs per host
     */
    @JsonProperty("max_checks")
    private int maxChecks = 4;

    /**
     * Maximum concurrently scanned hosts
     */
    @JsonProperty("max_hosts")
    private int maxHosts = 20;


    @JsonProperty("usage_type")
    @Setter(value = AccessLevel.PRIVATE)
    @JsonSerialize(using = CommonEnumSerializer.class)
    private UsageType usageType = UsageType.SCAN;

}
