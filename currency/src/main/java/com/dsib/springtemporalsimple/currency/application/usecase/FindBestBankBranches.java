package com.dsib.springtemporalsimple.currency.application.usecase;

import com.dsib.springtemporalsimple.workflow.GetCurrencyBankBranchesWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.dsib.springtemporalsimple.workflow.WorkflowSharedConstants.DEFAULT_QUEUE;

@Service
public class FindBestBankBranches {

  private final WorkflowClient workflowClient;

  public FindBestBankBranches(WorkflowClient workflowClient) {
    this.workflowClient = workflowClient;
  }

  public List<String> find(List<String> currencies) {
    WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
      .setTaskQueue(DEFAULT_QUEUE)
      .setWorkflowId(UUID.randomUUID().toString())
      .build();

    GetCurrencyBankBranchesWorkflow workflow =
      workflowClient.newWorkflowStub(GetCurrencyBankBranchesWorkflow.class, workflowOptions);

    return workflow.getBestCurrenciesPriceBanksBranches(currencies);
  }
}
