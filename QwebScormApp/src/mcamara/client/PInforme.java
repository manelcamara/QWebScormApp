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


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The Class PInforme: pantalla que presenta a l'usuari un informe de resultats després
 * de finalitzar un qüestionari d'autoavaluació. Els elements visualitzats estan definits
 * a la classe InformeComposite.
 */
public class PInforme extends DialogBox {
	private Mensajes m = null;

	/**
	 * Instantiates a new p informe.
	 *
	 * @param cuestionario the cuestionario
	 * @param informe the informe
	 */
	public PInforme(Cuestionario cuestionario, InformeAutoevaluacion informe) {
		String idioma = cuestionario.getIdioma();
		m = Util.getMensajes(idioma);
		setHTML(m.informederesultados());
		InformeComposite informeComposite = new InformeComposite(idioma);
		informeComposite.getTitulo().setText(cuestionario.getTituloCuestionario());
		//informeComposite.getResultados().setText(informe.getResultados());
		ClickHandler salirHandler = new ClickHandler(){
			public void onClick(ClickEvent event) {
				vaciaBrowser();
				
			}};
		informeComposite.getSalir().addClickHandler(salirHandler);
		VerticalPanel panelContenido = informeComposite.getPanelContenido();
		HTML message = new HTML(informe.getInforme());
		panelContenido.add(message);
		setWidget(informeComposite);
		informeComposite.setSize("100%", "100%");
	}

	private void vaciaBrowser() {
		RootPanel.get().remove(this);		
	}
}
