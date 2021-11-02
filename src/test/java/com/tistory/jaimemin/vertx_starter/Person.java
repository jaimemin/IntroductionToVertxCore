package com.tistory.jaimemin.vertx_starter;

public class Person {

  private Integer id;

  private String name;

  private boolean lovesVertx;

  public Person() {}

  public Person(Integer id, String name, boolean lovesVertx) {
    this.id = id;
    this.name = name;
    this.lovesVertx = lovesVertx;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public boolean isLovesVertx() {
    return lovesVertx;
  }
}
