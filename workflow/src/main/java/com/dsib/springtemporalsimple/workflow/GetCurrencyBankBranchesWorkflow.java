package com.dsib.springtemporalsimple.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.util.List;

/**
 * A single action workflow
 *
 * Workflow is registered and started within the currency service.
 *
 * Workflow's task queue is DEFAULT_CURRENCY_QUEUE;
 *
 * Contains two activities in two different services: GetCurrencyBestBankActivities and GetBankNearestBranchesActivities
 */
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
