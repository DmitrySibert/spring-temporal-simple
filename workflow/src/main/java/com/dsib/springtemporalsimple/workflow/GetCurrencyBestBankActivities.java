package com.dsib.springtemporalsimple.workflow;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.List;

@ActivityInterface
public interface GetCurrencyBestBankActivities {

  /**
   * Get list of banks with the best currency prices
   *
   * @param currencies
   * @return
   */
  @ActivityMethod
  List<String> getCurrencyBestBank(List<String> currencies);
}
