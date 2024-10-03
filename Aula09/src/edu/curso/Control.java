package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class Control {
	private List<Contato> lista = new ArrayList<Contato>();

	public void gravar(Contato c) {
		lista.add(c);

	}

	public Contato pesquisar(String NomeParcial) {
		for (Contato c : lista) {
			if (c.getNome().contains(NomeParcial)) {
				return c;
			}
		}
		return null;
	}

}
