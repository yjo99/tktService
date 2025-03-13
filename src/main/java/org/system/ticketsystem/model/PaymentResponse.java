package org.system.ticketsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    @JsonProperty("RandomSecret")
    private String randomSecret;

    @JsonProperty("HashedRequestObject")
    private String hashedRequestObject;

    @JsonProperty("SenderID")
    private String senderID;

    @JsonProperty("LanguageId")
    private String languageId;

    @JsonProperty("RequestObject")
    private String requestObject;

    private String redirectURI;
}
