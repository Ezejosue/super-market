package com.supermarket.domain;

import lombok.Getter;
import lombok.Setter;

public class PurchaseItem {

  @Getter
  @Setter
  private int productId;
  @Getter
  @Setter
  private int quantity;
  @Getter
  @Setter
  private double total;
  @Getter
  @Setter
  private boolean active;
}
