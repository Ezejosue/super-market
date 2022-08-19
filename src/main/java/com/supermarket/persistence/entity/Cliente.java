package com.supermarket.persistence.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @Getter
  @Setter
  private String id;
  @Getter
  @Setter
  private String nombre;
  @Getter
  @Setter
  private String apellidos;
  @Getter
  @Setter
  private Long celular;
  @Getter
  @Setter
  private String direccion;

  @Column(name = "correo_electronico")
  @Getter
  @Setter
  private String correoElectronico;

  @Getter
  @Setter
  @OneToMany(mappedBy = "cliente")
  private List<Compra> compraList;
}
