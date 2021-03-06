package com.tistory.jaimemin.vertx_starter.eventloops;

import io.vertx.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class EventLoopExample extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(EventLoopExample.class);

  public static void main(String[] args) {
    var vertx = Vertx.vertx(
      new VertxOptions()
        .setMaxEventLoopExecuteTime(500)
        .setMaxEventLoopExecuteTimeUnit(TimeUnit.MILLISECONDS)
        .setBlockedThreadCheckInterval(1)
        .setBlockedThreadCheckIntervalUnit(TimeUnit.SECONDS)
        .setEventLoopPoolSize(4)
    );
    vertx.deployVerticle(EventLoopExample.class.getName()
      , new DeploymentOptions().setInstances(4)
    );
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOG.debug("start {}", getClass().getName());

    startPromise.complete();
    // Don't do this inside a verticle
    // Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 4191 ms, time limit is 500 ms
    Thread.sleep(5000);
  }
}
