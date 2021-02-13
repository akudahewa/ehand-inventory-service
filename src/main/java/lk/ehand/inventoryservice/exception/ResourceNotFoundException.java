package lk.ehand.inventoryservice.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String field;
    private String error;

    public ResourceNotFoundException(String resource,String field,
                                     String error){
//        log.error("{} not found :{}",resource,error);
        this.resource =resource;
        this.field=field;
        this.error =error;
    }

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
