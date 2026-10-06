package com.exemplo.abrigo.controller;

import com.exemplo.abrigo.model.Animal;
import com.exemplo.abrigo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    // Endpoint para listar todos os animais (cães, gatos, etc.)
    @GetMapping
    public List<Animal> listar() {
        return animalRepository.findAll();
    }

    // Endpoint para cadastrar um novo animal
    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody Animal animal) {
        Animal novoAnimal = animalRepository.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAnimal);
    }

    // Endpoint para o Exercício 2: Contagem de resgates por funcionário num intervalo de datas
    @GetMapping("/relatorio-resgates")
    public List<Object[]> relatorioResgates(
            @RequestParam("inicio") LocalDate inicio,
            @RequestParam("fim") LocalDate fim) {
        return animalRepository.contarResgatesPorFuncionarioNoPeriodo(inicio, fim);
    }
}