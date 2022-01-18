package be.ipam.cryptowallet.api.model;

import java.util.Objects;
import be.ipam.cryptowallet.api.model.Crypto;
import be.ipam.cryptowallet.api.model.Wallet;
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
 * Une classe Transaction
 */
@ApiModel(description = "Une classe Transaction")

public class Transaction extends RepresentationModel<Transaction>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("transactionId")
  private long transactionId;

  @JsonProperty("number")
  private long number;

  @JsonProperty("date")
  private String date;

  @JsonProperty("price")
  private double price;

  @JsonProperty("operation")
  private long operation;

  @JsonProperty("wallet")
  private Wallet wallet;

  @JsonProperty("crypto")
  private Crypto crypto;

  public Transaction transactionId(long transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * Transaction ID
   * @return transactionId
  */
  @ApiModelProperty(value = "Transaction ID")

  @Valid

  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }

  public Transaction number(long number) {
    this.number = number;
    return this;
  }

  /**
   * Nombre acheté
   * @return number
  */
  @ApiModelProperty(value = "Nombre acheté")

  @Valid

  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }

  public Transaction date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Date Opération
   * @return date
  */
  @ApiModelProperty(value = "Date Opération")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Transaction price(double price) {
    this.price = price;
    return this;
  }

  /**
   * Prix achat vente
   * @return price
  */
  @ApiModelProperty(value = "Prix achat vente")

  @Valid

  public double getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public Transaction operation(long operation) {
    this.operation = operation;
    return this;
  }

  /**
   * Numéro Operation
   * @return operation
  */
  @ApiModelProperty(value = "Numéro Operation")

  @Valid

  public long getOperation() {
    return operation;
  }

  public void setOperation(long operation) {
    this.operation = operation;
  }

  public Transaction wallet(Wallet wallet) {
    this.wallet = wallet;
    return this;
  }

  /**
   * Get wallet
   * @return wallet
  */
  @ApiModelProperty(value = "")

  @Valid

  public Wallet getWallet() {
    return wallet;
  }

  public void setWallet(Wallet wallet) {
    this.wallet = wallet;
  }

  public Transaction crypto(Crypto crypto) {
    this.crypto = crypto;
    return this;
  }

  /**
   * Get crypto
   * @return crypto
  */
  @ApiModelProperty(value = "")

  @Valid

  public Crypto getCrypto() {
    return crypto;
  }

  public void setCrypto(Crypto crypto) {
    this.crypto = crypto;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.transactionId, transaction.transactionId) &&
        Objects.equals(this.number, transaction.number) &&
        Objects.equals(this.date, transaction.date) &&
        Objects.equals(this.price, transaction.price) &&
        Objects.equals(this.operation, transaction.operation) &&
        Objects.equals(this.wallet, transaction.wallet) &&
        Objects.equals(this.crypto, transaction.crypto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, number, date, price, operation, wallet, crypto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    wallet: ").append(toIndentedString(wallet)).append("\n");
    sb.append("    crypto: ").append(toIndentedString(crypto)).append("\n");
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

