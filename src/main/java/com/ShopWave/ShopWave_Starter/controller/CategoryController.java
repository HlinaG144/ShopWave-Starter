//Hlina Girum ATE/3417/14

package com.ShopWave.ShopWave_Starter.controller;

import com.ShopWave.ShopWave_Starter.model.Category;
import com.ShopWave.ShopWave_Starter.repository.CategoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<Category> create (@Valid @RequestBody Category category){
        Category saved = categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public ResponseEntity<java.util.List<Category>> getAll(){
        return ResponseEntity.ok(categoryRepository.findAll());
    }
}
