package com.supermarket.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class ComprasProductoPK implements Serializable {

  @Getter
  @Setter
  @Column(name = "id_compra")
  private Integer idCompra;

  @Getter
  @Setter
  @Column(name = "id_producto")
  private Integer idProducto;
}
