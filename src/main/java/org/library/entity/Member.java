package org.library.entity;

abstract class Member {

  private final String NAME;
  private final String ID;

  protected Member(String name, String id) {
    this.NAME = name;
    this.ID = id;
  }

  public String id() {
    return ID;
  }

  public String name() {
    return NAME;
  }
}