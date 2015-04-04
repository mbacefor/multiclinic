package br.com.linkedmed.view.manteragenda;

import java.util.ArrayList;
import java.util.Calendar;
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
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.util.FacesBean;
import br.com.linkedmed.view.geral.IndexClinicasMB;
import br.com.linkedmed.view.manterclinica.ListarClinicaMB;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

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
	private List<Profissional> listaProfissionaisFiltro;
	private List<Profissional> listaProfissionais;
	private List<Paciente> listaPacientes;
	private Clinica clinica;
	private List<Clinica> listaClinicas;
	private List<Evento> eventos;

	private Boolean exibirDialog = false;

	@Inject
	private ManterEventoBC manterEventoBC;
	@Inject
	private ManterClinicaBC manterClinicaBC;
	@Inject
	private ManterProfissionalBC manterProfissionalBC;
	@Inject
	private PacienteBC pacienteBC;
	@Inject
	private IndexClinicasMB indexClinicasMB;

	private ScheduleModel eventModel = new DefaultScheduleModel();
	private EventoAtendimento event = new EventoAtendimento();

	public void onDateSelect(SelectEvent e) {
		Date date = (Date) e.getObject();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, +30);
		event = new EventoAtendimento("", date, calendar.getTime());
		if (listaClinicas != null && listaClinicas.size() == 1)
			event.getEvento().setClinica(listaClinicas.get(0));
		if (listaProfissionais != null && listaProfissionais.size() == 1)
			event.getEvento().setProfissional(listaProfissionais.get(0));

	}

	public void onEventSelect(SelectEvent e) {
		System.out.println(e.toString());
		event = (EventoAtendimento) e.getObject();
	}

	/**
	 * Adiciona um novo evento
	 * 
	 * @throws Exception
	 */
	@Transactional
	public void addEvent() throws Exception {
		event.setTitle(" Paciente: "
				+ event.getEvento().getPaciente().getNome());
		if (event.getId() == null) {
			try {
				salvarEvento(event.getEvento());
				eventModel.addEvent(event);
			} catch (Exception e) {
				error(e.getMessage());
				throw e;
			}

		} else
			try {
				salvarEvento(event.getEvento());
				eventModel.updateEvent(event);
			} catch (Exception e) {
				error(e.getMessage());
			}

		event = new EventoAtendimento();

	}

	/**
	 * Adiciona um novo evento
	 * 
	 * @throws Exception
	 */
	@Transactional
	public String addEventAction() throws Exception {
		event.setTitle(" Paciente: "
				+ event.getEvento().getPaciente().getNome());
		if (event.getId() == null) {
			try {
				salvarEvento(event.getEvento());
				eventModel.addEvent(event);
			} catch (Exception e) {
				error(e.getMessage());
				throw e;
			}

		} else
			try {
				salvarEvento(event.getEvento());
				eventModel.updateEvent(event);
			} catch (Exception e) {
				error(e.getMessage());
			}

		// event = new EventoAtendimento();
		info("Evento Salvo com sucesso!");
		return null;
	}

	public String filtrar() {
		String retorno = null;

		if (profissional != null) {
			profissional = manterProfissionalBC.load(profissional.getId());
			eventos = profissional.getEventosProfissional();
			if (listaProfissionais == null) {
				listaProfissionais = new ArrayList<Profissional>();
			}
			listaProfissionais.clear();
			listaProfissionais.add(profissional);
		} else
			eventos = new ArrayList<Evento>();

		eventModel.clear();

		for (Evento evento : eventos) {
			EventoAtendimento atendimento = new EventoAtendimento(evento);
			eventModel.addEvent(atendimento);
		}

		listaPacientes = pacienteBC.obterTodosAtivos(Paciente.class);

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
			if (indexClinicasMB.getClinicaAtual() != null) {
				listaClinicas = new ArrayList<Clinica>();
				listaClinicas.add(indexClinicasMB.getClinicaAtual());
			} else
				listaClinicas = manterClinicaBC.obterTodos();
			listaProfissionaisFiltro = manterProfissionalBC
					.obterTodosAtivos(Profissional.class);
			listaPacientes = new ArrayList<Paciente>();
			retorno = EditarAgenda.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que salva uma clínica
	 * 
	 * @return
	 */

	private void salvarEvento(Evento evento) {
		Usuario usuarioLogado = obterUsuarioLogado();
		manterEventoBC.salvar(evento, usuarioLogado);
	}

	/**
	 * Metodo que salva uma clínica
	 * 
	 * @return
	 */

	private void excluirEvento(Evento evento) {
		manterEventoBC.excluir(evento);
	}

	/**
	 * Metodo que salva uma clínica
	 * 
	 * @return
	 */
	@Transactional
	public String salvar() {
		String retorno = null;
		try {

			Usuario usuarioLogado = obterUsuarioLogado();
			manterClinicaBC.salvar(clinica, usuarioLogado);
			ListarClinicaMB listarClinicaMB = (ListarClinicaMB) getBean(ListarClinicaMB.NOME_MANAGER_BEAN);
			List<Clinica> lista = manterClinicaBC.obterTodos();
			listarClinicaMB.setLista(lista);
			retorno = ListarClinicaMB.CAMINHO_TELA;
			info("Clinica salva com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Exclui um evento
	 */

	public void delEvent() {
		eventModel.deleteEvent(event);
		try {
			excluirEvento(event.getEvento());
		} catch (Exception e) {
			error(e.getMessage());
		}
	}

	public List<Paciente> completePaciente(String query) {
		List<Paciente> allPacientes = pacienteBC.buscaFoneticaNome(query);
		return allPacientes;
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

	public Boolean getExibirDialog() {
		return exibirDialog;
	}

	public void setExibirDialog(Boolean exibirDialog) {
		this.exibirDialog = exibirDialog;
	}

	public List<Profissional> getListaProfissionaisFiltro() {
		return listaProfissionaisFiltro;
	}

	public void setListaProfissionaisFiltro(
			List<Profissional> listaProfissionaisFiltro) {
		this.listaProfissionaisFiltro = listaProfissionaisFiltro;
	}
}
