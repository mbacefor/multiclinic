package br.com.linkedmed.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class FonetizadorTest {

	@Inject
	Fonetizador fonetizador;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFornetizarComDicionario() {
		String texto1 = "hermano";
		String textoFonetizado1 = null;
		String texto2 = "ermano";
		String textoFonetizado2 = null;
		textoFonetizado1 = fonetizador.fornetizarComDicionario(texto1);
		textoFonetizado2 = fonetizador.fornetizarComDicionario(texto2);
		assertEquals(textoFonetizado1, textoFonetizado2);

		assertFalse(fonetizador.fornetizarComDicionario("homem").equals(
				fonetizador.fornetizarComDicionario("mulher")));

	}

	@Test
	public void testFornetizarSemDicionario() {

		assertEquals(fonetizador.fornetizarComDicionario("dARIO"),
				fonetizador.fornetizarComDicionario("DARIO"));

		assertEquals(
				fonetizador.fornetizarComDicionario("SAL DA TERRA  dos homens"),
				fonetizador.fornetizarComDicionario("sau da tera dos omens"));

		assertFalse(fonetizador.fornetizarComDicionario("homem").equals(
				fonetizador.fornetizarComDicionario("mulher")));

	}

	@Test
	public void testAbrevitar() {

		assertEquals(fonetizador.abrevitar("amor", (short) 1, (short) 1,
				CORBAphonetic.OrientationOption.left), "a");
		
		assertEquals(fonetizador.abrevitar("amor", (short) 2, (short) 2,
				CORBAphonetic.OrientationOption.left), "a");
		
		assertEquals(fonetizador.abrevitar("Marcelo Bezerra de Alcantara", (short) 4, (short) 3,
				CORBAphonetic.OrientationOption.left), "d A");
		
	}

	@Test
	public void testGeradorCodigo() {
		assertEquals(fonetizador.geradorCodigo("Marcelo Bezerra de Alcantara").all, fonetizador.geradorCodigo("Marcelo Bezera de Alcantara").all);
		
		assertEquals(fonetizador.geradorCodigo("Marcelo Bezerra di Alcantara").all, fonetizador.geradorCodigo("Marcelo Bezera de Alcantara").all);
	}

}
