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

/**
 * The Class InformeAutoevaluacion: classe que encapsula la lògica de negoci
 *  d'un informe de resultats en un qüestionari d'autoavaluació
 */
public class InformeAutoevaluacion {
	private Cuestionario cuestionario;
	private int respuestasCorrectas = 0;
	private int respuestasIncorrectas = 0;
	private ArrayList<Integer> arrayResultados = new ArrayList<Integer>();
	private Mensajes m = null;
	
	/**
	 * Instantiates a new informe autoevaluacion.
	 *
	 * @param cuestionario the cuestionario
	 */
	public InformeAutoevaluacion (Cuestionario cuestionario){
		this.cuestionario = cuestionario;
		m = Util.getMensajes(cuestionario.getIdioma());
	}
	
	/**
	 * Actualizar informe.
	 *
	 * @param idPregunta the id pregunta
	 * @param idRespuestaElegida the id respuesta elegida
	 */
	public void actualizarInforme(int idPregunta, int idRespuestaElegida){
		arrayResultados.add(idRespuestaElegida);
		if (cuestionario.getPregunta(idPregunta).getRespuesta(idRespuestaElegida).isTipoRespuesta()){
			respuestasCorrectas +=1;
		} else {
			respuestasIncorrectas +=1;
		}
	}
	
	/**
	 * Gets the resultados.
	 *
	 * @return the resultados
	 */
	public String getResultados(){
		return m.respuestascorrectas() + " " + respuestasCorrectas + " - " + m.respuestasincorrectas() + " " + respuestasIncorrectas;
	}
	
	/**
	 * Gets the informe.
	 *
	 * @return the informe
	 */
	public String getInforme(){
		String informe = "";
		informe = "<div><font color='blue'>" + getResultados() + "</font></div>";
		for (int i=0; i<cuestionario.getNumeroDePreguntas(); i++){
			Pregunta pregunta = cuestionario.getPregunta(i);
			informe = informe + "<div>" + pregunta.getTextoPregunta() + "</div>";
			informe = informe + "<div><img src=" + pregunta.getImagenPregunta() + "></div>";
			for (int j=0; j<cuestionario.getPregunta(i).getNumeroDeRespuestas();j++){
				String color = "";
				int respuestaElegida = arrayResultados.get(i);
				String cadenaRespuesta = cuestionario.getPregunta(i).getRespuesta(j).getTextoRespuesta();
				if (respuestaElegida == j && !cuestionario.getPregunta(i).getRespuesta(respuestaElegida).isTipoRespuesta()) color = "red";
				if (cuestionario.getPregunta(i).getRespuesta(j).isTipoRespuesta()){
					color = "green";
				} 
				informe = informe + "<div><font color=" + color +">" + cadenaRespuesta + "</font></html></div>";
			}
		}
		return informe;
	}

}
