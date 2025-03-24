package com.erste.example.dto;

public class Argument {

  private final String name;
  private final String value;

  public Argument(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }

}
