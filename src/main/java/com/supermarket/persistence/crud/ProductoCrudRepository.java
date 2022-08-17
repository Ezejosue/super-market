package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

  List<Producto> findByCategoriaOrderByNombreAsc(int idCategoria);

  Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

  public Optional<Producto> getProducto(int idProducto);
}
