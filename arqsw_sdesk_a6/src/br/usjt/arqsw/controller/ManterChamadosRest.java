package br.usjt.arqsw.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

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
 * @author Lincoln de Freitas Almeida	 RA:816119071  SI3ANMCA
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
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/chamados")
	public @ResponseBody List<Chamado> listarTodosChamados() {
		List<Chamado> chamados = null;
		try {
			chamados = cService.listarTodosChamados();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chamados;
	}

	@RequestMapping(method = RequestMethod.GET, value = "rest/chamados/abertos/{id}")
	public @ResponseBody List<Chamado> listarChamadosAbertos(
			@PathVariable("id") Long id) {
		List<Chamado> chamados = null;
		try {
			Fila fila = fService.carregar(id.intValue());
			chamados = cService.listarTodosChamados();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chamados;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/filas")
	public @ResponseBody List<Fila> listarFilas() {
		List<Fila> filas = null;
		try {
			filas = fService.listarFilas();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filas;
	}
}










