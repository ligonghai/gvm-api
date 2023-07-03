package io.github.ligonghai.model.response.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.common.collect.Lists;
import io.github.ligonghai.constant.*;
import io.github.ligonghai.model.response.BasePageResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ligonghai
 */
@EqualsAndHashCode(callSuper = true)
public class GetTaskResponse extends BasePageResponse<GetTaskResponse.TaskList.TasksResponse.TaskItem> {

    @Setter
    @JacksonXmlProperty(localName = "get_tasks")
    private TaskList taskList;

    @Override
    public List<TaskList.TasksResponse.TaskItem> getList() {
        if (Objects.isNull(taskList) || Objects.isNull(taskList.getTasksResponse())) {
            return Lists.newArrayList();
        }
        return this.taskList.getTasksResponse().getTasks();
    }


    @Override
    public PageInfo getPageInfo() {
        if (Objects.isNull(taskList) || Objects.isNull(taskList.getTasksResponse())) {
            return null;
        }
        return this.taskList.getTasksResponse().getPageInfo();
    }


    @Data
    public static class TaskList {

        @JacksonXmlProperty(localName = "get_tasks_response")
        private TasksResponse tasksResponse;

        @Data
        @EqualsAndHashCode(callSuper = true)
        public static class TasksResponse extends BasePageResponse.BaseStatusResponse {

            @JacksonXmlElementWrapper(useWrapping = false)
            @JacksonXmlProperty(localName = "task")
            private List<TaskItem> tasks;

            @JacksonXmlProperty(localName = "task_count")
            private BasePageResponse.PageInfo pageInfo;

            @Data
            @EqualsAndHashCode(callSuper = true)
            public static class TaskItem extends BasePageResponse.BaseItem {

                @JacksonXmlProperty(localName = "alterable")
                private Integer alterable;

                /**
                 * @see UsageType
                 */
                @JacksonXmlProperty(localName = "usage_type")
                private String usageType;

                /**
                 * @see HostOrdering
                 */
                @JacksonXmlProperty(localName = "hosts_ordering")
                private String hostsOrdering;

                /**
                 * @see TaskStatus
                 */
                @JacksonXmlProperty(localName = "status")
                private String status;

                @JacksonXmlProperty(localName = "progress")
                private Float progress;

                @JacksonXmlProperty(localName = "schedule_periods")
                private Integer schedulePeriods;

                /**
                 * @see Trend
                 */
                @JacksonXmlProperty(localName = "trend")
                private String trend;

                @JacksonXmlProperty(localName = "config")
                private ScanConfig scanConfig;

                @JacksonXmlProperty(localName = "target")
                private Target target;

                @JacksonXmlProperty(localName = "scanner")
                private Scanner scanner;

                @JacksonXmlProperty(localName = "report_count")
                private ReportCount reportCount;

                @JacksonXmlProperty(localName = "last_report")
                private List<ReportInfo> lastReport;

                @JacksonXmlProperty(localName = "preferences")
                private List<Preference> preferences;

                @Data
                public static class Reference {

                    @JacksonXmlProperty(localName = "id", isAttribute = true)
                    private String id;

                    @JacksonXmlProperty(localName = "name")
                    private String name;

                    @JacksonXmlProperty(localName = "trash")
                    private String trash;

                }

                @Data
                @EqualsAndHashCode(callSuper = true)
                public static class ScanConfig extends Reference {

                    @JacksonXmlProperty(localName = "type")
                    private Integer type;
                }

                @Data
                @EqualsAndHashCode(callSuper = true)
                public static class Target extends Reference {

                }

                @Data
                @EqualsAndHashCode(callSuper = true)
                public static class Scanner extends Reference {
                    /**
                     * @see ScannerType
                     */
                    @JacksonXmlProperty(localName = "type")
                    private Integer type;

                }

                @Data
                public static class ReportCount {

                    @JacksonXmlProperty(localName = "finished")
                    private Integer finished;

                }

                @Data
                public static class ReportInfo {

                    @JacksonXmlProperty(localName = "id", isAttribute = true)
                    private String id;

                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
                    @JacksonXmlProperty(localName = "timestamp")
                    private Date timestamp;

                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
                    @JacksonXmlProperty(localName = "scan_start")
                    private Date start;

                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
                    @JacksonXmlProperty(localName = "scan_end")
                    private Date end;

                    @JacksonXmlProperty(localName = "severity")
                    private Float severity;

                    @JacksonXmlProperty(localName = "result_count")
                    private ResultCount resultCount;

                    @Data
                    public static class ResultCount {

                        @JacksonXmlProperty(localName = "hole")
                        private Integer hole;

                        @JacksonXmlProperty(localName = "info")
                        private Integer info;


                        @JacksonXmlProperty(localName = "log")
                        private Integer log;


                        @JacksonXmlProperty(localName = "warning")
                        private Integer warning;


                        @JacksonXmlProperty(localName = "false_positive")
                        private Integer falsePositive;

                    }

                }

                @Data
                public static class Preference {

                    @JacksonXmlProperty(localName = "name")
                    private String name;

                    @JacksonXmlProperty(localName = "scanner_name")
                    private String scannerName;

                    @JacksonXmlProperty(localName = "value")
                    private String value;

                }

            }
        }
    }
}
