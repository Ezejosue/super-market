package com.supermarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
public class Producto {

  @Id
  @Column(name = "id_producto")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private Integer idProducto;

  @Getter
  @Setter
  private String nombre;

  @Column(name = "id_categoria")
  @Getter
  @Setter
  private Integer idCategoria;

  @Column(name = "codigo_barras")
  @Getter
  @Setter
  private String codigoBarras;

  @Column(name = "precio_venta")
  @Getter
  @Setter
  private Double precioVenta;

  @Column(name = "cantidad_stock")
  @Getter
  @Setter
  private Integer cantidadStock;

  @Getter
  @Setter
  private Boolean estado;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
  private Categoria categoria;

  @Override
  public String toString() {
    return "Producto{" +
        "idProducto=" + idProducto +
        ", nombre='" + nombre + '\'' +
        ", idCategoria=" + idCategoria +
        ", codigoBarras='" + codigoBarras + '\'' +
        ", precioVenta=" + precioVenta +
        ", cantidadStock=" + cantidadStock +
        ", estado=" + estado +
        '}';
  }
}
