/*
    Copyright (C) 2012 Manel Cámara

    This file is part of Q?WebEditor and/or Q?WebScormApp.
    
    Q?WebEditor&Q?WebScormApp is free software: you can redistribute it 
    and/or modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation, either version 3 
    of the License, or any later version.

    Q?WebEditor&Q?WebScormApp is distributed in the hope that it will 
    be useful, but WITHOUT ANY WARRANTY; without even the implied 
    warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
     
    See the GNU General Public License for more details at
	http://www.gnu.org/licenses/#GPL
*/
package mcamara.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * The Class PresentacionComposite: classe que defineix els elements que conformen la UI
 * de la presentació d'un qüestionari (autoavaluació o tutorial)
 */
public class PresentacionComposite extends Composite {
	private Mensajes m = null;
	private Label label;
	private Label label_1;
	
	/**
	 * Instantiates a new presentacion composite.
	 *
	 * @param cuestionario the cuestionario
	 * @param padre the padre
	 */
	public PresentacionComposite(final Cuestionario cuestionario, final PPresentacion padre) {
		
		m = Util.getMensajes(cuestionario.getIdioma());
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setHeight("218px");
		
		TextArea textArea = new TextArea();
		textArea.setEnabled(false);
		textArea.setText(cuestionario.getPresentacionCuestionario());
		textArea.setReadOnly(true);
		textArea.setAlignment(TextAlignment.CENTER);
		verticalPanel.add(textArea);
		textArea.setWidth("449px");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		//horizontalPanel_2.setSpacing(3);
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel_2);
		horizontalPanel_2.setWidth("458px");
		
		label = new Label("New label");
		label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		label.setText(m.totalpreguntas());
		horizontalPanel_2.add(label);
		//label.setSize("50%", "100%");
		
		label_1 = new Label("New label");
		label_1.setText("" + cuestionario.getNumeroDePreguntas());
		horizontalPanel_2.add(label_1);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("458px");
		
		Button btnNewButton_1 = new Button(m.salir());
		horizontalPanel.add(btnNewButton_1);
		
		Button btnNewButton = new Button(m.empezar());
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				RootPanel.get().remove(padre);
				new PPregunta(cuestionario);
			}
		});
		horizontalPanel.add(btnNewButton);
	}
}
