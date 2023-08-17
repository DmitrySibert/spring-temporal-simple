package com.dsib.springtemporalsimple.currency.application.workflow;

import com.dsib.springtemporalsimple.workflow.CurrencyInfoWorkflow;
import com.dsib.springtemporalsimple.workflow.activity.GetCurrencyBestBankActivities;
import com.dsib.springtemporalsimple.workflow.activity.GetCurrencyInfoActivities;
import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

import static com.dsib.springtemporalsimple.workflow.WorkflowSharedConstants.DEFAULT_CURRENCY_QUEUE;

public class CurrencyInfoWorkflowImpl implements CurrencyInfoWorkflow {

  private final GetCurrencyInfoActivities getCurrencyInfoActivities;

  private CurrencyInfo currencyInfo;

  public CurrencyInfoWorkflowImpl() {
    this.getCurrencyInfoActivities = Workflow.newActivityStub(
      GetCurrencyInfoActivities.class,
      ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofMinutes(10))
        .setTaskQueue(DEFAULT_CURRENCY_QUEUE)
        .build()
    );
    currencyInfo = null;
  }

  @Override
  public void provideCurrencyInfo(Duration updateRate) {
    while (true) {
      currencyInfo = getCurrencyInfoActivities.getCurrenciesInfo();
      Workflow.sleep(updateRate);
    }
  }

  @Override
  public void updateNow() {
    currencyInfo = getCurrencyInfoActivities.getCurrenciesInfo();
  }

  @Override
  public CurrencyInfo getCurrency() {
    return currencyInfo;
  }
}
