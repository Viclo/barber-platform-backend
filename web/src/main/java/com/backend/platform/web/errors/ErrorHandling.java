package com.backend.platform.web.errors;

import com.backend.platform.application.exception.customer.BusinessException;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandling {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> constrainViolationException(HttpServletRequest request, ConstraintViolationException exception) {
    return ErrorResponse.createErrorResp(request, HttpStatus.BAD_REQUEST, exception);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> constrainViolationException(HttpServletRequest request, BusinessException exception) {
    return ErrorResponse.createErrorResp(request, HttpStatus.BAD_REQUEST, exception);
  }

  @Value
  public static class ErrorResponse {

    @Schema(description = "Timestamp in ISO-Format", example = "2023-03-14T00:31:20.884820")
    String timestamp;

    @Schema(description = "HTTP Status", example = "404")
    Integer status;

    @Schema(description = "Error that was thrown", example = "Customer does not exist")
    String error;

    @Schema(description = "Descriptive error message", example = "Customer with 'f9dc3b30-1fa5-4c23-8c28-cf00191d084e' does not exist")
    String message;

    @Schema(description = "Request path that was called", example = "/v3/customer")
    String path;

    public static ResponseEntity<ErrorResponse> createErrorResp(HttpServletRequest request, HttpStatus code, Exception exception) {
      final ErrorResponse errorResponse = new ErrorResponse(
          LocalDateTime.now().toString(),
          code.value(),
          exception.getClass().getSimpleName(),
          exception.getMessage(),
          request.getRequestURI()
      );

      return ResponseEntity.status(code).body(errorResponse);
    }
  }
}
