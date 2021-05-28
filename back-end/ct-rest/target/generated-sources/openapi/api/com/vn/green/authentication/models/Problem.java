package com.vn.green.authentication.models;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A generic problem response describing a client or server problem.
 **/

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-05-28T00:22:02.845669100+07:00[Asia/Bangkok]")public class Problem   {
  
  private @Valid String title;
  private @Valid Integer status;
  private @Valid String detail;

  /**
   * A summary of the problem.
   **/
  public Problem title(String title) {
    this.title = title;
    return this;
  }

  

  
  @JsonProperty("title")
  @NotNull
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

/**
   * The HTTP status code.
   * minimum: 100
   * maximum: 600
   **/
  public Problem status(Integer status) {
    this.status = status;
    return this;
  }

  

  
  @JsonProperty("status")
  @NotNull
 @Min(100) @Max(600)  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

/**
   * A detail of problem.
   **/
  public Problem detail(String detail) {
    this.detail = detail;
    return this;
  }

  

  
  @JsonProperty("detail")
  @NotNull
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Problem problem = (Problem) o;
    return Objects.equals(this.title, problem.title) &&
        Objects.equals(this.status, problem.status) &&
        Objects.equals(this.detail, problem.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, status, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Problem {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

