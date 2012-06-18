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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class PTutorial: pantalla que presenta a l'usuari una pantalla en un tutorial.
 * Els elements visualitzats estan definits a la classe TutorialComposite.
 */
public class PTutorial extends DialogBox {
	private Mensajes m = null;
	private Cuestionario cuestionario;
	private TutorialComposite tutorialComposite;
	private int idPregunta;
	private Button continuar;
	
	/**
	 * Instantiates a new p tutorial.
	 *
	 * @param cuestionario the cuestionario
	 * @param idPregunta the id pregunta
	 */
	public PTutorial(final Cuestionario cuestionario, int idPregunta) {
		m = Util.getMensajes(cuestionario.getIdioma());
		setHTML(m.tutorial() + " " + cuestionario.getTituloCuestionario());
		this.cuestionario = cuestionario;
		this.idPregunta = idPregunta;
		tutorialComposite = new TutorialComposite(cuestionario.getIdioma());
		setWidget(tutorialComposite);
		tutorialComposite.setPixelSize(500, 300);
		tutorialComposite.getTitulo().setText(cuestionario.getTituloCuestionario());
		tutorialComposite.getExplicacion().setText(cuestionario.getPresentacionCuestionario());
		construyeMenuPantallas();
		continuar = tutorialComposite.getContinuar();
		continuar.setText(m.continuar());
		continuar.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				actualizarPTutorialComposite();
			}});
	}

	private void actualizarPTutorialComposite() {
			RootPanel.get().remove(this);
			idPregunta +=1;
			if (idPregunta < cuestionario.getNumeroDePreguntas()){
				construyeMenuPantallas();
				tutorialComposite.getTitulo().setText(cuestionario.getPregunta(idPregunta).getTextoCortoPregunta());
				tutorialComposite.getImage().setUrl(cuestionario.getPregunta(idPregunta).getImagenPregunta());
				tutorialComposite.getExplicacion().setText(cuestionario.getPregunta(idPregunta).getTextoPregunta());
				RootPanel.get().add(this);
			} else {
				Window.alert(m.finaldeltutorial());
				RootPanel.get().add(new PTutorial(cuestionario, -1));
			}
	}
	private void construyeMenuPantallas(){
		tutorialComposite.getMenuPantallas().clear();
		Label tituloPantalla = null;
		int numPantallas = cuestionario.getNumeroDePreguntas();
		for (int i=0; i < numPantallas; i++){
			tituloPantalla = new Label(cuestionario.getPregunta(i).getTextoCortoPregunta());
			tutorialComposite.getMenuPantallas().add(tituloPantalla);
			tituloPantalla.addClickHandler(new tituloPantallaHandler(i));
		}
	}
	private class tituloPantallaHandler implements ClickHandler{
		private int idPantalla;
		public tituloPantallaHandler(int idPantalla){
			this.idPantalla = idPantalla;
		}

		public void onClick(ClickEvent event) {
			idPregunta = idPantalla - 1;
			actualizarPTutorialComposite();
		}
		
	}

}
