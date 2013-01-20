/**
 * 
 */
package br.med.multiclinic.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Usuario;

/**
 * @author mbacefor
 * 
 */
@RunWith(DemoiselleRunner.class)
public class ManterFuncionalidadeBCTest {

	@Inject
	private ManterFuncionalidadeBC genericoFuncionalidadeBC;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		for (Funcionalidade funcionalidade : genericoFuncionalidadeBC
				.obterTodos()) {
			genericoFuncionalidadeBC.delete(funcionalidade.getId());
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link br.med.multiclinic.business.GenericoBC#salvar(br.med.multiclinic.domain.template.EntidadeGeralTemplate, br.med.multiclinic.domain.Usuario)}
	 * .
	 */
	@Test
	public void testSalvar() {

		// Teste fluxo principal - Insert
		Usuario usuarioCriador = new Usuario();
		usuarioCriador.setAtivo(true);
		usuarioCriador.setDataCadastro(new Date());
		usuarioCriador.setEmail("mbacefor@gmail.com");
		usuarioCriador.setSenha("1234");

		Funcionalidade funcionalidade = new Funcionalidade();
		funcionalidade.setAtivo(true);
		funcionalidade.setDataCadastro(new Date());
		funcionalidade.setDescricao("1");
		funcionalidade.setNome("1");
		genericoFuncionalidadeBC.salvar(funcionalidade, usuarioCriador);
		List<Funcionalidade> lista = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(lista);
		assertNotNull(lista.get(0));
		assertNotNull(lista.get(0).getUsuarioCriador());
		assertEquals(funcionalidade, lista.get(0));

		Funcionalidade funcionalidade1 = new Funcionalidade();
		funcionalidade1.setAtivo(true);
		funcionalidade1.setDataCadastro(new Date());
		funcionalidade1.setDescricao("2");
		funcionalidade1.setNome("2");
		genericoFuncionalidadeBC.salvar(funcionalidade1, usuarioCriador);
		List<Funcionalidade> lista1 = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(lista1);
		assertEquals(2, lista1.size());

		// Teste - Update

		funcionalidade1.setDescricao("2-Alterado");
		funcionalidade1.setNome("2-Nome Alterado");
		genericoFuncionalidadeBC.salvar(funcionalidade1, usuarioCriador);

		Funcionalidade funcionalidade2 = genericoFuncionalidadeBC
				.load(funcionalidade1.getId());
		assertNotNull(funcionalidade2);
		assertEquals("2-Alterado", funcionalidade2.getDescricao());
		assertEquals("2-Nome Alterado", funcionalidade2.getNome());

		// teste nome repetido
		Funcionalidade funcionalidade3 = new Funcionalidade();
		funcionalidade3.setAtivo(true);
		funcionalidade3.setDataCadastro(new Date());
		funcionalidade3.setDescricao("1");
		funcionalidade3.setNome("1");
		try {
			genericoFuncionalidadeBC.salvar(funcionalidade3, usuarioCriador);
			fail();
		} catch (RuntimeException e) {
			assertNotNull(funcionalidade3);
		}

		// teste campos obrigatorios
		Funcionalidade funcionalidade4 = new Funcionalidade();
		funcionalidade4.setAtivo(true);
		funcionalidade4.setDataCadastro(new Date());
		funcionalidade4.setDescricao("1222");
		try {
			genericoFuncionalidadeBC.salvar(funcionalidade3, usuarioCriador);
			fail();
		} catch (RuntimeException e) {
			assertNotNull(funcionalidade3);
		}

	}

	/**
	 * Test method for
	 * {@link br.med.multiclinic.business.GenericoBC#obterTodos()}.
	 */
	@Test
	public void testObterTodos() {
		Funcionalidade funcionalidade = new Funcionalidade();
		funcionalidade.setAtivo(true);
		funcionalidade.setDataCadastro(new Date());
		funcionalidade.setDescricao("500");
		funcionalidade.setNome("500");
		genericoFuncionalidadeBC.salvar(funcionalidade,null);
		List<Funcionalidade> lista = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(lista);
		assertEquals(1, lista.size());
	}

	/**
	 * Test method for
	 * {@link br.med.multiclinic.business.GenericoBC#excluir(br.med.multiclinic.domain.template.EntidadeGeralTemplate)}
	 * .
	 */
	@Test
	public void testExcluir() {
		Funcionalidade funcionalidade = new Funcionalidade();
		funcionalidade.setAtivo(true);
		funcionalidade.setDataCadastro(new Date());
		funcionalidade.setDescricao("51");
		funcionalidade.setNome("51");
		genericoFuncionalidadeBC.insert(funcionalidade);
		List<Funcionalidade> lista = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(lista);
		assertEquals(1, lista.size());
		genericoFuncionalidadeBC.excluir(funcionalidade);
		lista = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(lista);
		assertEquals(0, lista.size());

	}

	/**
	 * Test method for
	 * {@link br.gov.frameworkdemoiselle.template.DelegateCrud#insert(java.lang.Object)}
	 * .
	 */
	@Test
	public void testInsert() {
		Funcionalidade funcionalidade = new Funcionalidade();
		funcionalidade.setAtivo(true);
		funcionalidade.setDataCadastro(new Date());
		funcionalidade.setDescricao("1");
		funcionalidade.setNome("1");
		genericoFuncionalidadeBC.insert(funcionalidade);
		List<Funcionalidade> lista = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(lista);
		assertEquals(1, lista.size());
	}

	/**
	 * Test method for
	 * {@link br.gov.frameworkdemoiselle.template.DelegateCrud#load(java.lang.Object)}
	 * .
	 */
	@Test
	public void testLoad() {
		Funcionalidade funcionalidade = new Funcionalidade();
		funcionalidade.setAtivo(true);
		funcionalidade.setDataCadastro(new Date());
		funcionalidade.setDescricao("1");
		funcionalidade.setNome("1");
		genericoFuncionalidadeBC.insert(funcionalidade);
		Funcionalidade funcionalidade2 = genericoFuncionalidadeBC
				.load(funcionalidade.getId());
		List<Funcionalidade> lista = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(funcionalidade2);
		assertEquals(1, lista.size());
	}

	/**
	 * Test method for
	 * {@link br.gov.frameworkdemoiselle.template.DelegateCrud#update(java.lang.Object)}
	 * .
	 */
	@Test
	public void testUpdate() {
		Funcionalidade funcionalidade1 = new Funcionalidade();
		funcionalidade1.setAtivo(true);
		funcionalidade1.setDataCadastro(new Date());
		funcionalidade1.setDescricao("2");
		funcionalidade1.setNome("2");
		genericoFuncionalidadeBC.insert(funcionalidade1);
		List<Funcionalidade> lista1 = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(lista1);
		assertEquals(1, lista1.size());

		// Teste - Update

		funcionalidade1.setDescricao("2-Alterado");
		funcionalidade1.setNome("2-Nome Alterado");
		genericoFuncionalidadeBC.update(funcionalidade1);

		Funcionalidade funcionalidade2 = genericoFuncionalidadeBC
				.load(funcionalidade1.getId());
		assertNotNull(funcionalidade2);
		assertEquals("2-Alterado", funcionalidade2.getDescricao());
		assertEquals("2-Nome Alterado", funcionalidade2.getNome());

	}

}
