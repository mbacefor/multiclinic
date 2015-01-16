package br.com.linkedmed.util;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.Id;

@FacesConverter("defaultConverterJSF2")
public class DefaultConverterJSF2 implements Converter {

	private static Hashtable<String, Object> mapaObjetos = new Hashtable<String, Object>();

	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		if (value != null) {
			Object retorno = this.mapaObjetos.get(value); 
			return retorno;
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {

		if (value != null && !"".equals(value)) {
			String retorno = value.getClass().getCanonicalName() + getId(value);
			this.mapaObjetos.put(retorno,
					value);

			return retorno;
		}

		return (String) value;
	}

	private String getId(Object object) {
		String nomeId = getNomeCampoId(object.getClass());
		return buscaCampo(object.getClass(), object, nomeId).toString();
	}

	protected void addAttribute(UIComponent component, Object o) {
		this.getAttributesFrom(component).put(getId(o), o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

	public static String getNomeCampoId(Class classe) {
		if (classe != Object.class) {
			Field[] campos = classe.getDeclaredFields();
			for (Field field : campos) {
				if (field.isAnnotationPresent(Id.class)) {
					field.setAccessible(true);
					try {
						return field.getName();
					} catch (Exception e) {
						e.printStackTrace();

					}
				}
			}
		}
		if (classe.getSuperclass() != Object.class) {
			return getNomeCampoId(classe.getSuperclass());
		}
		return null;
	}

	public static Object buscaCampo(Class classe, Object t, String nomeCampo) {
		if (classe != Object.class) {
			Field[] campos = classe.getDeclaredFields();
			for (Field field : campos) {
				if (field.getName().equals(nomeCampo)) {
					field.setAccessible(true);
					try {
						return field.get(t);
					} catch (Exception e) {
						e.printStackTrace();

					}
				}
			}
		}
		if (classe.getSuperclass() != Object.class) {
			return buscaCampo(classe.getSuperclass(), t, nomeCampo);
		}
		return null;
	}
}