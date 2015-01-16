package br.com.linkedmed.business;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.Crud;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.domain.template.EntidadeGeralTemplate;

@BusinessController
public class GenericoBC<T extends EntidadeGeralTemplate, I, JPACrud> extends
		DelegateCrud<T, I, Crud<T, I>> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public void salvar(T entidadeGeralTemplate, Usuario usuarioLogado) {
		try {

			if (entidadeGeralTemplate != null
					&& entidadeGeralTemplate.getId() == null) {
				entidadeGeralTemplate.setUsuarioCriador(usuarioLogado);
				entidadeGeralTemplate.setDataCadastro(new Date());
				insert(entidadeGeralTemplate);
			} else
				update(entidadeGeralTemplate);
			entityManager.flush();

		} catch (org.hibernate.exception.ConstraintViolationException e) {
			throw new RuntimeException("Campo duplicado cadastrado");
		} catch (RollbackException e) {
			Throwable causa = e;
			String mensagem = null;
			do {
				mensagem = causa.getLocalizedMessage();
				causa = causa.getCause();
			} while (causa != null);

			throw new RuntimeException(mensagem);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getLocalizedMessage());
		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<T> obterTodos() {
		List<T> lista = null;
		try {

			lista = findAll();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return lista;
	}

	public List<T> obterTodosAtivos(Class<T> classe) {
		List<T> lista = null;
		try {

			String consulta = "from " + classe.getSimpleName()
					+ " where ativo = true";
			lista = (List<T>) entityManager.createQuery(consulta)
					.getResultList();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return lista;
	}

	public void excluir(T enTemplate) {
		try {
			delete((I) enTemplate.getId());
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause().getLocalizedMessage());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
