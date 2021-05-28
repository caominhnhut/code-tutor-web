package com.vn.green.authentication.models;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The information of authentication.
 **/

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-05-28T00:22:02.845669100+07:00[Asia/Bangkok]")public class Authentication   {
  
  private @Valid String token;
  private @Valid Long expiredIn;

  /**
   * The token value.
   **/
  public Authentication token(String token) {
    this.token = token;
    return this;
  }

  

  
  @JsonProperty("token")
  @NotNull
 @Size(max=255)  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

/**
   * The time that specifies expriration of the token.
   **/
  public Authentication expiredIn(Long expiredIn) {
    this.expiredIn = expiredIn;
    return this;
  }

  

  
  @JsonProperty("expiredIn")
  @NotNull
  public Long getExpiredIn() {
    return expiredIn;
  }

  public void setExpiredIn(Long expiredIn) {
    this.expiredIn = expiredIn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Authentication authentication = (Authentication) o;
    return Objects.equals(this.token, authentication.token) &&
        Objects.equals(this.expiredIn, authentication.expiredIn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, expiredIn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Authentication {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    expiredIn: ").append(toIndentedString(expiredIn)).append("\n");
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

