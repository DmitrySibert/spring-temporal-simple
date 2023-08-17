# spring-temporal-simple
Spring project with 2 micro-services integrated with temporal workflow and shared workflow and activities definition library

#install docker compose
https://docs.docker.com/compose/install/

# run Temporal locally
https://docs.temporal.io/kb/all-the-ways-to-run-a-cluster#docker--docker-compose

# application
temporal UI (by default) - 8080
bank - 8083
currency - 8082

# Temporal use-cases
CurrencyInfoWorkflow - an endless workflow. Work endless after has been started. Update info one in period(1min) and can be queried.
GetBankInfoWorkflow - a workflow. Workflow and activity are registered in one service, but started from another one.
GetCurrencyBankBranchesWorkflow - a workflow. Has two activities across the both services.

# API
API provided as an Insomnia collection

# Notes

Tasks queues. Each workflow and activity implementations should be registered in a worker. 
A worker can be attached to the certain TASK QUEUE. You have to run a workflow, declare an activity within a workflow using the TASK QUEUE which is attached to the worker where 
workflow started\activity impl is registered otherwise a task can be balanced to the TASK QUEUE's worker which doesn't have worker\activity implementation.
