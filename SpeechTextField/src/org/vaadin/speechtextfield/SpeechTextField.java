package org.vaadin.speechtextfield;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.TextField;

/**
 * @author Vinod Damodaran < i-Human Patients >
 */
@SuppressWarnings("serial")
public class SpeechTextField extends AbstractExtension {
	public static void extend(TextField field) {
        new SpeechTextField().extend((AbstractClientConnector) field);
    }
}