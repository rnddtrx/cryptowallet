package be.ipam.cryptowallet.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Une classe User
 */
@ApiModel(description = "Une classe User")

public class User extends RepresentationModel<User>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("userId")
  private BigDecimal userId;

  @JsonProperty("lastname")
  private String lastname;

  @JsonProperty("firstname")
  private String firstname;

  @JsonProperty("mail")
  private String mail;

  @JsonProperty("password")
  private String password;

  public User userId(BigDecimal userId) {
    this.userId = userId;
    return this;
  }

  /**
   * User ID
   * @return userId
  */
  @ApiModelProperty(value = "User ID")

  @Valid

  public BigDecimal getUserId() {
    return userId;
  }

  public void setUserId(BigDecimal userId) {
    this.userId = userId;
  }

  public User lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * Nom
   * @return lastname
  */
  @ApiModelProperty(value = "Nom")


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public User firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * Prénom
   * @return firstname
  */
  @ApiModelProperty(value = "Prénom")


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public User mail(String mail) {
    this.mail = mail;
    return this;
  }

  /**
   * Mail
   * @return mail
  */
  @ApiModelProperty(value = "Mail")


  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password
   * @return password
  */
  @ApiModelProperty(value = "Password")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
        Objects.equals(this.lastname, user.lastname) &&
        Objects.equals(this.firstname, user.firstname) &&
        Objects.equals(this.mail, user.mail) &&
        Objects.equals(this.password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, lastname, firstname, mail, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    mail: ").append(toIndentedString(mail)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

