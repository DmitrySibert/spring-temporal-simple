package com.dsib.springtemporalsimple.currency.web;

import com.dsib.springtemporalsimple.currency.application.usecase.FindBestBankBranches;
import com.dsib.springtemporalsimple.currency.application.usecase.HandleCurrencyInfo;
import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

  private final FindBestBankBranches findBestBankBranches;
  private final HandleCurrencyInfo handleCurrencyInfo;

  public CurrencyController(FindBestBankBranches findBestBankBranches, HandleCurrencyInfo handleCurrencyInfo) {
    this.findBestBankBranches = findBestBankBranches;
    this.handleCurrencyInfo = handleCurrencyInfo;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<String> getAddresses(@RequestBody List<String> currencies) {
    return findBestBankBranches.find(currencies);
  }

  @PostMapping("/info")
  public void startCurrencyInfo() {
    handleCurrencyInfo.startCurrencyInfo();
  }

  @PutMapping("/info")
  public void updateCurrencyInfo() {
    handleCurrencyInfo.signalUpdateCurrency();
  }

  @GetMapping("/info")
  public CurrencyInfo getCurrencyInfo() {
    return handleCurrencyInfo.queryCurrencyInfo();
  }
}
