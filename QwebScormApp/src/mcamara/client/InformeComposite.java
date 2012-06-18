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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;

/**
 * The Class InformeComposite: classe que defineix els elements que conformen la 
 * UI d'una pantalla PInforme
 */
public class InformeComposite extends Composite {
	private Label titulo;
	private Button salir;
	private VerticalPanel contenido;
	private Mensajes m = null;

	/**
	 * Instantiates a new informe composite.
	 *
	 * @param idioma the idioma
	 */
	public InformeComposite(String idioma) {
		
		m = Util.getMensajes(idioma);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		titulo = new Label(m.titulo());
		titulo.setStyleName("gwt-Label-Titulo");
		titulo.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(titulo);
		
		contenido = new VerticalPanel();
		contenido.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(contenido);
		contenido.setWidth("458px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("459px");
		
		salir = new Button(m.salir());
		horizontalPanel.add(salir);
	}

	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public Label getTitulo() {
		return titulo;
	}

	/**
	 * Gets the panel contenido.
	 *
	 * @return the panel contenido
	 */
	public VerticalPanel getPanelContenido(){
		return contenido;
	}
	
	/**
	 * Gets the salir.
	 *
	 * @return the salir
	 */
	public Button getSalir(){
		return salir;
	}

}
