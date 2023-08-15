package com.dsib.springtemporalsimple.currency.web;

import com.dsib.springtemporalsimple.currency.application.usecase.FindBestBankBranches;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

  private final FindBestBankBranches findBestBankBranches;

  public CurrencyController(FindBestBankBranches findBestBankBranches) {
    this.findBestBankBranches = findBestBankBranches;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<String> getAddresses(@RequestBody List<String> currencies) {
    return findBestBankBranches.find(currencies);
  }
}
