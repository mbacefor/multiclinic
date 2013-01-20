package br.med.multiclinic.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.med.multiclinic.domain.Funcionalidade;

@RunWith(DemoiselleRunner.class)
public class GenericoBCTest {

	@Inject
	private ManterFuncionalidadeBC genericoFuncionalidadeBC;

	@Before
	public void before() {
		for (Funcionalidade funcionalidade : genericoFuncionalidadeBC
				.obterTodos()) {
			genericoFuncionalidadeBC.delete(funcionalidade.getId());
		}
	}

	@Test
	public void testLoad() {
		Funcionalidade funcionalidade = new Funcionalidade();
		funcionalidade.setAtivo(true);
		funcionalidade.setDataCadastro(new Date());
		funcionalidade.setDescricao("1");
		funcionalidade.setNome("1");
		genericoFuncionalidadeBC.insert(funcionalidade);
		Funcionalidade funcionalidade2 = genericoFuncionalidadeBC.load(funcionalidade.getId());
		List<Funcionalidade> lista = genericoFuncionalidadeBC.obterTodos();
		assertNotNull(funcionalidade2);
		assertEquals(1, lista.size());
	}

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
	//
	// @Test
	// public void testDelete() {
	// Bookmark bookmark = new Bookmark("Demoiselle Portal",
	// "http://www.frameworkdemoiselle.gov.br");
	// bookmarkBC.insert(bookmark);
	//
	// List<Bookmark> listaBookmarks = bookmarkBC.findAll();
	// assertNotNull(listaBookmarks);
	// assertEquals(1, listaBookmarks.size());
	//
	// bookmarkBC.delete(bookmark.getId());
	// listaBookmarks = bookmarkBC.findAll();
	// assertEquals(0, listaBookmarks.size());
	// }
	// @Test
	// public void testUpdate() {
	// Bookmark bookmark = new Bookmark("Demoiselle Portal",
	// "http://www.frameworkdemoiselle.gov.br");
	// bookmarkBC.insert(bookmark);
	//
	// List<Bookmark> listaBookmarks = bookmarkBC.findAll();
	// Bookmark bookmark2 = (Bookmark)listaBookmarks.get(0);
	// assertNotNull(listaBookmarks);
	// assertEquals("Demoiselle Portal", bookmark2.getDescription());
	//
	// bookmark2.setDescription("Demoiselle Portal alterado");
	// bookmarkBC.update(bookmark2);
	//
	// listaBookmarks = bookmarkBC.findAll();
	// Bookmark bookmark3 = (Bookmark)listaBookmarks.get(0);
	// assertEquals("Demoiselle Portal alterado", bookmark3.getDescription());
	// }
}
