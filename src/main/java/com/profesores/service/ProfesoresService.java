package com.profesores.service;

import java.util.List;

import com.persistence_escuela.entity.Profesores;
import com.persistence_escuela.request.ProfesoresRequest;

public interface ProfesoresService {
	
	Profesores guardar(ProfesoresRequest request);
	Profesores acualizar(ProfesoresRequest request);
	Profesores buscar(int id);
	Profesores buscar(String name);
	List mostrar();
	String borrar(int id);

}
