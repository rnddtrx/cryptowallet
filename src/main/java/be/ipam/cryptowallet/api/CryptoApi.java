/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package be.ipam.cryptowallet.api;

import be.ipam.cryptowallet.api.model.Crypto;
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
@Api(value = "Crypto", description = "the Crypto API")
public interface CryptoApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/crypto/ : Ajouter une crypto
     * Ajout une crypto
     *
     * @param crypto Crypto object (optional)
     * @return created (status code 201)
     */
    @ApiOperation(value = "Ajouter une crypto", nickname = "addCrypto", notes = "Ajout une crypto", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "Crypto", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "created") })
    @RequestMapping(value = "/api/v1/crypto/",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Crypto> addCrypto(@ApiParam(value = "Crypto object"  )  @Valid @RequestBody(required = false) Crypto crypto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/crypto/{cryptoId} : Delete crypto
     * Delete crypto
     *
     * @param cryptoId Crypto Identifier (required)
     * @return No content (status code 204)
     */
    @ApiOperation(value = "Delete crypto", nickname = "deleteCryptoById", notes = "Delete crypto", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "Crypto", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No content") })
    @RequestMapping(value = "/api/v1/crypto/{cryptoId}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteCryptoById(@ApiParam(value = "Crypto Identifier",required=true) @PathVariable("cryptoId") long cryptoId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/crypto/{cryptoId} : Retourne une crypto
     * Retourne une crypto
     *
     * @param cryptoId crypto Identifier (required)
     * @return successful operation (status code 200)
     *         or Given user ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Retourne une crypto", nickname = "getCryptoById", notes = "Retourne une crypto", response = Crypto.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "Crypto", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Crypto.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Given user ID doesn't exist") })
    @RequestMapping(value = "/api/v1/crypto/{cryptoId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Crypto> getCryptoById(@ApiParam(value = "crypto Identifier",required=true) @PathVariable("cryptoId") long cryptoId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"symbol\" : \"symbol\", \"name\" : \"name\", \"cryptoId\" : 2.3021358869347655, \"lastPrice\" : 7.061401241503109 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /api/v1/crypto/{cryptoId} : update the crypto
     * update the crypto
     *
     * @param cryptoId transaction Identifier (required)
     * @param crypto crypto object (optional)
     * @return Updated (status code 200)
     */
    @ApiOperation(value = "update the crypto", nickname = "updateCrypto", notes = "update the crypto", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "Crypto", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated") })
    @RequestMapping(value = "/api/v1/crypto/{cryptoId}",
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    default ResponseEntity<Void> updateCrypto(@ApiParam(value = "transaction Identifier",required=true) @PathVariable("cryptoId") Integer cryptoId,@ApiParam(value = "crypto object"  )  @Valid @RequestBody(required = false) Crypto crypto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
