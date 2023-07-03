package io.github.ligonghai;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.ligonghai.Base.BaseTest;
import io.github.ligonghai.model.request.task.CreateTaskRequest;
import io.github.ligonghai.model.request.task.DeleteTaskRequest;
import io.github.ligonghai.model.request.task.GetTaskRequest;
import io.github.ligonghai.model.request.task.UpdateTaskRequest;
import io.github.ligonghai.model.response.task.CreateTaskResponse;
import io.github.ligonghai.model.response.task.DeleteTaskResponse;
import io.github.ligonghai.model.response.task.GetTaskResponse;
import io.github.ligonghai.model.response.task.UpdateTaskResponse;
import org.junit.Test;

import java.io.IOException;

public class TaskApiTest extends BaseTest {
    @Test
    public void createTask() throws IOException {
        CreateTaskRequest request = new CreateTaskRequest()
                .setName("api-test")
                .setComment("comment-1")
                .setTargetId("16790158-9664-439b-be0a-e033b7775cf3")
                .setConfigId("daba56c8-73ec-11df-a475-002264764cea")
                .setScannerId("08b69003-5fc2-4037-a479-93b440211c73");
        CreateTaskResponse response = client.call(request, new TypeReference<CreateTaskResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void deleteTask() throws IOException {
        DeleteTaskRequest request = new DeleteTaskRequest()
                .setId("0dc17640-cae6-4269-bbff-69f5bf0d47a4");
        DeleteTaskResponse response = client.call(request, new TypeReference<DeleteTaskResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void getTask() throws IOException {
        GetTaskRequest request = new GetTaskRequest();
        GetTaskResponse response = client.call(request, new TypeReference<GetTaskResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void updateTask() throws IOException {
        UpdateTaskRequest request = new UpdateTaskRequest()
                .setId("47609850-f3ee-481e-920c-b63eb40aa355")
                .setName("api-test-9999")
                .setComment("comment-9999");
        UpdateTaskResponse response = client.call(request, new TypeReference<UpdateTaskResponse>() {
        });
        assert response.isSuccess();
    }
}
