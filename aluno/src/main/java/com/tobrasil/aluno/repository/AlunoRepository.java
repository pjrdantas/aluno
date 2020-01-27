package com.tobrasil.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobrasil.aluno.model.Aluno;

@Repository
public interface  AlunoRepository extends JpaRepository<Aluno, Long>{

	
}
