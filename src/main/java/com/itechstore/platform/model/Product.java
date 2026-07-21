package com.itechstore.platform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Entity

// @Entity le dice a JPA que esta clase se convertira en una tabla en
// postgreeSQL
@Table(name = "Products")
// @Table Define el nombre fisico de la tabla en la base de datos

// Despues con ayuda de lombok evitamos lineas de codigo repetitivas como getters,setters
// y toString();
@Data
// @Data Genera automaticamente, getters,setters, toString y hashCode para que
// Hibernate los detecte
@NoArgsConstructor // Esto genera el constructor vacio que es necesario apra que hbernate lo
                      // detecte y funcione
@AllArgsConstructor//Genera el constructor con todos los atributos de la clase

public class Product {
    
@Id//Define este atributo como la llave primaria(Primera key)
@GeneratedValue(strategy=GenerationType.IDENTITY)//Hace que el iD sea incremental(1,2,3,4...)
private Long id;


@NotBlank(message="El nombre del producto debe ser es obligatorio")//Validacion de la industrioa que asegura no tener espacios vacios
@Column(nullable=false,length=100)//Configuracion de la base de datos:Not Bull y maximo 100 caracteres
private String productName;

@NotNull(message="El precio es obligatorio")
@Min(value=0,message="El precio no puede ser negativo")//validacion, evita datos corruptos
@Column(nullable=false)
private Double price;

@NotNull(message = "El Stock es obligatorio")
@Min(value=0,message="El Stock disponible no puede ser negativo")
@Column(nullable=false)
private Integer stock;

//Para conectar la clase Category.java(Entidad)
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="category_id")
private Category category;





}