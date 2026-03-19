package com.example.productservice.controllerAdvice;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.dtos.ProductNotFoundExceptionDto;
import com.example.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductServiceExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionDto> handleRunTimeException(){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage("Something went wrong");
//        exceptionDto.setResolutionDetails("Pay more money");
//        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
//    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException ex) {
        Long idFromException = ex.getProductId();
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setProductId(idFromException);
        dto.setMessage(ex.getMessage());
        dto.setResolution("Better explore other products.Meanwhile we try to add this One...!");
        return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
    }
}
