package org.vaadin.speechtextfield;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("speechtextfield")
public class SpeechtextfieldUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = SpeechtextfieldUI.class, widgetset = "org.vaadin.speechtextfield.widgetset.SpeechtextfieldWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		TextField speechtf = new TextField();
	    SpeechTextField.extend(speechtf);
	    speechtf.setCaption("Speech TextField");
	    speechtf.setImmediate(true);
	    speechtf.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				Notification.show("ValueChanged: " + event.getProperty().getValue());
			}	    	
	    });
	    layout.addComponent(speechtf);
	}
}