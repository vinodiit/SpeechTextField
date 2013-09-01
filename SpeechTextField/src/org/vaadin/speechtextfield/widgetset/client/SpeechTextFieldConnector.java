package org.vaadin.speechtextfield.widgetset.client;

import com.google.gwt.user.client.Element;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.VTextField;
import com.vaadin.shared.ui.Connect;

import org.vaadin.speechtextfield.SpeechTextField;

/**
 * @author Corey Cerovsek < i-Human Patients >
 */
@SuppressWarnings("serial")
@Connect(SpeechTextField.class)
public class SpeechTextFieldConnector extends AbstractExtensionConnector {

	private VTextField getWidget(ServerConnector parent) {
	    return (VTextField) ((ComponentConnector) parent).getWidget();
	}

	@Override
	protected void extend(ServerConnector target) {
	    final Element element = getWidget(target).getElement();
	    element.setAttribute("x-webkit-speech", "x-webkit-speech");
	    addOnwebkitspeechchangeHandler(element);
	}
	
	private native void addOnwebkitspeechchangeHandler(Element element)
	  /*-{
	    var connector = this; 
	    element.onwebkitspeechchange = function() {
	      connector.@org.vaadin.speechtextfield.widgetset.client.SpeechTextFieldConnector::onWebkitspeechchange()();
	    };
	  }-*/;

	public void onWebkitspeechchange() {
	    getWidget(getParent()).valueChange(false);
	}
}



