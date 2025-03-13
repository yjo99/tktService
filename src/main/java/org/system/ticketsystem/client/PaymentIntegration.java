package org.system.ticketsystem.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.system.ticketsystem.model.PaymentRequest;
import org.system.ticketsystem.model.PaymentResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentIntegration {

    @Autowired
    public RestTemplate restTemplate;

    @Value("${middleware.url}")
    private String middleWareUrl;

    @Value("${confirm.form.url}")
    private String confirmFormUrl;

    @Value("${middleware.userName}")
    private String userName;

    @Value("${middleware.password}")
    private String password;

    public PaymentResponse paymentRequestIntegration(PaymentRequest paymentRequest) {

        String plainCreds = userName+":"+password;
        // Step 2: Base64 encode the credentials
        String base64Creds = java.util.Base64.getEncoder().encodeToString(plainCreds.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);

        log.info("starting integrate payment with middleWare with request: {}", paymentRequest);

        headers.add("content-type", "application/json");

        HttpEntity<PaymentRequest> httpEntity = new HttpEntity<>(paymentRequest,headers);

        ResponseEntity<PaymentResponse> responseEntity = restTemplate.exchange(
                middleWareUrl,
                HttpMethod.POST,
                httpEntity,PaymentResponse.class);

        log.info("responseEntity: {}", responseEntity);
        log.info("responseEntity.getBody(): {}", responseEntity.getBody());

        return responseEntity.getBody();

    }

    public String paymentRequestIntegrationForm(PaymentResponse paymentResponse) {

        log.info("starting integrate payment with middleWare with request: {}", paymentResponse);

        HttpHeaders headers = new HttpHeaders();

        Map<String, String> formData = new HashMap<>();
        formData.put("RandomSecret", paymentResponse.getRandomSecret());
        formData.put("HashedRequestObject", paymentResponse.getHashedRequestObject());
        formData.put("SenderID", paymentResponse.getSenderID());
        formData.put("LanguageId", paymentResponse.getLanguageId());
        formData.put("RequestObject", paymentResponse.getRequestObject());

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(formData, headers);


        ResponseEntity<String> responseEntity = restTemplate.exchange(
                confirmFormUrl,
                HttpMethod.POST,
                requestEntity,String.class);

        log.info("responseEntity: {}", responseEntity);
        log.info("responseEntity.getBody(): {}", responseEntity.getHeaders().getLocation());

        return Objects.requireNonNull(responseEntity.getHeaders().getLocation()).toString();

    }

}
