package org.system.ticketsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.system.ticketsystem.dto.BillDataDto;
import org.system.ticketsystem.dto.FormDto;
import org.system.ticketsystem.exception.CustomException;
import org.system.ticketsystem.model.CustomResponseDto;
import org.system.ticketsystem.model.PaymentConfirmRequest;
import org.system.ticketsystem.model.PaymentResponse;
import org.system.ticketsystem.service.TicketService;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/ticket")
@Slf4j
public class TicketController {


    @Autowired
    public TicketService ticketService;

    @Value("${confirm.form.url}")
    private String redirectUri;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("tktForm", new FormDto());
        return "email-form";
    }
    @GetMapping("/success")
    public String successPage(@RequestParam("id") String senderRequestNumber, Model model) {
        log.info("Date: {}, Thread: {}, TICKET CONTROLLER | getting success screen for senderRequestNumber [{}]", new Date(), Thread.currentThread().getName(),senderRequestNumber);
        BillDataDto billDataDto = ticketService.billDate(senderRequestNumber);
        model.addAttribute("client", billDataDto.getClient());
        model.addAttribute("paymentRequestNumber", billDataDto.getPaymentRequestNumber());
        model.addAttribute("trxDate", billDataDto.getTrxDate());
        model.addAttribute("billAmount", billDataDto.getBillAmount());
        return "success-page";
    }

    @PostMapping
    public String  submitForm(@Valid @ModelAttribute("tktForm") FormDto emailForm, BindingResult bindingResult, Model model) {
        log.info("Date: {}, Thread: {}, TICKET CONTROLLER | Submit email to create payment ", new Date(), Thread.currentThread().getName());
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Validation failed");
            throw new CustomException(errorMessage);
        }

        PaymentResponse paymentResponseRedirection = ticketService.sendPaymentAndRedirect(emailForm.getEmail());
        paymentResponseRedirection.setRedirectURI(redirectUri);

        model.addAttribute("paymentResponse", paymentResponseRedirection);
        if(paymentResponseRedirection == null) {
            throw new CustomException("Something went wrong");
        }
        return "ticket";
    }

    @PostMapping("/payment/confirmation")
    @ResponseBody
    public ResponseEntity<?> confirmPayment(@RequestBody PaymentConfirmRequest paymentConfirm) {
        log.info("Date: {}, Thread: {}, TICKET CONTROLLER | Submit email to create payment ", new Date(), Thread.currentThread().getName());
        log.info("Confirm payment request: " + paymentConfirm);
        String confirmTktPayment = ticketService.confirmTktPayment(paymentConfirm);

        HttpHeaders header = new HttpHeaders();
        header.add("responseCode","000");
        header.add("responseMessage","success");
        CustomResponseDto<String> customResponseDto = new CustomResponseDto<>();

        customResponseDto.setCode("000");
        customResponseDto.setMessage("success");
        customResponseDto.setData(confirmTktPayment);

        if(confirmTktPayment == null) {
            return new ResponseEntity<>("Payment Not Exist", header,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(confirmTktPayment, header,HttpStatus.OK);
    }



//    @GetMapping
//    public String ticket(Model model) {
//        Ticket tickets = ticketRepo.findById(809166L).get();
//        model.addAttribute("paymentRequest", new PaymentRequest());
//        return "ticket";
//    }

//    @PostMapping
//    public RedirectView createPaymentRequest(Model model, @ModelAttribute PaymentRequest paymentRequest) {
//        PaymentResponse paymentResponse = ticketService.paymentRequest(paymentRequest);
//        model.addAttribute("paymentResponse", paymentResponse);
//        String url = paymentResponse.getRedirectionURL() != null ? paymentResponse.getRedirectionURL(): "http://10.0.10.77:8080/SPS-web";
//
//        return new RedirectView(url);
//    }
//
//
//    @GetMapping("redirect")
//    public RedirectView testRedirect() {
//        return new RedirectView("https://chatgpt.com/c/67481a04-8764-8004-b226-527f35365f5b");
//    }
}
