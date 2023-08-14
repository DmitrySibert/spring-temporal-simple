package com.dsib.springtemporalsimple.workflow;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.List;

@ActivityInterface
public interface GetBankNearestBranchesActivities {

  /**
   * Get list of bank nearest branches
   *
   * @param bankName
   *
   * @return list of addresses
   */
  @ActivityMethod
  List<String> getBankNearestBranches(String bankName);

  /**
   * Get list of banks nearest branches
   *
   * @param bankNames
   *
   * @return list of addresses
   */
  @ActivityMethod
  List<String> getBankNearestBranches(List<String> bankNames);
}
