package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
@Repository
public class FilaDAO {


	/**
	 * 
	 * @author Lincoln de freitas almeida RA:816119071 SI3ANMCA
	 *
	 */

	@PersistenceContext
	EntityManager manager;
	
	public List<Fila> listarFilas() throws IOException {
		return manager.createQuery("select f from Fila f").getResultList();
	}

	public Fila carregar(int id) throws IOException {
		return manager.find(Fila.class, id);
	}
	
	public void criarFila(Fila fila){
		manager.persist(fila);
	}
	
	public void fecharFila(Fila fila){
		manager.remove(fila);
	}	
}