package com.rosales.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rosales.dto.ConsultaListaExamenDTO;
import com.rosales.dto.ConsultaResumenDTO;
import com.rosales.dto.FiltroConsultaDTO;
import com.rosales.exception.ModeloNotFoundException;
import com.rosales.model.Archivo;
import com.rosales.model.Consulta;
import com.rosales.service.IArchivoService;
import com.rosales.service.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaService service;

	@Autowired
	private IArchivoService serviceArchivo;

	@GetMapping
	public ResponseEntity<List<Consulta>> listar() {
		List<Consulta> lista = service.listar();
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id) {
		Consulta obj = service.listarPorId(id);
		if (obj.getIdConsulta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}

	// https://docs.spring.io/spring-hateoas/docs/current/reference/html/
	// Hateoas 1.0 > Spring Boot 2.2
	@GetMapping("/hateoas/{id}")
	public EntityModel<Consulta> listarPorIdHateoas(@PathVariable("id") Integer id) {
		Consulta pac = service.listarPorId(id);

		// localhost:8080/Consultas/{id}
		EntityModel<Consulta> recurso = new EntityModel<Consulta>(pac);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		recurso.add(linkTo.withRel("Consulta-resource"));
		return recurso;

	}

	/*
	 * @PostMapping public ResponseEntity<Consulta> registrar(@Valid @RequestBody
	 * Consulta objeto) { Consulta obj = service.registrar(objeto); return new
	 * ResponseEntity<Consulta>(obj, HttpStatus.CREATED); }
	 */

	/*
	 * @PostMapping public ResponseEntity<Object> registrar(@Valid @RequestBody
	 * Consulta objeto) { Consulta pac = service.registrar(objeto);
	 * //localhost:8080/Consultas/5 URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (pac.getIdConsulta()).toUri(); return
	 * ResponseEntity.created(location).build(); }
	 */

	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody ConsultaListaExamenDTO dto) {
		Consulta pac = service.registrarTransaccional(dto);
		// localhost:8080/Consultas/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pac.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta objeto) {
		Consulta obj = service.modificar(objeto);
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/buscar")
	public ResponseEntity<List<Consulta>> buscar(@RequestBody FiltroConsultaDTO filtro) {
		List<Consulta> consultas = new ArrayList<>();

		if (filtro != null) {
			if (filtro.getFechaConsulta() != null) {
				consultas = service.buscarFecha(filtro);
			} else {
				consultas = service.buscar(filtro);
			}
		}
		return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
	}

	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<ConsultaResumenDTO>> listarResumen() {
		List<ConsultaResumenDTO> consultas = new ArrayList<>();
		consultas = service.listarResumen();
		return new ResponseEntity<List<ConsultaResumenDTO>>(consultas, HttpStatus.OK);
	}

	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte() {
		byte[] data = null;
		data = service.generarReporte();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

	@PostMapping(value = "/guardarArchivo", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Integer> guardarArchivo(@RequestParam("adjunto") MultipartFile file) throws IOException {
		int rpta = 0;

		Archivo ar = new Archivo();
		ar.setFiletype(file.getContentType());
		ar.setFilename(file.getName());
		ar.setValue(file.getBytes());

		rpta = serviceArchivo.guardar(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}

	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {
				
		byte[] arr = serviceArchivo.leerArchivo(idArchivo); 

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}
}
