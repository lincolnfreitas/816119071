package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;

/**
 * 
 * @author Lincoln de freitas almeida RA:816119071 SI3ANMCA
 *
 */
@RestController
public class ManterChamadosRest {

	private ChamadoService cService;
	private FilaService fService;

	@Autowired
	public ManterChamadosRest(ChamadoService c, FilaService f) {
		cService = c;
		fService = f;
	}
    
	@RequestMapping(method = RequestMethod.GET, value = "rest/chamados/{id}")
	public @ResponseBody List<Chamado> listarChamados(
			@PathVariable("id") Long id) {
		List<Chamado> chamados = null;
		try {
			Fila fila = fService.carregar(id.intValue());
			chamados = cService.listarChamados(fila);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chamados;
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "rest/chamados")
	public ResponseEntity<Chamado> criarChamado(@RequestBody Chamado chamado) {
		try {
			System.out.println(chamado);
			cService.novoChamado(chamado);
			return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Chamado>(chamado,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}









