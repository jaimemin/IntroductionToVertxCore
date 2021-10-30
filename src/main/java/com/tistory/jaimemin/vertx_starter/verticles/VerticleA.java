package com.tistory.jaimemin.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleA extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleA.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOG.info("Start {}", getClass().getName());

    vertx.deployVerticle(new VerticleAA(), whenDeployed -> {
      LOG.info("Deployed {}", VerticleAA.class.getName());

      vertx.undeploy(whenDeployed.result()); // id of VerticleAA
    });
    vertx.deployVerticle(new VerticleAB(), whenDeployed -> {
      LOG.info("Deployed {}", VerticleAB.class.getName());
    });
    startPromise.complete();
  }
}
