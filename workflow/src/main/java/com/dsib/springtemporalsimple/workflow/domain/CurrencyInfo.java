package com.dsib.springtemporalsimple.workflow.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInfo {
  private LocalDateTime timestamp;
  private Map<String, Double> currenciesPrice;
}
