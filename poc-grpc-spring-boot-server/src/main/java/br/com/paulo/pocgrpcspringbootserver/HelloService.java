package br.com.paulo.pocgrpcspringbootserver;

import br.com.paulo.lib.HelloRequest;
import br.com.paulo.lib.HelloResponse;
import br.com.paulo.lib.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void say(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage(String.format("Hello my friend %s! What's up?", request.getName()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
