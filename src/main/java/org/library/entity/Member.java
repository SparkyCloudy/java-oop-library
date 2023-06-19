package org.library.entity;

abstract class Member {

  private final String NAME;
  private final String ID;
  private String USERNAME;
  private String PASSWORD;

  protected Member(String name, String id) {
    this.NAME = name;
    this.ID = id;
  }

  public String id() {
    return this.ID;
  }

  public String name() {
    return this.NAME;
  }
  
  public void setPASSWORD(String password) {
    this.PASSWORD = password;
  }
  
  public void setUSERNAME(String username) {
    this.USERNAME = username;
  }
  
  public String getUSERNAME() {
    return this.USERNAME;
  }
  
  public String getPASSWORD() {
    return this.PASSWORD;
  }
}