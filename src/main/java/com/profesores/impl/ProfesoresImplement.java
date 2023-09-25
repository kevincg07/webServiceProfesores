package com.profesores.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistence_escuela.entity.Profesores;
import com.persistence_escuela.repository.ProfesoresRepositoy;
import com.persistence_escuela.request.ProfesoresRequest;
import com.profesores.service.ProfesoresService;

@Service
public class ProfesoresImplement implements ProfesoresService{

	@Autowired
	ProfesoresRepositoy repo;

	@Override
	public Profesores guardar(ProfesoresRequest request) {
		Profesores p = new Profesores();
		p.setNombre(request.getNombre());
		p.setCedula(request.getCedula());
		p.setTelefono(request.getTelefono());
		p.setFechaIngreso(request.getFechaIngreso());
		p.setArea(request.getArea());
		p.setSueldo(request.getSueldo());
		
		repo.save(p);
		return p;
	}

	@Override
	public Profesores acualizar(ProfesoresRequest request) {
		Profesores p = repo.findById(request.getIdProfesor()).get();
		p.setNombre(request.getNombre());
		p.setCedula(request.getCedula());
		p.setTelefono(request.getTelefono());
		p.setFechaIngreso(request.getFechaIngreso());
		p.setArea(request.getArea());
		p.setSueldo(request.getSueldo());
		
		repo.save(p);
		return p;
	}

	@Override
	public Profesores buscar(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public Profesores buscar(String name) {
		
		return repo.findByName(name).get();
	}

	@Override
	public List mostrar() {
		
		return repo.findAll();
	}

	@Override
	public String borrar(int id) {
		repo.deleteById(id);
		return "Borrado";
	}
	
}
