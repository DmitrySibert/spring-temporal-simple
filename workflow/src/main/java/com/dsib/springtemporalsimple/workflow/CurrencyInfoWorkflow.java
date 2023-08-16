package com.dsib.springtemporalsimple.workflow;

import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.time.Duration;

@WorkflowInterface
public interface CurrencyInfoWorkflow {

  /**
   * Run endless currency info providing workflow
   */
  @WorkflowMethod
  void provideCurrencyInfo(Duration updateRate);

  /**
   * Out of order update
   */
  @SignalMethod
  void updateNow();

  /**
   * Get current currency info
   */
  @QueryMethod
  CurrencyInfo getCurrency();
}
