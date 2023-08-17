package com.dsib.springtemporalsimple.currency.application.usecase;

import com.dsib.springtemporalsimple.workflow.GetBankInfoWorkflow;
import com.dsib.springtemporalsimple.workflow.GetCurrencyBankBranchesWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.common.RetryOptions;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

import static com.dsib.springtemporalsimple.workflow.WorkflowSharedConstants.DEFAULT_QUEUE;

@Service
public class GetBankInfo {
  private final WorkflowClient workflowClient;

  public GetBankInfo(WorkflowClient workflowClient) {
    this.workflowClient = workflowClient;
  }

  public void find() {
    WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
      .setTaskQueue(DEFAULT_QUEUE)
      .setWorkflowId(UUID.randomUUID().toString())
      .build();

    GetBankInfoWorkflow workflow = workflowClient.newWorkflowStub(GetBankInfoWorkflow.class, workflowOptions);

    WorkflowClient.start(workflow::provideBankInfo, Duration.ofSeconds(20));
  }
}
