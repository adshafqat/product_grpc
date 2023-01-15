
package com.zaynsolutions.grpc;

import io.grpc.stub.StreamObserver;

public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {
  @Override
  public void product(ProductRequest request,
        StreamObserver<ProductResponse> responseObserver) {
    System.out.println(request);

    // You must use a builder to construct a new Protobuffer object
    ProductResponse response = ProductResponse.newBuilder().setProductId(request.getProductId()).setProductName("MacBookPro").setProductPrice("$1500").build();

    // Use responseObserver to send a single response back
    responseObserver.onNext(response);

    // When you are done, you must call onCompleted.
    responseObserver.onCompleted();
  }
}