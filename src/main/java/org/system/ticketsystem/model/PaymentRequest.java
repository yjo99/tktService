package org.system.ticketsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
public class PaymentRequest {

    @JsonProperty("senderId")
    private String senderId;
    @JsonProperty("senderRequestNumber")
    private String senderRequestNumber;
    @JsonProperty("serviceCode")
    private String serviceCode;
    @JsonProperty("requestDescription")
    private String requestDescription;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("paymentConfirmationRedirectUrl")
    private String confirmationUrl;
    @JsonProperty("expiryDate")
    private Instant expiryDate;

//    private String status;
}


