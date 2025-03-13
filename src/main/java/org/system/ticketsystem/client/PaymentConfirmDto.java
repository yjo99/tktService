package org.system.ticketsystem.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentConfirmDto {

    @JsonProperty("location")
    private String location;
}
