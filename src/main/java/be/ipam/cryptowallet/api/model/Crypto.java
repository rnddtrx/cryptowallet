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
 * Une classe Crypto
 */
@ApiModel(description = "Une classe Crypto")

public class Crypto extends RepresentationModel<Crypto>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("cryptoId")
  private long cryptoId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("lastPrice")
  private long lastPrice;

  public Crypto cryptoId(long cryptoId) {
    this.cryptoId = cryptoId;
    return this;
  }

  /**
   * Crypto id
   * @return cryptoId
  */
  @ApiModelProperty(value = "Crypto id")

  @Valid

  public long getCryptoId() {
    return cryptoId;
  }

  public void setCryptoId(long cryptoId) {
    this.cryptoId = cryptoId;
  }

  public Crypto name(String name) {
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

  public Crypto symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  /**
   * Symbole
   * @return symbol
  */
  @ApiModelProperty(value = "Symbole")


  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Crypto lastPrice(long lastPrice) {
    this.lastPrice = lastPrice;
    return this;
  }

  /**
   * Dernier prix
   * @return lastPrice
  */
  @ApiModelProperty(value = "Dernier prix")

  @Valid

  public long getLastPrice() {
    return lastPrice;
  }

  public void setLastPrice(long lastPrice) {
    this.lastPrice = lastPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Crypto crypto = (Crypto) o;
    return Objects.equals(this.cryptoId, crypto.cryptoId) &&
        Objects.equals(this.name, crypto.name) &&
        Objects.equals(this.symbol, crypto.symbol) &&
        Objects.equals(this.lastPrice, crypto.lastPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cryptoId, name, symbol, lastPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Crypto {\n");
    
    sb.append("    cryptoId: ").append(toIndentedString(cryptoId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    lastPrice: ").append(toIndentedString(lastPrice)).append("\n");
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

