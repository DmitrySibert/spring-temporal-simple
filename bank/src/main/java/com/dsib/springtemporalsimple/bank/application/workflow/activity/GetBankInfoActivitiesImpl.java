package com.dsib.springtemporalsimple.bank.application.workflow.activity;

import com.dsib.springtemporalsimple.workflow.activity.GetBankInfoActivities;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public class GetBankInfoActivitiesImpl implements GetBankInfoActivities {
  private int count = 0;
  private final UUID guid = UUID.randomUUID();
  @Override
  public List<String> getBankInfo() {
    log.debug("Attempt +" + count);
    if (count == 2) {
      count = 0;
      return List.of("Address1", "Address2", "Address3", "Address4");
    } else {
      ++count;
      throw new RuntimeException("Controlled exception in " + guid + ":" + count);
    }

  }
}
