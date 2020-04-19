package com.toystore.ecomm.users.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-04T22:49:45.638Z")

@Entity
@Table(name = "USER")
public class User   {
  @JsonProperty("userId")
  @Id
  @Column(name = "USER_ID", nullable = false)
  private Integer userId = null;

  @JsonProperty("firstName")
  @Column(name = "FIRST_NAME", nullable = false)
  private String firstName = null;

  @JsonProperty("lastName")
  @Column(name = "LAST_NAME", nullable = false)
  private String lastName = null;

  @JsonProperty("middleName")
  @Column(name = "MIDDLE_NAME", nullable = false)
  private String middleName = null;

  @JsonProperty("emailId")
  @Column(name = "EMAIL_ID", nullable = false)
  private String emailId = null;

  @JsonProperty("primaryContact")
  @Column(name = "PRIMARY_CONTACT", nullable = false)
  private String primaryContact = null;

  public User userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * This is unique for each user
   * @return userId
  **/
  @ApiModelProperty(required = true, value = "This is unique for each user")
  @NotNull


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * This is first name of the user
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "This is first name of the user")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * This is last name of the user
   * @return lastName
  **/
  @ApiModelProperty(required = true, value = "This is last name of the user")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * This is middle name of the user
   * @return middleName
  **/
  @ApiModelProperty(value = "This is middle name of the user")


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public User emailId(String emailId) {
    this.emailId = emailId;
    return this;
  }

  /**
   * This is email address of the user
   * @return emailId
  **/
  @ApiModelProperty(required = true, value = "This is email address of the user")
  @NotNull


  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public User primaryContact(String primaryContact) {
    this.primaryContact = primaryContact;
    return this;
  }

  /**
   * This is mobile no. of the user
   * @return primaryContact
  **/
  @ApiModelProperty(required = true, value = "This is mobile no. of the user")
  @NotNull


  public String getPrimaryContact() {
    return primaryContact;
  }

  public void setPrimaryContact(String primaryContact) {
    this.primaryContact = primaryContact;
  }
  
  public User withId(Integer id){
	    this.setUserId(id);
	    return this;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userId, user.userId) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.middleName, user.middleName) &&
        Objects.equals(this.emailId, user.emailId) &&
        Objects.equals(this.primaryContact, user.primaryContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, firstName, lastName, middleName, emailId, primaryContact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    primaryContact: ").append(toIndentedString(primaryContact)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

