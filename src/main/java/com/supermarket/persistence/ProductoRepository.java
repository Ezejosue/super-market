package com.supermarket.persistence;

import com.supermarket.domain.Product;
import com.supermarket.domain.repository.ProductRepository;
import com.supermarket.persistence.crud.ProductoCrudRepository;
import com.supermarket.persistence.entity.Producto;
import com.supermarket.persistence.mapper.ProductMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository {

  @Autowired
  private ProductoCrudRepository productoCrudRepository;
  @Autowired
  private ProductMapper productMapper;

  @Override
  public List<Product> getAll() {
    List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
    return productMapper.toProducts(productos);
  }

  @Override
  public Optional<List<Product>> getByCategory(int categoryId) {
    List<Producto> productos = productoCrudRepository.findByCategoriaOrderByNombreAsc(categoryId);
    return Optional.of(productMapper.toProducts(productos));
  }

  @Override
  public Optional<List<Product>> getByScarseProducts(int quantity) {
    Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(
        quantity, true);

    return productos.map(prods -> productMapper.toProducts(prods));
  }

  @Override
  public Optional<Product> getProduct(int productId) {
    return productoCrudRepository.findById(productId).map(prod -> productMapper.toProduct(prod));

  }

  @Override
  public Product save(Product product) {
    Producto producto = productMapper.toProducto(product);
    return productMapper.toProduct(productoCrudRepository.save(producto));
  }


  @Override
  public void delete(int productId) {
    productoCrudRepository.deleteById(productId);
  }
}
