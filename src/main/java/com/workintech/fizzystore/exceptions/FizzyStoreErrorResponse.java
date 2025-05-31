package com.workintech.fizzystore.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FizzyStoreErrorResponse {
    private String message;
    private int status;
    private Long timestamp;
}
