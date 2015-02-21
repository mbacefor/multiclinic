package br.com.linkedmed.view.manteragenda;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import br.com.linkedmed.business.ManterClinicaBC;
import br.com.linkedmed.business.ManterEventoBC;
import br.com.linkedmed.business.ManterProfissionalBC;
import br.com.linkedmed.business.PacienteBC;
import br.com.linkedmed.domain.Clinica;
import br.com.linkedmed.domain.Evento;
import br.com.linkedmed.domain.Paciente;
import br.com.linkedmed.domain.Profissional;
import br.com.linkedmed.util.FacesBean;
import br.gov.frameworkdemoiselle.stereotype.ViewController;

@ViewController
@javax.enterprise.context.SessionScoped
public class EditarAgenda extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "editarAgenda";
	public static final String CAMINHO_TELA = "/pages/manteragenda/editarAgenda.xhtml";

	private Profissional profissional;
	private List<Profissional> listaProfissionais;
	private List<Paciente> listaPacientes;
	private Clinica clinica;
	private List<Clinica> listaClinicas;
	private List<Evento> eventos;

	@Inject
	private ManterEventoBC manterEventoBC;
	@Inject
	private ManterClinicaBC manterClinicaBC;
	@Inject
	private ManterProfissionalBC manterProfissionalBC;
	@Inject
	private PacienteBC pacienteBC;

	private ScheduleModel eventModel = new DefaultScheduleModel();
	private EventoAtendimento event = new EventoAtendimento();

	public void onDateSelect(SelectEvent e) {
		Date date = (Date) e.getObject();
		event = new EventoAtendimento("Teste evento" + date, date, date);

	}

	public void onEventSelect(SelectEvent e) {
		System.out.println(e.toString());
		event = (EventoAtendimento) e.getObject();
	}

	public void addEvent() {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);
		event = new EventoAtendimento();
	}

	public String filtar() {
		String retorno = null;
		eventos = manterEventoBC.obterTodos();
		return retorno;
	}

	/**
	 * Metodo que inicia a nova clínica
	 * 
	 * @return
	 */
	public String prepararEditar() {
		String retorno = null;
		try {
			listaClinicas = manterClinicaBC.obterTodos();
			listaProfissionais = manterProfissionalBC.obterTodos();
			listaPacientes = pacienteBC.obterTodos();
			retorno = EditarAgenda.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public void delEvent() {
		eventModel.deleteEvent(event);
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public EventoAtendimento getEvent() {
		return event;
	}

	public void setEvent(EventoAtendimento event) {
		this.event = event;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public List<Profissional> getListaProfissionais() {
		return listaProfissionais;
	}

	public void setListaProfissionais(List<Profissional> listaProfissionais) {
		this.listaProfissionais = listaProfissionais;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Clinica> getListaClinicas() {
		return listaClinicas;
	}

	public void setListaClinicas(List<Clinica> listaClinicas) {
		this.listaClinicas = listaClinicas;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
}
