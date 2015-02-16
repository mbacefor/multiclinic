package br.com.linkedmed.view.manteragenda;

import java.util.Date;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;

@ViewController
@javax.enterprise.context.SessionScoped
public class EditarAgenda extends AbstractPageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScheduleModel eventModel = new DefaultScheduleModel();
	private DefaultScheduleEvent event = new DefaultScheduleEvent();

	public void onDateSelect(SelectEvent e) {
		Date date = (Date) e.getObject();
		event = new DefaultScheduleEvent("Teste evento" + date, date, date);

	}

	public void onEventSelect(SelectEvent e) {
		System.out.println(e.toString());
		event = (DefaultScheduleEvent) e.getObject();
	}

	public void addEvent() {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);
		event = new DefaultScheduleEvent();
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

	public DefaultScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(DefaultScheduleEvent event) {
		this.event = event;
	}
}
