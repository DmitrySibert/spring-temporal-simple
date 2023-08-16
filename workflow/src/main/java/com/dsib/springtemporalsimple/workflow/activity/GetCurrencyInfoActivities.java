package com.dsib.springtemporalsimple.workflow.activity;

import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface GetCurrencyInfoActivities {

  @ActivityMethod
  CurrencyInfo getCurrenciesInfo();
}
