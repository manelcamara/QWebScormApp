/*
    Copyright (C) 2012 Manel C�mara

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
 * The Class Pregunta: classe bean que encapsula un pregunta (autoavaluaci�) o
 * una pantalla (tutorial). Cont� una colecci� de respostes (si autoavaluaci�).
 */
public class Pregunta {
	
	private String textoPregunta;
	private String textoCortoPregunta;
	private String imagenPregunta = "";
	private int idPregunta;
	private ArrayList<Respuesta> listaRespuestas =  new ArrayList<Respuesta>();
	
	/**
	 * Instantiates a new pregunta.
	 */
	public Pregunta()
	{
		
	}

	/**
	 * Gets the texto pregunta.
	 *
	 * @return the texto pregunta
	 */
	public String getTextoPregunta() {
		return textoPregunta;
	}

	/**
	 * Sets the texto pregunta.
	 *
	 * @param textoPregunta the new texto pregunta
	 */
	public void setTextoPregunta(String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	/**
	 * Gets the lista respuestas.
	 *
	 * @return the lista respuestas
	 */
	public ArrayList<Respuesta> getListaRespuestas() {
		return listaRespuestas;
	}

	/**
	 * Sets the respuestas.
	 *
	 * @param listaRespuestas the new respuestas
	 */
	public void setRespuestas(ArrayList<Respuesta> listaRespuestas) {
		this.listaRespuestas = listaRespuestas;
	}
	
	/**
	 * Adds the respuesta.
	 *
	 * @param respuesta the respuesta
	 */
	public void addRespuesta(Respuesta respuesta){
		listaRespuestas.add(respuesta);
	}
	
	/**
	 * Removes the respuesta.
	 *
	 * @param idRespuesta the id respuesta
	 */
	public void removeRespuesta(int idRespuesta){
		listaRespuestas.remove(idRespuesta);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return getTextoPregunta();
	}

	/**
	 * Gets the id pregunta.
	 *
	 * @return the id pregunta
	 */
	public int getIdPregunta() {
		return idPregunta;
	}

	/**
	 * Sets the id pregunta.
	 *
	 * @param idPregunta the new id pregunta
	 */
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	
	/**
	 * Gets the numero de respuestas.
	 *
	 * @return the numero de respuestas
	 */
	public int getNumeroDeRespuestas(){
		return listaRespuestas.size();
	}
	
	/**
	 * Gets the respuesta.
	 *
	 * @param idRespuesta the id respuesta
	 * @return the respuesta
	 */
	public Respuesta getRespuesta(int idRespuesta){
		return getListaRespuestas().get(idRespuesta);
	}

	/**
	 * Gets the imagen pregunta.
	 *
	 * @return the imagen pregunta
	 */
	public String getImagenPregunta() {
		return "recursos/" + imagenPregunta;
	}

	/**
	 * Sets the imagen pregunta.
	 *
	 * @param imagenPregunta the new imagen pregunta
	 */
	public void setImagenPregunta(String imagenPregunta) {
		this.imagenPregunta = imagenPregunta;
	}

	/**
	 * Gets the texto corto pregunta.
	 *
	 * @return the texto corto pregunta
	 */
	public String getTextoCortoPregunta() {
		return textoCortoPregunta;
	}

	/**
	 * Sets the texto corto pregunta.
	 *
	 * @param textoCortoPregunta the new texto corto pregunta
	 */
	public void setTextoCortoPregunta(String textoCortoPregunta) {
		this.textoCortoPregunta = textoCortoPregunta;
	}

}
