package com.dsib.springtemporalsimple.workflow.activity;

import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.List;

/**
 * Activity is registered in bank service.
 *
 * Activity uses DEFAULT_BANK_QUEUE tasks queue;
 */
@ActivityInterface
public interface GetBankInfoActivities {
  @ActivityMethod
  List<String> getBankInfo();
}
