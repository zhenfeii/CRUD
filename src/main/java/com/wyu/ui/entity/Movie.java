package com.wyu.ui.entity;

public class Movie {
  private Long id;
  private String moviename;
  private java.sql.Date creatdate;
  private String operation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMoviename() {
    return moviename;
  }

  public void setMoviename(String moviename) {
    this.moviename = moviename;
  }

  public java.sql.Date getCreatdate() {
    return creatdate;
  }

  public void setCreatdate(java.sql.Date creatdate) {
    this.creatdate = creatdate;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }
}
