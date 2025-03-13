package org.system.ticketsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BillDataDto {
    private String Client;
    private String paymentRequestNumber;
    private Date trxDate;
    private String billAmount;

}
