package com.dsib.springtemporalsimple.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.time.Duration;

@WorkflowInterface
public interface GetBankInfoWorkflow {

  @WorkflowMethod
  void provideBankInfo(Duration updateRate);
}
