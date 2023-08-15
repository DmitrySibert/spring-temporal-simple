package com.dsib.springtemporalsimple.currency.application.usecase;

import com.dsib.springtemporalsimple.workflow.CurrencyInfoWorkflow;
import com.dsib.springtemporalsimple.workflow.domain.CurrencyInfo;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

import static com.dsib.springtemporalsimple.workflow.WorkflowSharedConstants.DEFAULT_QUEUE;

@Service
public class HandleCurrencyInfo {

  private final WorkflowClient workflowClient;
  private final static String WORKFLOW_ID = "curInfo";

  public HandleCurrencyInfo(WorkflowClient workflowClient) {
    this.workflowClient = workflowClient;
  }

  public void startCurrencyInfo() {
    WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
      .setTaskQueue(DEFAULT_QUEUE)
      .setWorkflowId(WORKFLOW_ID)
      .build();

    CurrencyInfoWorkflow workflow =
      workflowClient.newWorkflowStub(CurrencyInfoWorkflow.class, workflowOptions);

    WorkflowClient.start(workflow::provideCurrencyInfo, Duration.ofMinutes(1));
  }

  public CurrencyInfo queryCurrencyInfo() {
    CurrencyInfoWorkflow workflow = workflowClient.newWorkflowStub(CurrencyInfoWorkflow.class, WORKFLOW_ID);

    return workflow.getCurrency();
  }

  public void signalUpdateCurrency() {
    CurrencyInfoWorkflow workflow = workflowClient.newWorkflowStub(CurrencyInfoWorkflow.class, WORKFLOW_ID);

    workflow.updateNow();
  }
}
