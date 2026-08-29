package com.itechstore.platform.service;
import com.itechstore.platform.model.Category;
import com.itechstore.platform.repository.CategoryRepository;
import com.itechstore.platform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//CRUD methodology to realize request


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

    // 1. We get all the categories
    public List<Category>getAllCategories(){
        return categoryRepository.findAll();


    }

    //2. Save or create a new category
    public Category saveCategory(Category category){
        return categoryRepository.save(category);


    }

    //3. Delete or create a category by its ID
    public void deleteCategory(Long id){
         categoryRepository.deleteById(id);


    }
    //4. Update a Category: updateCategory()

    public Category updateCategory(Long id, Category categoryData){

        Category category= categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found "+id));

        category.setNameCategory(categoryData.getNameCategory());
        category.setDescription(categoryData.getDescription());

        return categoryRepository.save(category);

    }
    



    
}
