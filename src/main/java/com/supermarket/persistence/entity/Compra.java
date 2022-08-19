package com.supermarket.persistence.entity;

import java.time.LocalTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "compras")
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  @Getter
  @Setter
  private Integer idCompra;

  @Column(name = "id_cliente")
  @Getter
  @Setter
  private String idCliente;

  @Getter
  @Setter
  private LocalTime fecha;

  @Column(name = "medio_pago")
  @Getter
  @Setter
  private String medioPago;

  @Getter
  @Setter
  private String comentario;

  @Getter
  @Setter
  private String estado;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "id_cliente", insertable = false, updatable = false )
  private Cliente cliente;

  @Getter
  @Setter
  @OneToMany(mappedBy = "producto")
  private List<ComprasProducto> comprasProductoList;
  @Override
  public String toString() {
    return "Compra{" +
        "idCompra=" + idCompra +
        ", idCliente='" + idCliente + '\'' +
        ", fecha=" + fecha +
        ", medioPago='" + medioPago + '\'' +
        ", comentario='" + comentario + '\'' +
        ", estado='" + estado + '\'' +
        '}';
  }
}
