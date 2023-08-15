package com.dsib.springtemporalsimple.bank.infrastructure;

import com.dsib.springtemporalsimple.bank.application.GetBankNearestBranchesActivitiesImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TemporalWorkerFactory {

  public static final String TASK_QUEUE = "currency_task_queue";

  @Bean
  public WorkflowClient initTemporalInfrastructure() {
    log.debug("Initialize Temporal infrastructure");
    //setup with an assumption that Temporal is on 127.0.0.1:7233
    WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
    WorkflowClient client = WorkflowClient.newInstance(service);
    WorkerFactory factory = WorkerFactory.newInstance(client);
    Worker worker = factory.newWorker(TASK_QUEUE);
    registerEntities(worker);

    factory.start();

    return client;
  }

  private void registerEntities(Worker worker) {
    worker.registerActivitiesImplementations(new GetBankNearestBranchesActivitiesImpl());
  }
}
