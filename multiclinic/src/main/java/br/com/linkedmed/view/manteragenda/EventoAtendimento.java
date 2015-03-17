/**
 * 
 */
package br.com.linkedmed.view.manteragenda;

import java.util.Date;

import org.primefaces.model.DefaultScheduleEvent;

import br.com.linkedmed.domain.Evento;

/**
 * @author mbacefor
 * 
 */
public class EventoAtendimento extends DefaultScheduleEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Evento evento;

	public EventoAtendimento() {
		super();
		// TODO Auto-generated constructor stub
		evento = new Evento();

	}

	public EventoAtendimento(String title, Date start, Date end, boolean allDay) {
		super(title, start, end, allDay);
		// TODO Auto-generated constructor stub
		evento = new Evento();
		evento.setDataInicio(start);
		evento.setDataFim(end);
		evento.setNome(title);
	}

	public EventoAtendimento(String title, Date start, Date end,
			String styleClass) {
		super(title, start, end, styleClass);
		// TODO Auto-generated constructor stub
		evento = new Evento();
		evento.setDataInicio(start);
		evento.setDataFim(end);
		evento.setNome(title);
		evento.setEstilo(styleClass);
	}

	public EventoAtendimento(String title, Date start, Date end) {
		super(title, start, end);
		// TODO Auto-generated constructor stub
		evento = new Evento();
		evento.setDataInicio(start);
		evento.setDataFim(end);
		evento.setNome(title);
		evento.setAtivo(true);
	}

	public EventoAtendimento(Evento evento) {

		if (evento != null) {
			if (evento.getNome() != null)
				setTitle(evento.getNome());
			if (evento.getDataInicio() != null)
				setStartDate(evento.getDataInicio());
			if (evento.getDataFim() != null)
				setEndDate(evento.getDataFim());
			if (evento.getEstilo() != null)
				setStyleClass(evento.getEstilo());
			if (evento.getAtivo() != null)
				setEditable(evento.getAtivo());
			if (evento.getDescricao() != null)
				setDescription(evento.getDescricao());
			setEvento(evento);
		}

	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public void setDescription(String description) {
		if (evento != null)
			evento.setDescricao(description);
		super.setDescription(description);
	}

	@Override
	public void setEditable(boolean editable) {
		if (evento != null)
			evento.setAtivo(editable);
		super.setEditable(editable);
	}

	@Override
	public void setEndDate(Date endDate) {
		if (evento != null)
			evento.setDataFim(endDate);
		super.setEndDate(endDate);
	}

	@Override
	public void setStartDate(Date startDate) {
		if (evento != null)
			evento.setDataInicio(startDate);
		super.setStartDate(startDate);
	}

	@Override
	public void setStyleClass(String styleClass) {
		if (evento != null)
			evento.setEstilo(styleClass);
		super.setStyleClass(styleClass);
	}

	@Override
	public void setTitle(String title) {
		if (evento != null)
			evento.setNome(title);
		super.setTitle(title);
	}
}
