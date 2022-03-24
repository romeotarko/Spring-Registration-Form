package com.app.registration.Exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"cause", "stackTrace", "message", "suppressed", "localizedMessage"})
public class ProductApplicationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String errorMessage;

    @JsonIgnore
    private HttpStatus status;
}
