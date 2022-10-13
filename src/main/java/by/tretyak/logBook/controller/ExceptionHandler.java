package by.tretyak.logBook.controller;

import by.tretyak.logBook.exception.ObjectNotFoundException;
import by.tretyak.logBook.model.dto.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public MessageResponse exception(Exception exception) {
        return new MessageResponse(exception.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public MessageResponse objectNotFoundException(ObjectNotFoundException exception) {
        return new MessageResponse(exception.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessageResponse runtimeException(RuntimeException exception) {
        return new MessageResponse(exception.getMessage());
    }

}
