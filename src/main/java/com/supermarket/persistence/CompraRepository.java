package com.supermarket.persistence;

import com.supermarket.domain.Purchase;
import com.supermarket.domain.repository.PurchaseRepository;
import com.supermarket.persistence.crud.CompraCrudRepository;
import com.supermarket.persistence.entity.Compra;
import com.supermarket.persistence.mapper.PurchaseMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompraRepository implements PurchaseRepository {

  @Autowired
  private CompraCrudRepository compraCrudRepository;

  @Autowired
  private PurchaseMapper mapper;

  @Override
  public List<Purchase> getAll() {
    return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
  }

  @Override
  public Optional<List<Purchase>> getByClient(String clientId) {
    return compraCrudRepository.findByIdCliente(clientId)
        .map(compras -> mapper.toPurchases(compras));
  }

  @Override
  public Purchase save(Purchase purchase) {
    Compra compra = mapper.toCompra(purchase);
    compra.getProductos().forEach(producto -> producto.setCompra(compra));
    return mapper.toPurchase(compraCrudRepository.save(compra));
  }
}
