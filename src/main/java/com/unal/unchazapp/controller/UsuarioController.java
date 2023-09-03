package com.unal.unchazapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unal.unchazapp.controller.dto.ResponseDTO;
import com.unal.unchazapp.services.UsuarioService;
import com.unal.unchazapp.services.dto.UsuarioDTO;

@RestController
@RequestMapping("api/v1/usuario/")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.OPTIONS })
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("usuario")
	public ResponseEntity<ResponseDTO> crearUsuario(@RequestBody UsuarioDTO dto) {
		ResponseDTO data = this.usuarioService.crear(dto);
			
		return new ResponseEntity<ResponseDTO>(data,
                (data == null || !data.isSuccess() ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.OK));
	}
	
	@GetMapping("findUsuarioByDocumento/{documento}/")
	public ResponseEntity<UsuarioDTO> findUsuarioByDocumento(@PathVariable("documento") String documento){
		UsuarioDTO data = this.usuarioService.findByDocumento(documento);
		return new ResponseEntity<UsuarioDTO>(data, (data == null ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.OK));
	}
	
}