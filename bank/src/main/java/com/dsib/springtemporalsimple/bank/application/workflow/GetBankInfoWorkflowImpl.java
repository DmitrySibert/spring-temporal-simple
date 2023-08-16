package com.dsib.springtemporalsimple.bank.application.workflow;

import com.dsib.springtemporalsimple.workflow.GetBankInfoWorkflow;
import com.dsib.springtemporalsimple.workflow.activity.GetBankInfoActivities;
import com.dsib.springtemporalsimple.workflow.activity.GetCurrencyInfoActivities;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.List;

public class GetBankInfoWorkflowImpl implements GetBankInfoWorkflow {

  private GetBankInfoActivities getBankInfoActivities;
  private List<String> addresses;

  public GetBankInfoWorkflowImpl() {
    this.getBankInfoActivities = Workflow.newActivityStub(
      GetBankInfoActivities.class,
      ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofMinutes(10))
        .build()
    );
    addresses = List.of();
  }

  @Override
  public void provideBankInfo(Duration updateRate) {
    while (true) {
      addresses = getBankInfoActivities.getBankInfo();
      Workflow.sleep(updateRate);
    }
  }
}
