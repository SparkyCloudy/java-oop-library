package org.library.feature;

public abstract class Member extends Borrowable {

  private final String name;
  private final String id;

  protected Member(String name, String id) {
    this.name = name;
    this.id = id;
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }


}