package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.FilaService;


/**
 * 
 * @author Lincoln de Freitas Almeida	 RA:816119071  SI3ANMCA
 *
 */

@Transactional
@Controller("/fila")
public class ManterFilasController {
	private FilaService filaService;

	@Autowired
	public ManterFilasController(FilaService fs) {
		filaService = fs;
	}

	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private List<Fila> listarFilas() throws IOException {
		return filaService.listarFilas();
	}

	@RequestMapping("/listar_filas")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "FilaListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/novaFila")
	public String novoChamado(Model model) {
		return "NovaFila";
	}
	
	@RequestMapping("/novoFila")
	public String novoFila(Model model) {
		return "NovaFila";
	}
	
	
	@RequestMapping("/salvarFila")
	public String salvarChamado(Fila fila, BindingResult result, Model model) {

		try {
			System.out.println(fila.getNome());
			filaService.novaFila(fila);
			model.addAttribute("filas", listarFilas());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "FilaListar";
	}
	
	@RequestMapping("/excluir_fila")
	public String excluirFila(int id, Model model) {
		try {
			Fila fila = new Fila();
			fila.setId(id);
			filaService.excluirFila(fila);
			model.addAttribute("filas", listarFilas());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "FilaListar"; 
	}
	
	@RequestMapping("/mostrarFila")
	public String mostrarFila(int id, Model model) {
		try {
			Fila fila = filaService.carregar(id);
			model.addAttribute("fila", fila);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "MostrarFila"; 
	}
	
	@RequestMapping("/alterarFila")
	public String alterarFila(int id, Model model) {
		try {
			Fila fila = filaService.carregar(id);
			model.addAttribute("fila", fila);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "AlterarFila"; 
	}	
	
	@RequestMapping("/salvarAltFila")
	public String salvarAltFila(Fila fila, BindingResult result, Model model) {

		try {
			String teste = filaService.salvarAltFila(fila);
			System.out.println(teste);
			model.addAttribute("filas", listarFilas());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "FilaListar";
	}	
}
