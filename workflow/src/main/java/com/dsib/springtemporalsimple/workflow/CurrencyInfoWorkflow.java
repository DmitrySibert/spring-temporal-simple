package com.dsib.springtemporalsimple.workflow;

import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.time.Duration;

/**
 * An endless workflow.
 *
 * Workflow is registered and started within the currency service.
 *
 * Workflow task queue is DEFAULT_CURRENCY_QUEUE;
 *
 * Contains the single activity in currency service: GetCurrencyInfoActivities
 */
@WorkflowInterface
public interface CurrencyInfoWorkflow {

  /**
   * Run endless currency info providing workflow
   */
  @WorkflowMethod
  void provideCurrencyInfo(Duration updateRate);

  /**
   * Out of order currency info update
   */
  @SignalMethod
  void updateNow();

  /**
   * Get current currency info
   */
  @QueryMethod
  CurrencyInfo getCurrency();
}
