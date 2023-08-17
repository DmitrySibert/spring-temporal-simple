package com.dsib.springtemporalsimple.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.time.Duration;
import java.util.List;

@WorkflowInterface
public interface GetBankInfoWorkflow {

  @WorkflowMethod
  List<String> provideBankInfo();
}
