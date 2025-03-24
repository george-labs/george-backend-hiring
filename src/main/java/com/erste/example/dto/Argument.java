package com.erste.example.dto;

public class Argument {

  private final int index;
  private final String name;

  public Argument(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public int getIndex() {
    return index;
  }

  public String getName() {
    return name;
  }
}
