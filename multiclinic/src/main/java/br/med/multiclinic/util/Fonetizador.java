/**
 * 
 */
package br.med.multiclinic.util;

import CORBAphonetic.AbbreviateError;
import br.gov.frameworkdemoiselle.stereotype.Controller;

/**
 * @author mbacefor
 * 
 */


@Controller
public class Fonetizador {

	// Declarando os objetos necessários.
	// Declarando instâncias das interfaces.
	CORBAphonetic.CodeGenerator codeGenerator = null;
	CORBAphonetic.Phonetic phon = null;
	CORBAphonetic.Phonetician phonetician = null;
	CORBAphonetic.PhoneticTransformer phoneticTransformer = null;
	CORBAphonetic.Abbreviator abbreviator = null;
	CORBApersistence.TextPObjImp text1 = null;
	CORBApersistence.TextPObjImp text2 = null;
	CORBApersistence.TextPObjImp text3 = null;
	CORBApersistence.TextPObjImp text4 = null;
	CORBApersistence.TextPObjImp text5 = null;
	CORBApersistence.TextPObjImp text6 = null;
	CORBApersistence.TextPObjImp text7 = null;
	CORBApersistence.TextPObjImp text8 = null;
	CORBApersistence.Equivalences equiv1 = null;
	CORBApersistence.Equivalences equiv2 = null;
	CORBApersistence.Equivalences equiv3 = null;
	CORBApersistence.Equivalences equiv4 = null;
	CORBApersistence.Equivalences equiv5 = null;
	CORBApersistence.Tokens tok6 = null;
	CORBApersistence.Tokens tok7 = null;
	CORBApersistence.Tokens tok8 = null;

	// Declarando instâncias das classes que possuem as implementações.
	CORBAphonetic.CodeGeneratorImpl codeGeneratorImpl = null;
	CORBAphonetic.PhoneticImpl phonImpl = null;
	CORBAphonetic.PhoneticianImpl phoneticianImpl = null;
	CORBAphonetic.PhoneticTransformerImpl phoneticTransformerImpl = null;
	CORBAphonetic.AbbreviatorImpl abbreviatorImpl = null;
	CORBApersistence.TextPObjImpImpl textImpl1 = null;
	CORBApersistence.TextPObjImpImpl textImpl2 = null;
	CORBApersistence.TextPObjImpImpl textImpl3 = null;
	CORBApersistence.TextPObjImpImpl textImpl4 = null;
	CORBApersistence.TextPObjImpImpl textImpl5 = null;
	CORBApersistence.TextPObjImpImpl textImpl6 = null;
	CORBApersistence.TextPObjImpImpl textImpl7 = null;
	CORBApersistence.TextPObjImpImpl textImpl8 = null;
	CORBApersistence.EquivalencesImpl equivImpl1 = null;
	CORBApersistence.EquivalencesImpl equivImpl2 = null;
	CORBApersistence.EquivalencesImpl equivImpl3 = null;
	CORBApersistence.EquivalencesImpl equivImpl4 = null;
	CORBApersistence.EquivalencesImpl equivImpl5 = null;
	CORBApersistence.TokensImpl tokImpl6 = null;
	CORBApersistence.TokensImpl tokImpl7 = null;
	CORBApersistence.TokensImpl tokImpl8 = null;

	public Fonetizador() {
		super();
		// Inicializando os objetos necessários.
		// Inicializando os objetos que possuem as implementações.
		codeGeneratorImpl = new CORBAphonetic.CodeGeneratorImpl();
		phonImpl = new CORBAphonetic.PhoneticImpl();
		phoneticianImpl = new CORBAphonetic.PhoneticianImpl();
		phoneticTransformerImpl = new CORBAphonetic.PhoneticTransformerImpl();
		abbreviatorImpl = new CORBAphonetic.AbbreviatorImpl();
		textImpl1 = new CORBApersistence.TextPObjImpImpl();
		textImpl2 = new CORBApersistence.TextPObjImpImpl();
		textImpl3 = new CORBApersistence.TextPObjImpImpl();
		textImpl4 = new CORBApersistence.TextPObjImpImpl();
		textImpl5 = new CORBApersistence.TextPObjImpImpl();
		textImpl6 = new CORBApersistence.TextPObjImpImpl();
		textImpl7 = new CORBApersistence.TextPObjImpImpl();
		textImpl8 = new CORBApersistence.TextPObjImpImpl();
		equivImpl1 = new CORBApersistence.EquivalencesImpl();
		equivImpl2 = new CORBApersistence.EquivalencesImpl();
		equivImpl3 = new CORBApersistence.EquivalencesImpl();
		equivImpl4 = new CORBApersistence.EquivalencesImpl();
		equivImpl5 = new CORBApersistence.EquivalencesImpl();
		tokImpl6 = new CORBApersistence.TokensImpl();
		tokImpl7 = new CORBApersistence.TokensImpl();
		tokImpl8 = new CORBApersistence.TokensImpl();

		// Inicializando as interfaces = ligando os objetos às interfaces.
		codeGenerator = new CORBAphonetic._tie_CodeGenerator(codeGeneratorImpl,
				"codeGen");
		phon = new CORBAphonetic._tie_Phonetic(phonImpl, "phon");
		phonetician = new CORBAphonetic._tie_Phonetician(phoneticianImpl,
				"phonetician");
		phoneticTransformer = new CORBAphonetic._tie_PhoneticTransformer(
				phoneticTransformerImpl, "phonTrans");
		abbreviator = new CORBAphonetic._tie_Abbreviator(abbreviatorImpl,
				"abbr");
		text1 = new CORBApersistence._tie_TextPObjImp(textImpl1, "text1");
		text2 = new CORBApersistence._tie_TextPObjImp(textImpl2, "text2");
		text3 = new CORBApersistence._tie_TextPObjImp(textImpl3, "text3");
		text4 = new CORBApersistence._tie_TextPObjImp(textImpl4, "text4");
		text5 = new CORBApersistence._tie_TextPObjImp(textImpl5, "text5");
		text6 = new CORBApersistence._tie_TextPObjImp(textImpl6, "text6");
		text7 = new CORBApersistence._tie_TextPObjImp(textImpl7, "text7");
		text8 = new CORBApersistence._tie_TextPObjImp(textImpl8, "text8");
		equiv1 = new CORBApersistence._tie_Equivalences(equivImpl1, "equiv1");
		equiv2 = new CORBApersistence._tie_Equivalences(equivImpl2, "equiv2");
		equiv3 = new CORBApersistence._tie_Equivalences(equivImpl3, "equiv3");
		equiv4 = new CORBApersistence._tie_Equivalences(equivImpl4, "equiv4");
		equiv5 = new CORBApersistence._tie_Equivalences(equivImpl4, "equiv5");
		tok6 = new CORBApersistence._tie_Tokens(tokImpl6, "tok6");
		tok7 = new CORBApersistence._tie_Tokens(tokImpl7, "tok7");
		tok8 = new CORBApersistence._tie_Tokens(tokImpl8, "tok8");

		// Associando os arquivos dos dicionários aos objetos que fazem a
		// persistência.
		// Observe que os objetos text1, text2 ..., text8 são do tipo
		// TextPObjImp.
		text1.fileName("names.txt"); // Tabela de Nomes
		text2.fileName("numbers.txt"); // Tabela de Números
		text3.fileName("letters.txt"); // Tabela de Letras
		text4.fileName("abbrev.txt"); // Tabela de Abreviações
		text5.fileName("add.txt"); // Tabela de Sinônimos
		text6.fileName("supname.txt"); // Tabela de Supérfluos
		text7.fileName("tokens.txt"); // Tabela de Supressões
		text8.fileName("titles.txt"); // Tabela de Títulos

		// Associando os objetos de persistência aos objetos de equivalências e
		// tokens.
		equiv1.imp(text1); // Tabela de Nomes
		equiv2.imp(text2); // Tabela de Números
		equiv3.imp(text3); // Tabela de Letras
		equiv4.imp(text4); // Tabela de Abreviações
		equiv5.imp(text5); // Tabela de Sinônimos
		tok6.imp(text6); // Tabela de Supérfluos
		tok7.imp(text7); // Tabela de Supressões
		tok8.imp(text8); // Tabela de Títulos

		// Associando as equivalências e tokens aos objetos de fonetização.
		phon.abbreviationsTable(equiv4);
		phon.additionsTable(equiv5);
		phon.equivalencesTable(equiv1);
		phon.lettersTable(equiv3);
		phon.numbersTable(equiv2);
		phon.superfluousTable(tok6);

		abbreviator.titlesTable(tok8);
		abbreviator.tokensTable(tok7);

		// Associando ao phonetic o seu phoneticTransformer.
		phon.phonetic_transformer(phoneticTransformer);

		// Associando ao phonetician o abbreviator, codegenerator e phonetic.
		phonetician.theAbbreviator(abbreviator);
		phonetician.theCodeGenerator(codeGenerator);
		phonetician.thePhonetic(phon);

		// Inicializando o abbreviator e o phonetic para que seja
		// feita a abertura dos arquivos de dicionário.
		try {
			abbreviator.initialize();
		} catch (CORBAphonetic.AbbreviateError erro) {
			System.out.println(erro.message);
		}

		try {
			phon.initialize();
		} catch (CORBAphonetic.PhoneticError p) {
			System.out.println(p.message);
		}

	}

	public String fornetizarComDicionario(String texto) {
		String textoFonetizado = null;
		// Faz com que o phonetic execute a fonetização e mostre o resultado em
		// jTextField6.
		try {
			textoFonetizado = phon.executePhonetic(texto);
		} catch (CORBAphonetic.PhoneticError erro) {
			erro.printStackTrace();
			System.out.println(erro.message);
		}
		return textoFonetizado;
	}

	public String fornetizarSemDicionario(String texto) {
		String textoFonetizado = null;
		// Faz com que o phonetic execute a fonetização e mostre o resultado em
		// jTextField6.
		try {
			textoFonetizado = phoneticTransformer.phoneticTransformation(texto);
		} catch (Exception erro) {
			erro.printStackTrace();
			System.out.println(erro.getMessage());
		}
		return textoFonetizado;
	}

	public String abrevitar(String texto, short numeroMaximoNomes,
			short tamanhoMaximoPalavraAbreviada,
			CORBAphonetic.OrientationOption orientacao) {
		String textoAbreviado = null;

		// Configura o abbreviator.
		// Especifica o número máximo de nomes que a palavra abreviada conterá.
		abbreviator.maxLength(tamanhoMaximoPalavraAbreviada);

		// Especifica o o tamanho máximo da palavra abreviada.
		abbreviator.maxNumOfNames(numeroMaximoNomes);

		// Informa ao abbreviator qual a orientação que será usada.
		abbreviator.orientation(orientacao);

		try {
			textoAbreviado = abbreviator.abbreviate(texto);
		} catch (AbbreviateError e) {

			e.printStackTrace();
		}

		return textoAbreviado;
	}

	public CORBAphonetic.CodeFields geradorCodigo(String texto) {
		// Faz com que o phonetician gere um código identificador para um texto
		// dado.
		try {
			CORBAphonetic.CodeFields c = phonetician.generateCode(texto,
					CORBAphonetic.PhoneticianOption.usePhoneticAndAbbreviator);
			// Joga para os TextFields os códigos gerados.
			return c;
		} catch (CORBAphonetic.PhoneticianError erro) {
			System.out.println(erro.message);
		}
		return null;
	}
}
