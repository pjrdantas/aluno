package com.tobrasil.aluno.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobrasil.aluno.handler.ResourceNotFoundException;
import com.tobrasil.aluno.model.Aluno;
import com.tobrasil.aluno.repository.AlunoRepository;



@RestController
@RequestMapping("/api/v1")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	
	
	
	
	
	
	@GetMapping("/alunos")
    public List < Aluno > getAllAlunos() {
		
        return alunoRepository.findAll();
    }
	
	
	
	/**
	 * 
	 * @param alunoeId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/alunos/{id}")
    public ResponseEntity < Aluno > getAlunoById(@PathVariable(value = "id") Long alunoId) throws ResourceNotFoundException {
		
		Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado para este id :: " + alunoId));
        return ResponseEntity.ok().body(aluno);
    }
	

	/**
	 * 
	 * @param aluno
	 * @return
	 */
    @PostMapping("/alunos")
    public Aluno createAluno(@Valid @RequestBody Aluno aluno) {
    	
        return alunoRepository.save(aluno);
    }

    
    /**
     * 
     * @param alunoId
     * @param alunoDetails
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/alunos/{id}")
    public ResponseEntity < Aluno > updateAluno(@PathVariable(value = "id") Long alunoId, @Valid @RequestBody Aluno alunoDetails) throws ResourceNotFoundException {
    	
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado para este id :: " + alunoId));

        aluno.setNome(alunoDetails.getNome());
        aluno.setIdade(alunoDetails.getIdade());
        final Aluno updatedAluno = alunoRepository.save(aluno);
        return ResponseEntity.ok(updatedAluno);
    }

    
    
    /**
     * 
     * @param alunoId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/alunos/{id}")
    public Map < String, Boolean > deleteAluno(@PathVariable(value = "id") Long alunoId)  throws ResourceNotFoundException {
    	
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado para este id :: " + alunoId));

        alunoRepository.delete(aluno);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
	


