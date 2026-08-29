package com.itechstore.platform.service;

import com.itechstore.platform.model.Product;
import com.itechstore.platform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale.Category;

@Service
public class ProductService {
 
    @Autowired
    private ProductRepository productRepository;

    
    
    // Metodo para obtener todos los productos
    public List<Product> getAll() {
        return productRepository.findAll();

    }

    // metodo para guardar un producto nuevo
    public Product saveProduct(Product product) {
        return productRepository.save(product);

    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, Product productData) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en el id: " + id));

        existingProduct.setProductName(productData.getProductName());
        existingProduct.setPrice(productData.getPrice());
        existingProduct.setStock(productData.getStock());

        productRepository.save(existingProduct);
        

    }
    public List<Product> getProductsByStock(Integer stock){
        return productRepository.findByStock(stock);
        
    }

}
