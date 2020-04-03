package client;

import dev.tobachi.sandbox.java.grpc.GreeterGrpc;
import dev.tobachi.sandbox.java.grpc.HelloReply;
import dev.tobachi.sandbox.java.grpc.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder()
                .setName("Tom")
                .build();

        HelloReply reply = stub.sayHello(request);

        System.out.println("Reply: " + reply);
    }

}
