package com.itechstore.platform.repository;

import com.itechstore.platform.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


    
}
