package com.toystore.ecomm.users.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

/**
 * Address
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-04T22:49:45.638Z")

@Entity
@Table(name = "ADDRESS")
public class Address   {
  @JsonProperty("addressId")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ADDRESS_ID", nullable = false)
  private Integer addressId = null;

  @Column(name = "ADDRESS_TYPE", nullable = false)
  @JsonProperty("addressType")
  private String addressType = null;

  @Column(name = "USER_ID", nullable = false)
  @JsonProperty("userId")
  private Integer userId = null;

  @Column(name = "LINE1", nullable = false)
  @JsonProperty("line1")
  private String line1 = null;

  @Column(name = "LINE2", nullable = false)
  @JsonProperty("line2")
  private String line2 = null;

  @Column(name = "LINE3")
  @JsonProperty("line3")
  private String line3 = null;

  @Column(name = "DISTRICT", nullable = false)
  @JsonProperty("district")
  private String district = null;

  @Column(name = "STATE", nullable = false)
  @JsonProperty("state")
  private String state = null;

  @Column(name = "COUNTRY", nullable = false)
  @JsonProperty("country")
  private String country = null;
  
  @Column(name = "ZIP_CODE", nullable = false)
  @JsonProperty("zipCode")
  private String zipCode = null;

  public Address addressId(Integer addressId) {
    this.addressId = addressId;
    return this;
  }

  /**
   * This is unique for each address
   * @return addressId
  **/
  @ApiModelProperty(required = true, value = "This is unique for each address")
  @NotNull


  public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  public Address addressType(String addressType) {
    this.addressType = addressType;
    return this;
  }

  /**
   * This is address type (billing or shipping)
   * @return addressType
  **/
  @ApiModelProperty(required = true, value = "This is address type (billing or shipping)")
  @NotNull


  public String getAddressType() {
    return addressType;
  }

  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }

  public Address userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * This is the User to which the current address belongs to
   * @return userId
  **/
  @ApiModelProperty(required = true, value = "This is the User to which the current address belongs to")
  @NotNull


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Address line1(String line1) {
    this.line1 = line1;
    return this;
  }

  /**
   * This is first line of the address
   * @return line1
  **/
  @ApiModelProperty(required = true, value = "This is first line of the address")
  @NotNull


  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public Address line2(String line2) {
    this.line2 = line2;
    return this;
  }

  /**
   * This is second line of the address
   * @return line2
  **/
  @ApiModelProperty(value = "This is second line of the address")


  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public Address line3(String line3) {
    this.line3 = line3;
    return this;
  }

  /**
   * This is third line of the address
   * @return line3
  **/
  @ApiModelProperty(value = "This is third line of the address")


  public String getLine3() {
    return line3;
  }

  public void setLine3(String line3) {
    this.line3 = line3;
  }

  public Address district(String district) {
    this.district = district;
    return this;
  }

  /**
   * This is district of the address
   * @return district
  **/
  @ApiModelProperty(required = true, value = "This is district of the address")
  @NotNull


  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public Address state(String state) {
    this.state = state;
    return this;
  }

  /**
   * This is state of the address
   * @return state
  **/
  @ApiModelProperty(required = true, value = "This is state of the address")
  @NotNull


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This is country of the address
   * @return country
  **/
  @ApiModelProperty(required = true, value = "This is country of the address")
  @NotNull


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public String getZipCode() {
	return zipCode;
}

public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}


public Address withId(Integer id){
	    this.setAddressId(id);
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
    Address address = (Address) o;
    return Objects.equals(this.addressId, address.addressId) &&
        Objects.equals(this.addressType, address.addressType) &&
        Objects.equals(this.userId, address.userId) &&
        Objects.equals(this.line1, address.line1) &&
        Objects.equals(this.line2, address.line2) &&
        Objects.equals(this.line3, address.line3) &&
        Objects.equals(this.district, address.district) &&
        Objects.equals(this.state, address.state) &&
        Objects.equals(this.country, address.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressId, addressType, userId, line1, line2, line3, district, state, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    addressId: ").append(toIndentedString(addressId)).append("\n");
    sb.append("    addressType: ").append(toIndentedString(addressType)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    line1: ").append(toIndentedString(line1)).append("\n");
    sb.append("    line2: ").append(toIndentedString(line2)).append("\n");
    sb.append("    line3: ").append(toIndentedString(line3)).append("\n");
    sb.append("    district: ").append(toIndentedString(district)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

