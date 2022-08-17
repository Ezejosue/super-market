package com.supermarket.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

  @EmbeddedId
  @Getter
  @Setter
  private ComprasProductoPK id;
  @Getter
  @Setter
  private Integer cantidad;
  @Getter
  @Setter
  private Double total;
  @Getter
  @Setter
  private Boolean estado;

  @ManyToOne
  @JoinColumn(name = "id_compra", insertable = false, updatable = false)
  private Compra compra;

  @ManyToOne
  @JoinColumn(name = "id_producto", insertable = false, updatable = false)
  private Producto producto;
}
