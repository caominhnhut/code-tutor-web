package com.vn.green.authentication.models;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An object which contains details about a credential.
 **/

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-05-28T00:22:02.845669100+07:00[Asia/Bangkok]")public class Credential   {
  
  private @Valid String username;
  private @Valid String password;

  /**
   * The of username account.
   **/
  public Credential username(String username) {
    this.username = username;
    return this;
  }

  

  
  @JsonProperty("username")
  @NotNull
 @Size(max=255)  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

/**
   * The password of account.
   **/
  public Credential password(String password) {
    this.password = password;
    return this;
  }

  

  
  @JsonProperty("password")
  @NotNull
 @Size(max=20)  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Credential credential = (Credential) o;
    return Objects.equals(this.username, credential.username) &&
        Objects.equals(this.password, credential.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Credential {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

