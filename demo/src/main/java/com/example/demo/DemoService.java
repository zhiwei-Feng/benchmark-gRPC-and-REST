package com.example.demo;

import com.fengzw.minimall.minimalluser.service.GetUserReply;
import com.fengzw.minimall.minimalluser.service.GetUserRequest;
import com.fengzw.minimall.minimalluser.service.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @GrpcClient("user-server")
    private UserServiceGrpc.UserServiceBlockingStub userServiceStub;

    public User getUser(Long id) {
        var request = GetUserRequest.newBuilder().setId(id).build();
        var reply = userServiceStub.getUser(request);
        return new User(reply.getId(),
                reply.getUsername(),
                reply.getPassword(),
                reply.getNickname());
    }
}
