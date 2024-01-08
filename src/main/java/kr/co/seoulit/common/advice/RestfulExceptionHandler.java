package kr.co.seoulit.common.advice;

import kr.co.seoulit.common.to.ResultTO;
import kr.co.seoulit.erp.hr.affair.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class RestfulExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        ResultTO result =
                new ResultTO(
                        new Date(), exception.getMessage(),
                        request.getDescription(false),
                        "-1", "관리자에게 문의하세요");

        return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotfoundException(
            Exception exception, WebRequest request) {
        ResultTO result = new ResultTO(
                new Date(), exception.getMessage(),
                request.getDescription(false),
                "-1", "유저정보가 없습니다.");

        return new ResponseEntity(result, HttpStatus.NOT_FOUND);
    }
}
