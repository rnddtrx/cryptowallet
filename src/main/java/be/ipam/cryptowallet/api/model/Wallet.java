package be.ipam.cryptowallet.api.model;

import java.util.Objects;
import be.ipam.cryptowallet.api.model.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Une classe Wallet
 */
@ApiModel(description = "Une classe Wallet")

public class Wallet extends RepresentationModel<Wallet>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("walletId")
  private long walletId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("addressEth")
  private String addressEth;

  @JsonProperty("addressBtc")
  private String addressBtc;

  @JsonProperty("transactions")
  @Valid
  private List<Transaction> transactions = null;

  public Wallet walletId(long walletId) {
    this.walletId = walletId;
    return this;
  }

  /**
   * Wallet ID
   * @return walletId
  */
  @ApiModelProperty(value = "Wallet ID")

  @Valid

  public long getWalletId() {
    return walletId;
  }

  public void setWalletId(long walletId) {
    this.walletId = walletId;
  }

  public Wallet name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nom
   * @return name
  */
  @ApiModelProperty(value = "Nom")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Wallet addressEth(String addressEth) {
    this.addressEth = addressEth;
    return this;
  }

  /**
   * Adresse Ether
   * @return addressEth
  */
  @ApiModelProperty(value = "Adresse Ether")


  public String getAddressEth() {
    return addressEth;
  }

  public void setAddressEth(String addressEth) {
    this.addressEth = addressEth;
  }

  public Wallet addressBtc(String addressBtc) {
    this.addressBtc = addressBtc;
    return this;
  }

  /**
   * Adresse Bitcoin
   * @return addressBtc
  */
  @ApiModelProperty(value = "Adresse Bitcoin")


  public String getAddressBtc() {
    return addressBtc;
  }

  public void setAddressBtc(String addressBtc) {
    this.addressBtc = addressBtc;
  }

  public Wallet transactions(List<Transaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public Wallet addTransactionsItem(Transaction transactionsItem) {
    if (this.transactions == null) {
      this.transactions = new ArrayList<>();
    }
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * Collection of Song.
   * @return transactions
  */
  @ApiModelProperty(value = "Collection of Song.")

  @Valid

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Wallet wallet = (Wallet) o;
    return Objects.equals(this.walletId, wallet.walletId) &&
        Objects.equals(this.name, wallet.name) &&
        Objects.equals(this.addressEth, wallet.addressEth) &&
        Objects.equals(this.addressBtc, wallet.addressBtc) &&
        Objects.equals(this.transactions, wallet.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(walletId, name, addressEth, addressBtc, transactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Wallet {\n");
    
    sb.append("    walletId: ").append(toIndentedString(walletId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    addressEth: ").append(toIndentedString(addressEth)).append("\n");
    sb.append("    addressBtc: ").append(toIndentedString(addressBtc)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

