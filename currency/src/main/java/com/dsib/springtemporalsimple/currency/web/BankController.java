package com.dsib.springtemporalsimple.currency.web;

import com.dsib.springtemporalsimple.currency.application.usecase.GetBankInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bank")
public class BankController {

  private final GetBankInfo getBankInfo;

  public BankController(GetBankInfo getBankInfo) {
    this.getBankInfo = getBankInfo;
  }

  @PostMapping("/info")
  public void startCurrencyInfo() {
    getBankInfo.find();
  }
}
