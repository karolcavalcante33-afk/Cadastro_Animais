package com.exemplo.abrigo.repository;

import com.exemplo.abrigo.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Consulta para contar e agrupar os animais resgatados por cada funcionário num intervalo de datas
    @Query("SELECT a.funcionario.nome, COUNT(a) FROM Animal a WHERE a.dataEntrada BETWEEN :dataInicio AND :dataFim GROUP BY a.funcionario.nome")
    List<Object[]> contarResgatesPorFuncionarioNoPeriodo(
        @Param("dataInicio") LocalDate dataInicio, 
        @Param("dataFim") LocalDate dataFim
    );
}