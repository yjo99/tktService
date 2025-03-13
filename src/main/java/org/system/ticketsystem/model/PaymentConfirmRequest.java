package org.system.ticketsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class PaymentConfirmRequest {

    @JsonProperty("senderRequestNumber")
    private String senderRequestNumber;
    @JsonProperty("paymentRequestNumber")
    private String paymentRequestNumber;
    @JsonProperty("paymentRequestTotalAmount")
    private String paymentRequestTotalAmount;
    @JsonProperty("collectionFeesAmount")
    private String collectionFeesAmount;
    @JsonProperty("customerAuthorizationAmount")
    private String customerAuthorizationAmount;
    @JsonProperty("authorizationCode")
    private Double authorizationCode;
    @JsonProperty("transactionNumber")
    private String transactionNumber;
    @JsonProperty("authorizingMechanism")
    private String authorizingMechanism;
    @JsonProperty("authorizingInstitution")
    private String authorizingInstitution;
    private LocalDateTime authorizationDateTime;
    private LocalDateTime reconciliationDate;
    @JsonProperty("isConfirmed")
    private Boolean isConfirmed;
}
