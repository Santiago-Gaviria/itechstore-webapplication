package com.itechstore.platform.model;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name="categories")


public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(nullable=false,unique=true)
    private String nameCategory;
    private String description;
    //Relacion: Una SOLA categoria tiene muchos productos(One-To-Many)
    //Luego usamos Set para evitar que se dupliquen oductos en la lista

    //Conectamos la clase Category.java con la clase product.java 
    //Con este codigo, se va a la clase Product.javay busca una variable con el nomre "category"
    @OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Product>products= new HashSet<>();
    






    
}
