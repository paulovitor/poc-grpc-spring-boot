package br.com.paulo.pocgrpcspringbootclient;

import br.com.paulo.lib.HelloRequest;
import br.com.paulo.lib.HelloResponse;
import br.com.paulo.lib.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GrpcClient("local-grpc-server")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceStub;

    @GetMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Paulo") String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloResponse response = helloServiceStub.say(request);
        return response.getMessage();
    }
}
