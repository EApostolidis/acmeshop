package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.dto.ErrorMessage;
import gr.codehub.teamb.acmeshop.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(basePackageClasses = UserController.class)
public class AdviceController {
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleErrors(UserNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Book not found", 113));
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<List<ErrorMessage>> handleError(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<ErrorMessage> messageList =
                ex.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(fieldError -> new ErrorMessage(fieldError.getDefaultMessage(), 400))
                        .collect(Collectors.toList());


        /*List<ErrorMessage> messageList = new ArrayList<>();
        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            messageList.add(new ErrorMessage(objectError.getDefaultMessage(), 400));
        }*/

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageList);
    }


}
