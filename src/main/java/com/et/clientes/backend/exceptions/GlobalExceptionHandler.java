package com.et.clientes.backend.exceptions;

import com.et.clientes.backend.payload.ApiResponse;
import com.et.clientes.backend.utils.Constants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    @ResponseBody
    public ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers,
                                 HttpStatus status, WebRequest request) {

        //Get all fields errors
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size());
        for (FieldError error : fieldErrors) {
            errors.add( error.getDefaultMessage() + ": '" + error.getField() + "'" );
        }

        ApiResponse apiResponse = new ApiResponse();

        return apiResponse.responseError(
                Constants.ERROR_VALID_FIELD,
                status,
                status.value(),
                errors,
                true );
    }

    @ExceptionHandler( RecordNotFoundException.class )
    public final ResponseEntity<Object> handleUserNotFoundException( RecordNotFoundException ex,
                                                                    WebRequest request ) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ApiResponse apiResponse = new ApiResponse();
        return apiResponse.responseError(
                Constants.RESOURCE_NOT_FOUND,
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(),
                details,
                true );
    }
}
