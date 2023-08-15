package com.dsib.springtemporalsimple.currency.web;

import com.dsib.springtemporalsimple.currency.application.usecase.FindBestBankBranches;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("/currency")
public class CurrencyController {

  private final FindBestBankBranches findBestBankBranches;

  public CurrencyController(FindBestBankBranches findBestBankBranches) {
    this.findBestBankBranches = findBestBankBranches;
  }

  @GetMapping
  public List<String> getAddresses(@RequestBody List<String> currencies) {
    return findBestBankBranches.find(currencies);
  }
}
