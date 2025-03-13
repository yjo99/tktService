package org.system.ticketsystem.exception;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.system.ticketsystem.dto.FormDto;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // Handles all exceptions
    public ModelAndView handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        ex.printStackTrace();
        ModelAndView mav = new ModelAndView("email-form"); // Specify the view name
        mav.addObject("tktForm", new FormDto());  // Add the form object to the model
        mav.addObject("generalError", "An error occurred. Please try again later.");
        return mav;
    }
    @ExceptionHandler(RuntimeException.class) // Handles all runtime exceptions
    public ModelAndView handleRuntimeException(RuntimeException ex) {
        log.error(ex.getMessage(), ex);
        ex.printStackTrace();
        ModelAndView mav = new ModelAndView("email-form"); // Specify the view name
        mav.addObject("tktForm", new FormDto());  // Add the form object to the model
        mav.addObject("generalError", "An error occurred. Please try again later.");
        return mav;
    }

    @ExceptionHandler(CustomException.class) // Handles all CustomException
    public ModelAndView handleCustomException(CustomException ex) {
        ex.printStackTrace();
        ModelAndView mav = new ModelAndView("email-form"); // Specify the view name
        mav.addObject("tktForm", new FormDto());  // Add the form object to the model
        mav.addObject("generalError", ex.getMessage());
        return mav;
    }
}
