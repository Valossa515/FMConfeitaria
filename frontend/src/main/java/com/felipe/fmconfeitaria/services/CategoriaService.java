package com.felipe.fmconfeitaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.fmconfeitaria.dto.CategoriaDTO;
import com.felipe.fmconfeitaria.entities.Categoria;
import com.felipe.fmconfeitaria.repositories.CategoriaRepository;
import com.felipe.fmconfeitaria.services.exceptions.DataIntegrityException;
import com.felipe.fmconfeitaria.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional
	public Categoria find(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName() ));
	}
	@Transactional
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return categoriaRepository.save(newObj);
	}
	
	public void delete(Long id) {
		find(id);
		
		try {
			categoriaRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma cateogria que possui produtos!");
		}
	}
	@Transactional
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	@Transactional
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, 
			String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
				Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}
	
	public void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
}
