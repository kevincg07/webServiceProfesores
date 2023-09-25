package com.profesores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistence_escuela.entity.Profesores;
import com.persistence_escuela.request.ProfesoresRequest;
import com.profesores.impl.ProfesoresImplement;

@RestController
@RequestMapping("profesores/")
public class ProfesoresController {

	@Autowired
	ProfesoresImplement logic;
	
	
	@PostMapping
	ResponseEntity<Profesores> guardar(@RequestBody ProfesoresRequest request){
		Profesores p = logic.guardar(request);
		return new ResponseEntity<Profesores>(p, HttpStatus.OK);
	}
	
	@PutMapping
	ResponseEntity<Profesores> actualizar(@RequestBody ProfesoresRequest request){
		Profesores p = logic.acualizar(request);
		return new ResponseEntity<Profesores>(p, HttpStatus.OK);
	}
	
	@GetMapping("buscar-por-nombre/{id}")
	ResponseEntity<Profesores> buscar(@PathVariable("id")int id){
		Profesores p = logic.buscar(id);
		return new ResponseEntity<Profesores>(p, HttpStatus.OK);
	}
	
	@GetMapping("buscar-por-nombre/{name}")
	ResponseEntity<Profesores> buscar(@PathVariable("name")String name){
		Profesores p = logic.buscar(name);
		return new ResponseEntity<Profesores>(p, HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity<List<Profesores>> mostrar(){
		List<Profesores> ps = logic.mostrar();
		return new ResponseEntity<List<Profesores>>(ps, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar/{id}")
	ResponseEntity<String> eliminar(@PathVariable("id") int id){
		String m = logic.borrar(id);
		return new ResponseEntity<String>(m, HttpStatus.OK);
	}
}
