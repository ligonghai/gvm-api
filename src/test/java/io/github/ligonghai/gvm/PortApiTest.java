package io.github.ligonghai.gvm;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.ligonghai.gvm.Base.BaseTest;
import io.github.ligonghai.gvm.constant.PortType;
import io.github.ligonghai.gvm.model.request.port.*;
import io.github.ligonghai.gvm.model.response.port.*;
import org.junit.Test;

import java.io.IOException;

public class PortApiTest extends BaseTest {
    @Test
    public void getPortList() throws IOException {
        GetPortListRequest request = new GetPortListRequest();
        GetPortListResponse response = client.call(request, new TypeReference<GetPortListResponse>() {
        });
        System.out.println(response.getPageInfo());
        assert response.isSuccess();
    }

    @Test
    public void getPortListRange() throws IOException {
        GetPortListRangeRequest request = new GetPortListRangeRequest().setId("2e3f6934-d842-4edc-a9df-14841159e255");
        GetPortListRangeResponse response = client.call(request, new TypeReference<GetPortListRangeResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void createPortList() throws IOException {
        CreatePortListRequest request = new CreatePortListRequest()
                .setName("test-01")
                .setComment("测试")
                .setPortRange("T:1-5,7,9,U:1-3,5,7,9");
        CreatePortListResponse response = client.call(request, new TypeReference<CreatePortListResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void deletePortList() throws IOException {
        DeletePortListRequest request = new DeletePortListRequest()
                .setId("a64db64e-d8dc-4931-bed7-81071ef4ab10");
        DeletePortListResponse response = client.call(request, new TypeReference<DeletePortListResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void updatePortList() throws IOException {
        UpdatePortListRequest request = new UpdatePortListRequest()
                .setId("2e3f6934-d842-4edc-a9df-14841159e255")
                .setName("9999999999")
                .setComment("9999999") ;
        UpdatePortListResponse response = client.call(request, new TypeReference<UpdatePortListResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void createPortRange() throws IOException {
        CreatePortRangeRequest request = new CreatePortRangeRequest()
                .setPortListId("2e3f6934-d842-4edc-a9df-14841159e255")
                .setPortRangeStart(666)
                .setPortRangeEnd(777)
                .setPortType(PortType.TCP) ;
        CreatePortRangeResponse response = client.call(request, new TypeReference<CreatePortRangeResponse>() {
        });
        assert response.isSuccess();
    }

    @Test
    public void deletePortRange() throws IOException {
        DeletePortRangeRequest request = new DeletePortRangeRequest()
                .setId("ea7bc296-63c0-4954-9d72-452ec6c9d654");
        DeletePortRangeResponse response = client.call(request, new TypeReference<DeletePortRangeResponse>() {
        });
        assert response.isSuccess();
    }

}
