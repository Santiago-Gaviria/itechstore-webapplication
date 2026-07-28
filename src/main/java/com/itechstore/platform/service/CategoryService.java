package com.itechstore.platform.service;
import com.itechstore.platform.model.Category;
import com.itechstore.platform.repository.CategoryRepository;
import com.itechstore.platform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Metodologia CRUD

//CREATE
//READ
//UPDATE
//DELETE
@Service
public class CategoryService  {
    private final ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    CategoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //1. Primero obtenemos todas las categorias
    public List<Category>getAllCategories(){
        return categoryRepository.findAll();


    }
    //2.Guardar o crear una nueva categoria
    public Category saveCategory(Category category){
        return categoryRepository.save(category);


    }
    //3. ELiminar una categoria mediante su ID
    public void deleteCategory(Long id){
         categoryRepository.deleteById(id);


    }
    //4. Actualizar una categoria

    public Category updateCategory(Long id, Category categoryData){

        Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found "+id));

        category.setNameCategory(categoryData.getNameCategory());
        category.setDescription(categoryData.getDescription());

        return categoryRepository.save(category);

    }
    



    
}
