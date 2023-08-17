package com.dsib.springtemporalsimple.workflow.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.List;

/**
 * Activity is registered in currency service.
 *
 * Activity uses DEFAULT_CURRENCY_QUEUE tasks queue;
 */
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
