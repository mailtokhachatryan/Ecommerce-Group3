package am.smartcode.ecommerce.exception.globalHandler;

import am.smartcode.ecommerce.exception.EntityNotFoundException;
import am.smartcode.ecommerce.util.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ProblemDetail handleEntityNotFoundException(HttpServletRequest request, EntityNotFoundException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NO_CONTENT, exception.getMessage());
        problemDetail.setTitle("Resource not found");
        problemDetail.setType(URI.create(request.getRequestURI()));
        return problemDetail;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleResourceNotFoundException(HttpServletRequest req, RuntimeException e) {
//        logError(req, e);
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage(), req.getRequestURI());
    }

    private ResponseEntity<ApiError> buildResponse(HttpStatus httpCode, String message, String requestURI) {
        var errors = new HashMap<String, String>();
        errors.put("message", message);
        var apiError = new ApiError(httpCode.value(), requestURI, errors);
        return ResponseEntity.status(httpCode).body(apiError);
    }




}
