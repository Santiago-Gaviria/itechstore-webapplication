package com.itechstore.platform.controller;
import com.itechstore.platform.model.Category;
import com.itechstore.platform.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;



    @GetMapping
    // 1. GET: Listar todas las categorías (ej: GET /api/categories)
    public List getCategories(){
        return categoryService.getAllCategories();

    }
    @PostMapping
    // 2. POST: Crear una nueva categoría (ej: POST /api/categories)
    public Category createNewCategory(@Valid@RequestBody Category category){
        return categoryService.saveCategory(category);


    }
   
    @DeleteMapping("/{id}")
    // 3. DELETE: Eliminar una categoría por ID (ej: DELETE /api/categories/5)
    public String  deleteCategory(Long id){
         categoryService.deleteCategory(id);
         return "La categoria con el id: "+id+" Ha sido elimininada correctamente";

    }
    @PutMapping
    //4. PUT: Actualizar una categoría existente (ej: PUT /api/categories/5)
    public String updateCategory(@PathVariable Long id,@Valid @RequestBody Category category){
        categoryService.updateCategory(id, category);

        return "The category with the id: "+id+" has been updated correctly";


    }
   

    
}
