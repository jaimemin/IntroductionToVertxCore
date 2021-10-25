package com.tistory.jaimemin.vertx_starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    // Vertx is deploying this application internally
    // and the start method below is caught on line
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    // new HTTP service is created
    // this vertx instance is coming from the abstract vertically
    // each verticle you are deploying has a reference to the vertx instance
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello World!");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888"); // 비동기 콜백
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
