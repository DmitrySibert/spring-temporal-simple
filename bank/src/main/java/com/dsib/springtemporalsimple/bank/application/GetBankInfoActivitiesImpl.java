package com.dsib.springtemporalsimple.bank.application;

import com.dsib.springtemporalsimple.workflow.activity.GetBankInfoActivities;

import java.util.List;

public class GetBankInfoActivitiesImpl implements GetBankInfoActivities {
  @Override
  public List<String> getBankInfo() {
    return List.of("Address1", "Address2", "Address3", "Address4");
  }
}
