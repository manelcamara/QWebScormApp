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

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Image;

/**
 * The Class PreguntaComposite: classe que defineix els elements que conformen la UI
 * d'una pregunta en un qüestionari d'autoavaluació
 */
public class PreguntaComposite extends Composite {
	private Mensajes m = null;
	private int idPregunta;
	@SuppressWarnings("unused")
	private Cuestionario cuestionario;
	@SuppressWarnings("unused")
	private Pregunta pregunta;
	private Label numPregunta;
	private TextArea textoPregunta;
	private Button continuar;
	private Label preguntaXdeY;
	private VerticalPanel verticalPanelRespuestas;
	private Image imagen;

	/**
	 * Instantiates a new pregunta composite.
	 *
	 * @param cuestionario the cuestionario
	 */
	public PreguntaComposite(Cuestionario cuestionario) {
		m = Util.getMensajes(cuestionario.getIdioma());
		idPregunta = 0;
		this.cuestionario = cuestionario;
		this.pregunta = cuestionario.getPregunta(idPregunta);
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setHeight("218px");
		Pregunta pregunta = cuestionario.getPregunta(idPregunta);

		numPregunta = new Label("" + pregunta.getIdPregunta());
		numPregunta.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		int numeroPregunta = idPregunta+1;
		preguntaXdeY = new Label(m.pregunta() + " " + numeroPregunta + " / " + cuestionario.getNumeroDePreguntas());
		preguntaXdeY.setStyleName("gwt-Label-Titulo");
		preguntaXdeY.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(preguntaXdeY);
		
		textoPregunta = new TextArea();
		textoPregunta.setEnabled(false);
		textoPregunta.setText(pregunta.getTextoPregunta());
		textoPregunta.setReadOnly(true);
		textoPregunta.setAlignment(TextAlignment.CENTER);
		verticalPanel.add(textoPregunta);
		textoPregunta.setWidth("449px");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("459px");
		
		imagen = new Image((String) null);
		horizontalPanel_1.add(imagen);
		
		Label lblRespuestas = new Label(m.respuestas());
		verticalPanel.add(lblRespuestas);
		
		verticalPanelRespuestas = new VerticalPanel();
		verticalPanel.add(verticalPanelRespuestas);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("458px");
		
		Button btnNewButton_1 = new Button(m.salir());
		horizontalPanel.add(btnNewButton_1);
		
		continuar = new Button(m.continuar());
		horizontalPanel.add(continuar);
		
	}
	
	/**
	 * Gets the imagen.
	 *
	 * @return the imagen
	 */
	public Image getImagen() {
		return imagen;
	}
	
	/**
	 * Gets the boton continuar.
	 *
	 * @return the boton continuar
	 */
	public Button getBotonContinuar(){
		return continuar;
	}
	
	/**
	 * Gets the text area texto pregunta.
	 *
	 * @return the text area texto pregunta
	 */
	public TextArea getTextAreaTextoPregunta(){
		return textoPregunta;
	}
	
	/**
	 * Gets the label num pregunta.
	 *
	 * @return the label num pregunta
	 */
	public Label getLabelNumPregunta(){
		return numPregunta;
	}
	
	/**
	 * Gets the pregunta xde y.
	 *
	 * @return the pregunta xde y
	 */
	public Label getPreguntaXdeY(){
		return preguntaXdeY;
	}
	
	/**
	 * Gets the vertical panel respuestas.
	 *
	 * @return the vertical panel respuestas
	 */
	public VerticalPanel getVerticalPanelRespuestas(){
		return verticalPanelRespuestas;
	}

}
