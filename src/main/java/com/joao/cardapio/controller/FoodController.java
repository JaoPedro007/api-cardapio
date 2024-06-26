package com.joao.cardapio.controller;
import com.joao.cardapio.food.Food;
import com.joao.cardapio.food.FoodRepository;
import com.joao.cardapio.food.FoodRequestDTO;
import com.joao.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foods = new Food(data);
        repository.save(foods);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).collect(Collectors.toList());
        return foodList;
    }
}
