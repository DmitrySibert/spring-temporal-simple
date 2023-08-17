package com.dsib.springtemporalsimple.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.time.Duration;
import java.util.List;

/**
 * Bank info workflow.
 *
 * Workflow is registered within the bank service, but
 * started within the currency service
 *
 * Workflow task queue is DEFAULT_BANK_QUEUE;
 *
 * Contains the single activity in bank service: GetBankInfoActivities
 */
@WorkflowInterface
public interface GetBankInfoWorkflow {

  @WorkflowMethod
  List<String> provideBankInfo();
}
