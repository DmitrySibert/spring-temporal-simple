package com.dsib.springtemporalsimple.bank.application;

import com.dsib.springtemporalsimple.workflow.activity.GetBankNearestBranchesActivities;

import java.util.List;

public class GetBankNearestBranchesActivitiesImpl implements GetBankNearestBranchesActivities {
  @Override
  public List<String> getBankNearestBranches(String bankName) {
    return List.of();
  }

  @Override
  public List<String> getBanksNearestBranches(List<String> bankNames) {
    return List.of("Berlin", "Washington");
  }
}
