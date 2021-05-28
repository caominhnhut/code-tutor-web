package com.vn.green.courses.models;

import com.vn.green.courses.models.Status;
import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An object which contains details about a course.
 **/

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-05-28T00:22:03.224176+07:00[Asia/Bangkok]")public class Course   {
  
  private @Valid String name;
  private @Valid String iconUri;
  private @Valid Integer orderId;
  private @Valid Integer amountLesson;
  private @Valid String description;
  private @Valid Status status;

  /**
   * The name of a course.
   **/
  public Course name(String name) {
    this.name = name;
    return this;
  }

  

  
  @JsonProperty("name")
  @NotNull
 @Size(max=255)  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

/**
   * The icon that presents for a course.
   **/
  public Course iconUri(String iconUri) {
    this.iconUri = iconUri;
    return this;
  }

  

  
  @JsonProperty("iconUri")
  public String getIconUri() {
    return iconUri;
  }

  public void setIconUri(String iconUri) {
    this.iconUri = iconUri;
  }

/**
   * This specifies the priority for ordering.
   **/
  public Course orderId(Integer orderId) {
    this.orderId = orderId;
    return this;
  }

  

  
  @JsonProperty("orderId")
  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

/**
   * The amount of lesson.
   **/
  public Course amountLesson(Integer amountLesson) {
    this.amountLesson = amountLesson;
    return this;
  }

  

  
  @JsonProperty("amountLesson")
  public Integer getAmountLesson() {
    return amountLesson;
  }

  public void setAmountLesson(Integer amountLesson) {
    this.amountLesson = amountLesson;
  }

/**
   * The description of a course.
   **/
  public Course description(String description) {
    this.description = description;
    return this;
  }

  

  
  @JsonProperty("description")
  @NotNull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

/**
   **/
  public Course status(Status status) {
    this.status = status;
    return this;
  }

  

  
  @JsonProperty("status")
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return Objects.equals(this.name, course.name) &&
        Objects.equals(this.iconUri, course.iconUri) &&
        Objects.equals(this.orderId, course.orderId) &&
        Objects.equals(this.amountLesson, course.amountLesson) &&
        Objects.equals(this.description, course.description) &&
        Objects.equals(this.status, course.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, iconUri, orderId, amountLesson, description, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Course {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    iconUri: ").append(toIndentedString(iconUri)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    amountLesson: ").append(toIndentedString(amountLesson)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

