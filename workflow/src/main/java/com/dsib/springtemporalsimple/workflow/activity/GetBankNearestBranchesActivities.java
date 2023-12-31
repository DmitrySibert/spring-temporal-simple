package com.dsib.springtemporalsimple.workflow.activity;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.List;

/**
 * Activity is registered in bank service.
 *
 * Activity uses DEFAULT_BANK_QUEUE tasks queue;
 */
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
  List<String> getBanksNearestBranches(List<String> bankNames);
}
