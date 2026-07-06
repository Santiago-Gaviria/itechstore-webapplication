package com.itechstore.platform.repository;
import com.itechstore.platform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
//Le decimos a JPA que este repositorio maneja la entidad "Product" y que su ID es de tipo 'Long'

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product>findByStock(Integer stock);
    // Al heredar de JpaRepository, esta interfaz ya tiene poderes mágicos:
    // .save() -> Guarda en la BD
    // .findAll() -> Trae todos los productos de la BD
    // .findById() -> Busca un producto por su ID
    // .deleteById() -> Borra un producto
    
}
