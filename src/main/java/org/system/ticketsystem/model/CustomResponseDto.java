package org.system.ticketsystem.model;

import lombok.Data;

@Data
public class CustomResponseDto <T>{

    private String code;
    private String message;
    private T data;
}
