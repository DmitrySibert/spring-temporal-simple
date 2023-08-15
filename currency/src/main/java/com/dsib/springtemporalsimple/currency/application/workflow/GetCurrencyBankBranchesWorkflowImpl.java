package com.dsib.springtemporalsimple.currency.application;

import com.dsib.springtemporalsimple.workflow.GetBankNearestBranchesActivities;
import com.dsib.springtemporalsimple.workflow.GetCurrencyBankBranchesWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.List;

public class GetCurrencyBankBranchesWorkflowImpl implements GetCurrencyBankBranchesWorkflow {

  private final GetBankNearestBranchesActivities getBankNearestBranchesActivities;
  private final GetCurrencyBankBranchesWorkflow getCurrencyBankBranchesWorkflow;

  public GetCurrencyBankBranchesWorkflowImpl() {
    this.getCurrencyBankBranchesWorkflow = Workflow.newActivityStub(
      GetCurrencyBankBranchesWorkflow.class,
      ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofMinutes(10))
        .build()
    );

    this.getBankNearestBranchesActivities = Workflow.newActivityStub(
      GetBankNearestBranchesActivities.class,
      ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofMinutes(10))
        .build()
    );
  }

  @Override
  public List<String> getBestCurrenciesPriceBanksBranches(List<String> currencies) {

    List<String> bankNames = getCurrencyBankBranchesWorkflow.getBestCurrenciesPriceBanksBranches(currencies);
    List<String> bankAddresses = getBankNearestBranchesActivities.getBankNearestBranches(bankNames);

    return bankAddresses;
  }
}
