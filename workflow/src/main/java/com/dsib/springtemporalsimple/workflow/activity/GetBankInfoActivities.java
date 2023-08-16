package com.dsib.springtemporalsimple.workflow.activity;

import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.List;

@ActivityInterface
public interface GetBankInfoActivities {
  @ActivityMethod
  List<String> getBankInfo();
}
