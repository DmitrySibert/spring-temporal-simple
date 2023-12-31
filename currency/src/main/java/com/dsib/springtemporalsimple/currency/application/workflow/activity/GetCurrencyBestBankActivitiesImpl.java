package com.dsib.springtemporalsimple.currency.application.workflow.activity;

import com.dsib.springtemporalsimple.workflow.activity.GetCurrencyBestBankActivities;

import java.util.List;

public class GetCurrencyBestBankActivitiesImpl implements GetCurrencyBestBankActivities {
  @Override
  public List<String> getCurrencyBestBank(List<String> currencies) {
    return List.of("Deutsche Bank", "Chase Bank");
  }
}
