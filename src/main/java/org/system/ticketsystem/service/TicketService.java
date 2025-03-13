package org.system.ticketsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.system.ticketsystem.client.PaymentIntegration;
import org.system.ticketsystem.dto.BillDataDto;
import org.system.ticketsystem.entity.Ticket;
import org.system.ticketsystem.exception.CustomException;
import org.system.ticketsystem.model.PaymentConfirmRequest;
import org.system.ticketsystem.model.PaymentRequest;
import org.system.ticketsystem.model.PaymentResponse;
import org.system.ticketsystem.repo.TicketRepo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TicketService {

    @Autowired
    private PaymentIntegration paymentIntegration;
    @Autowired
    private TicketRepo ticketRepo;
    @Value("${tkt.confirmation.url}")
    private String confirmationUrl;
    @Value("${confirm.form.url.redirect}")
    private String redirectionUrl;
    @Value("${ignore.etcReqType}")
    private boolean ignoreEtcReqType;

    public PaymentResponse sendPaymentAndRedirect(String email) {

        log.info("UserEmail is {}", email);
        //get list of mail which repeated and his payment value is not null
        List<Ticket> userTkt = new ArrayList<>();
        if(!ignoreEtcReqType){
            log.info("get email with ignore specific request type");
            userTkt = ticketRepo.findByEmailForPaymentRequestIgnoreReqType(email, "ETS");

        }else{
            log.info("get email with all request type");
            userTkt = ticketRepo.findByEmailForPaymentRequest(email);
        }

        if(userTkt == null || userTkt.isEmpty()){
            log.error("Date: {}, Thread: {}, Email: {} does not exist", new Date(), Thread.currentThread().getName(), email);
            throw new CustomException("Email Not Exist");
        }
        PaymentRequest paymentRequest = buildPaymentRequest(userTkt.get(0));
        Ticket ticket = userTkt.get(0);
        ticket.setSenderRequestNumber(paymentRequest.getSenderRequestNumber());
        ticketRepo.save(ticket);
        return paymentIntegration.paymentRequestIntegration(paymentRequest);
    }

    public String confirmTktPayment(PaymentConfirmRequest confirmRequest) {

        log.info("received request is " +confirmRequest.toString() + " and payment is " + confirmRequest.getPaymentRequestNumber() + "and is confirmed" + confirmRequest.getIsConfirmed());
        Optional<Ticket> tktEntity = ticketRepo.findConfirmedTkt(confirmRequest.getSenderRequestNumber(),true);
//        Optional<Ticket> tktEntity = ticketRepo.findConfirmedTkt(confirmRequest.getSenderRequestNumber(),true);

        if(tktEntity.isPresent()){
            Ticket ticket = tktEntity.get();
            mapPaymentConfirmationToTicket(confirmRequest, ticket);
            ticketRepo.save(ticket);
            return "Payment Confirmed";
        }
        log.error("Date: {}, Thread: {}, payment_id : {} does not exist", new Date(), Thread.currentThread().getName(), confirmRequest.getPaymentRequestNumber());
        return null;
    }

    public BillDataDto billDate(String senderRequestNumber) {
        log.info("Date: {}, Thread: {}, ticketService | getting success screen for senderRequestNumber [{}]", new Date(), Thread.currentThread().getName(),senderRequestNumber);
        Optional<Ticket> tktEntity = ticketRepo.findConfirmedTkt(senderRequestNumber,true);
//        Optional<Ticket> tktEntity = ticketRepo.findConfirmedTkt(confirmRequest.getSenderRequestNumber(),true);
        if(tktEntity.isPresent()){
            Ticket ticket = tktEntity.get();
            BillDataDto billDataDto = new BillDataDto();
            billDataDto.setClient(ticket.getClientemail());
            billDataDto.setBillAmount(ticket.getPaymentRequestTotalAmount());
            billDataDto.setTrxDate(ticket.getAuthorizationDateTime());
            billDataDto.setPaymentRequestNumber(ticket.getPaymentRequestNumber());

            return billDataDto;
        }else{
            log.error("Date: {}, Thread: {}, ticket with sender Request Number: [{}] and is confirmed [true] not found", new Date(), Thread.currentThread().getName(), senderRequestNumber);
            throw new CustomException("This Ticket Not Found");
        }
    }

    private PaymentRequest buildPaymentRequest(Ticket ticket) {
        //todo kindly check this columns
        PaymentRequest request = new PaymentRequest();
        //todo ask about this
        request.setSenderId(ticket.getEfinancepaycode());
        String senderRequestNumber = ticket.getTicketid()+"-"+(int) (Math.random() * 100);
        System.out.println(senderRequestNumber);
        request.setSenderRequestNumber(senderRequestNumber);
        request.setServiceCode(ticket.getServicecode());
        request.setRequestDescription(ticket.getDescription());

        //todo  where getting this currency to be automated not static
        request.setCurrency("818");
        request.setAmount(ticket.getPaymentvalue());

        // confirmation url is combination o [publicUrl or private ip] + endPoint for payment confirmation
        // it will be configuration in properties file
        request.setConfirmationUrl(confirmationUrl+"?id="+senderRequestNumber);

        //todo what should getting expiryDate of payment
        request.setExpiryDate(ticket.getEnddate());
        return request;
    }

    private void mapPaymentConfirmationToTicket(PaymentConfirmRequest paymentConfirmRequest, Ticket ticket) {
        //todo map request dto to entity [update values]
        ticket.setPaymentRequestNumber(paymentConfirmRequest.getPaymentRequestNumber());
        ticket.setPaymentRequestTotalAmount(paymentConfirmRequest.getPaymentRequestTotalAmount());
        ticket.setAuthorizingInstitution(paymentConfirmRequest.getAuthorizingInstitution());
        ticket.setSenderRequestNumber(paymentConfirmRequest.getSenderRequestNumber());
        ticket.setCollectionFeesAmount(paymentConfirmRequest.getCollectionFeesAmount());
        ticket.setCustomerAuthorizationAmount(paymentConfirmRequest.getCustomerAuthorizationAmount());
        ticket.setAuthorizationCode(paymentConfirmRequest.getAuthorizationCode());
        ticket.setTransactionNumber(paymentConfirmRequest.getTransactionNumber());
        ticket.setAuthorizingMechanism(paymentConfirmRequest.getAuthorizingMechanism());
        ticket.setAuthorizationDateTime(convertStringToDate(paymentConfirmRequest.getAuthorizationDateTime()));
        ticket.setReconciliationDate(convertStringToDate(paymentConfirmRequest.getReconciliationDate()));
        ticket.setIsConfirmed(paymentConfirmRequest.getIsConfirmed());
        ticket.setChangedate(Instant.now());
    }

    private Date convertStringToDate(LocalDateTime date){

        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

}
