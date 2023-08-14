package com.dsib.springtemporalsimple.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.util.List;

@WorkflowInterface
public interface GetCurrencyBankBranchesWorkflow {

  /**
   * Get a list of banks branches addresses for desired currencies
   *
   * @param currencies desired international currency identifiers list
   * @return list of addresses
   */
  @WorkflowMethod
  List<String> getBestCurrenciesPriceBanksBranches(List<String> currencies);
}
