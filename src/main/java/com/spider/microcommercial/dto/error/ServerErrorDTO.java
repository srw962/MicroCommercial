package com.spider.microcommercial.dto.error;

import com.google.common.collect.Lists;

import java.util.List;

public class ServerErrorDTO {
  private String error;
  private String description;
  private List<Object> details = Lists.newArrayList();

  public ServerErrorDTO() {
  }

  public ServerErrorDTO(String error, String description, List<Object> details) {
    this.error = error;
    this.description = description;
    this.details = details;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Object> getDetails() {
    return details;
  }

  public void setDetails(List<Object> details) {
    this.details = details;
  }
}
