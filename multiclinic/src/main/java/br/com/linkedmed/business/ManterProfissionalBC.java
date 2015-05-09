/**
 * 
 */
package br.com.linkedmed.business;

import java.util.List;

import javax.inject.Inject;

import br.com.linkedmed.domain.Profissional;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.persistence.ProfissionalDAO;
import br.com.linkedmed.util.Fonetizador;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;

/**
 * @author fa7bd
 * 
 */
@BusinessController
public class ManterProfissionalBC extends
		GenericoBC<Profissional, Long, ProfissionalDAO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	Fonetizador fonetizador;

	public void salvar(Profissional profissional, Usuario usuarioLogado) {
		profissional.setNomeFonetico(fonetizador
				.fornetizarComDicionario((profissional.getNome())));

		super.salvar(profissional, usuarioLogado);
	}

	public List<Profissional> buscaFoneticaNome(String query) {
		query = fonetizador.fornetizarComDicionario(query);
		return ((ProfissionalDAO) getDelegate()).buscaFoneticaNome(query);
	}

}