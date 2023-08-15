package com.dsib.springtemporalsimple.currency.application.workflow.activity;

import com.dsib.springtemporalsimple.workflow.activity.GetCurrencyInfoActivities;
import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;

import java.time.LocalDateTime;
import java.util.Map;

public class GetCurrencyInfoActivitiesImpl implements GetCurrencyInfoActivities {
  @Override
  public CurrencyInfo getCurrenciesInfo() {
    return CurrencyInfo.builder()
      .timestamp(LocalDateTime.now())
      .currenciesPrice(Map.of("USD", 40. + Math.random()))
      .build();
  }
}
