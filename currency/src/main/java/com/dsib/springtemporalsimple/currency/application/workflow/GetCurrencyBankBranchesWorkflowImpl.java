package com.dsib.springtemporalsimple.currency.application.workflow;

import com.dsib.springtemporalsimple.workflow.activity.GetBankNearestBranchesActivities;
import com.dsib.springtemporalsimple.workflow.GetCurrencyBankBranchesWorkflow;
import com.dsib.springtemporalsimple.workflow.activity.GetCurrencyBestBankActivities;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.List;

public class GetCurrencyBankBranchesWorkflowImpl implements GetCurrencyBankBranchesWorkflow {

  private final GetBankNearestBranchesActivities getBankNearestBranchesActivities;
  private final GetCurrencyBestBankActivities getCurrencyBestBankActivities;

  public GetCurrencyBankBranchesWorkflowImpl() {
    this.getCurrencyBestBankActivities = Workflow.newActivityStub(
      GetCurrencyBestBankActivities.class,
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

    List<String> bankNames = getCurrencyBestBankActivities.getCurrencyBestBank(currencies);
    List<String> bankAddresses = getBankNearestBranchesActivities.getBanksNearestBranches(bankNames);

    return bankAddresses;
  }
}
