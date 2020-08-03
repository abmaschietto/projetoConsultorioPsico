package com.consultorio.consultorio.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.consultorio.form.PacienteForm;
import com.consultorio.consultorio.model.Doutores;
import com.consultorio.consultorio.model.Pacientes;
import com.consultorio.consultorio.repository.DoutoresRepository;
import com.consultorio.consultorio.repository.PacientesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Api para CRUD de um consultorio de Psicologia")
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ConsultorioController {
	
	@Autowired
	private PacientesRepository pacienteRepo;
	
	@Autowired
	private DoutoresRepository doutorRepo;
	
	@GetMapping("/hello")
	public String hello() {
		return "Olá";
	}

	@ApiOperation(value = "Busca uma lista de pacientes")
	@GetMapping(value = "/pacientes")
	public ResponseEntity<List<Pacientes>> pacientes(){
		List<Pacientes> pacientes = pacienteRepo.findAll();
		return ResponseEntity.ok(pacientes);
	}
	
	@ApiOperation(value = "Busca uma lista de doutores")
	@GetMapping(value = "/doutores")
	public ResponseEntity<List<Doutores>> doutores(){
		List<Doutores> doutores = doutorRepo.findAll();
		return ResponseEntity.ok(doutores);
	}
	
	@ApiOperation(value = "Cadastra um paciente, não passe um id")
	@PostMapping(value = "/pacientes")
	public ResponseEntity<?> postaPaciente(@RequestBody  PacienteForm form){
		Pacientes paciente = form.conversor(doutorRepo);
		pacienteRepo.save(paciente);
		List<Pacientes> pacientes = pacienteRepo.findAll();
		return ResponseEntity.ok(pacientes);
	}
	
	@ApiOperation(value = "Cadastra um doutor, não passe um id")
	@PostMapping(value = "/doutores")
	public ResponseEntity<List<Doutores>> postaDoutor(@RequestBody @Valid Doutores doutor){
		doutorRepo.save(doutor);
		List<Doutores> doutores = doutorRepo.findAll();
		return ResponseEntity.ok(doutores);
	}
	
	@ApiOperation(value = "Atualiza as informações de um paciente")
	@PutMapping(value = "/pacientes/{id}")
	public ResponseEntity<?> atualizarPaciente(@PathVariable(name = "id", required = true) Long id, @RequestBody PacienteForm form){
		Pacientes paciente  = form.atualizar(id, form, doutorRepo, pacienteRepo);
		pacienteRepo.save(paciente);
//		List<Pacientes> lista = pacienteRepo.findAll();
		return ResponseEntity.ok(paciente);
	}
	
	@ApiOperation(value = "Atualiza as informações de um doutor")
	@PutMapping(value = "/doutores/{id}")
	public ResponseEntity<?> atualizarDoutor(@PathVariable (name = "id", required = true)Long id, @RequestBody Doutores doutor ){	
			doutor.setId(id);
			doutorRepo.save(doutor);
			List<Doutores> lista = doutorRepo.findAll();
			return ResponseEntity.ok(lista);	
	}
	
	@ApiOperation(value = "Deleta um paciente pelo id")
	@DeleteMapping(value = "/pacientes/{id}")
	public ResponseEntity<?> deletarPaciente(@PathVariable (name = "id", required = true)Long id){
		pacienteRepo.deleteById(id);
		List<Pacientes> lista = pacienteRepo.findAll();
		return ResponseEntity.ok(lista);	
	}
	
	@ApiOperation(value = "Deletar um doutor pelo id")
	@DeleteMapping(value = "/doutores/{id}")
	public ResponseEntity<?> deletarDoutor(@PathVariable (name = "id", required = true)Long id){
		doutorRepo.deleteById(id);
		List<Doutores> listar = doutorRepo.findAll();
		return ResponseEntity.ok(listar);
	}
}
