package com.fengzw.minimall.minimalluser.service;

import com.fengzw.minimall.minimalluser.domain.User;
import com.fengzw.minimall.minimalluser.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@GrpcService
public class GrpcServerService extends UserServiceGrpc.UserServiceImplBase {
    private final UserRepository userRepo;

    @Autowired
    public GrpcServerService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void getUser(GetUserRequest request, StreamObserver<GetUserReply> responseObserver) {
        var userId = request.getId();
        Optional<User> byId = userRepo.findById(userId);
        if (byId.isPresent())
        {
//            System.out.println(byId);
            var found = byId.get();
            GetUserReply reply = GetUserReply.newBuilder()
                    .setId(found.getId())
                    .setUsername(found.getUsername())
                    .setPassword(found.getPassword())
                    .setNickname(found.getNickname())
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }else {
            responseObserver.onNext(null);
            responseObserver.onCompleted();
        }
    }
}
