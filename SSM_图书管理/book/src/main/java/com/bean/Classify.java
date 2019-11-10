package com.bean;


public class Classify {

  private long classifyId;
  private String classifyName;

  public Classify() {
  }

  public Classify(long classifyId, String classifyName) {
    this.classifyId = classifyId;
    this.classifyName = classifyName;
  }

  public long getClassifyId() {
    return classifyId;
  }

  public void setClassifyId(long classifyId) {
    this.classifyId = classifyId;
  }


  public String getClassifyName() {
    return classifyName;
  }

  public void setClassifyName(String classifyName) {
    this.classifyName = classifyName;
  }

  @Override
  public String toString() {
    return "Classify{" +
            "classifyId=" + classifyId +
            ", classifyName='" + classifyName + '\'' +
            '}';
  }
}
