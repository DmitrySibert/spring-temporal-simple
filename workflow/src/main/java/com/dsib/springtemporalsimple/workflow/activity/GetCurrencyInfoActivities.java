package com.dsib.springtemporalsimple.workflow.activity;

import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

/**
 * Activity is registered in currency service.
 *
 * Activity uses DEFAULT_CURRENCY_QUEUE tasks queue;
 */
@ActivityInterface
public interface GetCurrencyInfoActivities {
  @ActivityMethod
  CurrencyInfo getCurrenciesInfo();
}
