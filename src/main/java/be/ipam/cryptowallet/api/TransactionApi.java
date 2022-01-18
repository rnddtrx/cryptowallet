/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package be.ipam.cryptowallet.api;

import be.ipam.cryptowallet.api.model.Transaction;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
@Api(value = "Transaction", description = "the Transaction API")
public interface TransactionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/transaction/ : Ajouter une transaction
     * Ajout une transaction
     *
     * @param transaction Transaction object (optional)
     * @return created (status code 201)
     */
    @ApiOperation(value = "Ajouter une transaction", nickname = "addTransaction", notes = "Ajout une transaction", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "Transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "created") })
    @RequestMapping(value = "/api/v1/transaction/",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Transaction> addTransaction(@ApiParam(value = "Transaction object"  )  @Valid @RequestBody(required = false) Transaction transaction) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/transaction/{transactionId} : Delete transaction
     * Delete transaction
     *
     * @param transactionId Transaction Identifier (required)
     * @return No content (status code 204)
     */
    @ApiOperation(value = "Delete transaction", nickname = "deleteTransactionById", notes = "Delete transaction", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "Transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No content") })
    @RequestMapping(value = "/api/v1/transaction/{transactionId}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteTransactionById(@ApiParam(value = "Transaction Identifier",required=true) @PathVariable("transactionId") long transactionId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/transaction/{transactionId} : Retourne une transaction
     * Retourne une transaction
     *
     * @param transactionId transaction Identifier (required)
     * @return successful operation (status code 200)
     *         or Given user ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Retourne une transaction", nickname = "getTransactionById", notes = "Retourne une transaction", response = Transaction.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "Transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Transaction.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Given user ID doesn't exist") })
    @RequestMapping(value = "/api/v1/transaction/{transactionId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Transaction> getTransactionById(@ApiParam(value = "transaction Identifier",required=true) @PathVariable("transactionId") long transactionId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"date\" : \"date\", \"number\" : 1.4658129805029452, \"price\" : 5.962133916683182, \"operation\" : 5.637376656633329, \"transactionId\" : 6.027456183070403, \"crypto\" : { \"symbol\" : \"symbol\", \"name\" : \"name\", \"cryptoId\" : 2.3021358869347655, \"lastPrice\" : 7.061401241503109 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /api/v1/transaction/{transactionId} : update the transaction
     * update the transaction
     *
     * @param transactionId transaction Identifier (required)
     * @param transaction Transaction object (optional)
     * @return Updated (status code 200)
     */
    @ApiOperation(value = "update the transaction", nickname = "updateTransaction", notes = "update the transaction", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "Transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated") })
    @RequestMapping(value = "/api/v1/transaction/{transactionId}",
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    default ResponseEntity<Void> updateTransaction(@ApiParam(value = "transaction Identifier",required=true) @PathVariable("transactionId") long transactionId,@ApiParam(value = "Transaction object"  )  @Valid @RequestBody(required = false) Transaction transaction) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}