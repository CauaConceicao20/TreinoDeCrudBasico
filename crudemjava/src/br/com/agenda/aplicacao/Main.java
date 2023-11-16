package br.com.agenda.aplicacao;

import java.util.Date;
import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		ContatoDAO contatoDAO = new ContatoDAO();
		/*Contato contato = new Contato();
		contato.setNome("Loiane Java");
		contato.setIdade(17);
		contato.setDataCadastro(new Date());
		
		contatoDAO.save(contato);*/
		
		Contato c1 = new Contato();
		
		c1.setNome("Maria Gabriela Dias Orlando");
		c1.setIdade(37);
		c1.setDataCadastro(new Date());
		c1.setId(1);
		
		contatoDAO.update(c1);
		
		contatoDAO.delete(8);
		
		for(Contato contatos : contatoDAO.getContato()) {
			System.out.println("Contatos: " + contatos.getNome());
		}
	}

}
