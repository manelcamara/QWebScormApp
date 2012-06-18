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

import java.util.ArrayList;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * The Class PPregunta: pantalla que presenta a l'usuari una pregunta en un qüestionari
 * d'autoavaluació. Els elements visualitzats estan definits a la classe PreguntaComposite.
 */
public class PPregunta extends DialogBox {
	private Mensajes m = null;
	private int idPregunta;
	private Cuestionario cuestionario;
	private Pregunta pregunta;
	private String pathImagen = "";
	private Image imagen;
	private PreguntaComposite pc;
	
	/** The respuestas. */
	ArrayList<RadioButton> respuestas;
	
	/** The num respuestas. */
	int numRespuestas;
	
	/** The respuesta elegida. */
	int respuestaElegida = -1;
	private InformeAutoevaluacion informe;
	
	/**
	 * Instantiates a new p pregunta.
	 *
	 * @param cuestionario the cuestionario
	 */
	public PPregunta(final Cuestionario cuestionario) {
		setHTML(cuestionario.getTituloCuestionario());
		m = Util.getMensajes(cuestionario.getIdioma());
		idPregunta = 0;
		this.cuestionario = cuestionario;
		informe = new InformeAutoevaluacion(cuestionario);
		pc = new PreguntaComposite(cuestionario);
		imagen = pc.getImagen();
		actualizarPreguntaComposite();
		setWidget(pc);
		pc.setSize("100%", "100%");
		Button continuar = pc.getBotonContinuar();
		continuar.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (respuestaElegida == -1){
					Window.alert(m.obligatorioelegirrespuesta());
				} else {
					informe.actualizarInforme(idPregunta, respuestaElegida);
					idPregunta +=1;
					actualizarPreguntaComposite();
				}
			}
		});

		RootPanel.get().add(this);
	}
	private void actualizarPreguntaComposite() {
		if (idPregunta==0){
			respuestaElegida = -1;
			pregunta = cuestionario.getPregunta(idPregunta);
			int numPregunta = idPregunta + 1;
			pc.getPreguntaXdeY().setText(m.pregunta() + " " + numPregunta + " / " + cuestionario.getNumeroDePreguntas());
			pc.getLabelNumPregunta().setText("" + idPregunta);
			pc.getTextAreaTextoPregunta().setText(pregunta.getTextoPregunta());
			pathImagen = cuestionario.getPregunta(idPregunta).getImagenPregunta();
			if (!pathImagen.equals("")){
				imagen.setUrl(pathImagen);
			}
			actualizarRespuestas(idPregunta);
		} else if (idPregunta <cuestionario.getNumeroDePreguntas()){
				respuestaElegida = -1;
				RootPanel.get().remove(this);
				pregunta = cuestionario.getPregunta(idPregunta);
				int numPregunta = idPregunta + 1;
				pc.getPreguntaXdeY().setText(m.pregunta() + " " + numPregunta + " / " + cuestionario.getNumeroDePreguntas());
				pc.getLabelNumPregunta().setText("" + idPregunta);
				pc.getTextAreaTextoPregunta().setText(pregunta.getTextoPregunta());
				pathImagen = cuestionario.getPregunta(idPregunta).getImagenPregunta();
				if (!pathImagen.equals("")){
					imagen.setUrl(pathImagen);
				}
				actualizarRespuestas(idPregunta);
				setWidget(pc);
				RootPanel.get().add(this);
		} else {
				RootPanel.get().remove(this);
				RootPanel.get().add(new PInforme(cuestionario, informe));
		}
		
	}
	private void actualizarRespuestas(int idPregunta){
		ClickHandler handlerRespuesta = new ClickHandler(){
			public void onClick(ClickEvent event) {
				respuestaElegida = Integer.parseInt("" + ((RadioButton)event.getSource()).getFormValue());
			}};
		VerticalPanel vpr = pc.getVerticalPanelRespuestas();
		vpr.clear();
		numRespuestas = cuestionario.getPregunta(idPregunta).getNumeroDeRespuestas();
		respuestas = new ArrayList<RadioButton>();
		for (int i=0; i<numRespuestas; i++){
			String textoRespuesta = cuestionario.getPregunta(idPregunta).getRespuesta(i).getTextoRespuesta();
			RadioButton respuesta = new RadioButton("grupoRespuestas", textoRespuesta);
			respuesta.setFormValue("" + i);
			respuesta.addClickHandler(handlerRespuesta);
			respuestas.add(respuesta);
			vpr.add(respuestas.get(i));
		}
	}
}
