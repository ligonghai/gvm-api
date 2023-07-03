package io.github.ligonghai;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.ligonghai.Base.BaseTest;
import io.github.ligonghai.model.request.config.CreateScanConfigRequest;
import io.github.ligonghai.model.request.config.DeleteScanConfigRequest;
import io.github.ligonghai.model.request.config.GetScanConfigRequest;
import io.github.ligonghai.model.response.config.CreateScanConfigResponse;
import io.github.ligonghai.model.response.config.DeleteScanConfigResponse;
import io.github.ligonghai.model.response.config.GetScanConfigResponse;
import org.junit.Test;

import java.io.IOException;

public class ConfigApiTest extends BaseTest {

    @Test
    public void createScanConfig() throws IOException {
        CreateScanConfigRequest request = new CreateScanConfigRequest()
                .setName("name-1")
                .setComment("comment-1")
                .setBase("d21f6c81-2b88-4ac1-b7b4-a2a9f2ad4663");
        CreateScanConfigResponse response = client.call(request, new TypeReference<CreateScanConfigResponse>() {
        });
        assert response.isSuccess();
    }


    @Test
    public void deleteScanConfig() throws IOException {
        DeleteScanConfigRequest request = new DeleteScanConfigRequest()
                .setId("83ef629a-189c-4bd3-b6ed-9f4e556e00ef");
        DeleteScanConfigResponse response = client.call(request, new TypeReference<DeleteScanConfigResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void getScanConfig() throws IOException {
        GetScanConfigRequest request = new GetScanConfigRequest();
        GetScanConfigResponse response = client.call(request, new TypeReference<GetScanConfigResponse>() {
        });
        assert response.isSuccess();
    }
}
