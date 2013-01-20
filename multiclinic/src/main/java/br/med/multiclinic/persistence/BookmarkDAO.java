package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.med.multiclinic.domain.Bookmark;

@PersistenceController
public class BookmarkDAO extends JPACrud<Bookmark, Long> {
	
	private static final long serialVersionUID = 1L;
	
}
