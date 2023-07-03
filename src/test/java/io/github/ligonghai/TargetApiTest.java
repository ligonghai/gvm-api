package io.github.ligonghai;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.ligonghai.Base.BaseTest;
import io.github.ligonghai.model.request.target.CreateTargetRequest;
import io.github.ligonghai.model.request.target.DeleteTargetRequest;
import io.github.ligonghai.model.request.target.GetTargetRequest;
import io.github.ligonghai.model.response.target.CreateTargetResponse;
import io.github.ligonghai.model.response.target.DeleteTargetResponse;
import io.github.ligonghai.model.response.target.GetTargetResponse;
import org.junit.Test;

import java.io.IOException;

public class TargetApiTest extends BaseTest {
    @Test
    public void createTarget() throws IOException {
        CreateTargetRequest request = new CreateTargetRequest()
                .setName("name-1")
                .setComment("comment-1")
                .setHosts("127.0.0.1")
                .setPortListId("33d0cd82-57c6-11e1-8ed1-406186ea4fc5");
        CreateTargetResponse response = client.call(request, new TypeReference<CreateTargetResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void deleteTarget() throws IOException {
        DeleteTargetRequest request = new DeleteTargetRequest()
                .setId("b779a2d7-1e8b-483e-9a71-c79711865ef3");
        DeleteTargetResponse response = client.call(request, new TypeReference<DeleteTargetResponse>() {
        });
        assert response.isSuccess();
    }


    @Test
    public void getTarget() throws IOException {
        GetTargetRequest request = new GetTargetRequest();
        GetTargetResponse response = client.call(request, new TypeReference<GetTargetResponse>() {
        });
        assert response.isSuccess();
    }

}
