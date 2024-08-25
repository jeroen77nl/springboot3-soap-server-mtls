package com.javatechie.spring.soap.api.endpoint;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;
import com.javatechie.spring.soap.api.service.LoanEligibilityService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityindicatorEndpoint {

  private static final String NAMESPACE = "http://www.javatechie.com/spring/soap/api/loanEligibility";
  private final LoanEligibilityService loanEligibilityService;

  public LoanEligibilityindicatorEndpoint(LoanEligibilityService loanEligibilityService) {
    this.loanEligibilityService = loanEligibilityService;
  }

  @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
  @ResponsePayload
  public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
    return loanEligibilityService.checkLoanEligibility(request);
  }

}