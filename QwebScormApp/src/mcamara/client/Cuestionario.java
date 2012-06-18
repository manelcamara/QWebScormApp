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
 * The Class Cuestionario: classe bean que encapsula un qüestionari (autoavaluació o
 * tutorial). Conté una colecció de preguntes (autoavaluació) o pantalles (tutorial)
 */
public class Cuestionario {
	
	private String tituloCuestionario;
	private String presentacionCuestionario;
	private String tipo;
	private String idioma;
	private ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
	
	/**
	 * Instantiates a new cuestionario.
	 */
	public Cuestionario()
	{
		
	}
	
	/**
	 * Gets the titulo cuestionario.
	 *
	 * @return the titulo cuestionario
	 */
	public String getTituloCuestionario() {
		return tituloCuestionario;
	}
	
	/**
	 * Sets the titulo cuestionario.
	 *
	 * @param tituloCuestionario the new titulo cuestionario
	 */
	public void setTituloCuestionario(String tituloCuestionario) {
		this.tituloCuestionario = tituloCuestionario;
	}
	
	/**
	 * Gets the lista preguntas.
	 *
	 * @return the lista preguntas
	 */
	public ArrayList<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}
	
	/**
	 * Sets the lista preguntas.
	 *
	 * @param listaPreguntas the new lista preguntas
	 */
	public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}
	
	/**
	 * Adds the pregunta.
	 *
	 * @param pregunta the pregunta
	 */
	public void addPregunta(Pregunta pregunta){
		listaPreguntas.add(pregunta);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return getTituloCuestionario();
	}
	
	/**
	 * Gets the numero de preguntas.
	 *
	 * @return the numero de preguntas
	 */
	public int getNumeroDePreguntas(){
		return listaPreguntas.size();
	}
	
	/**
	 * Gets the pregunta.
	 *
	 * @param idPregunta the id pregunta
	 * @return the pregunta
	 */
	public Pregunta getPregunta(int idPregunta){
		return getListaPreguntas().get(idPregunta);
	}
	
	/**
	 * Removes the pregunta.
	 *
	 * @param idPregunta the id pregunta
	 */
	public void removePregunta(int idPregunta){
		listaPreguntas.remove(idPregunta);
	}

	/**
	 * Gets the presentacion cuestionario.
	 *
	 * @return the presentacion cuestionario
	 */
	public String getPresentacionCuestionario() {
		return presentacionCuestionario;
	}

	/**
	 * Sets the presentacion cuestionario.
	 *
	 * @param presentacionCuestionario the new presentacion cuestionario
	 */
	public void setPresentacionCuestionario(String presentacionCuestionario) {
		this.presentacionCuestionario = presentacionCuestionario;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the idioma.
	 *
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * Sets the idioma.
	 *
	 * @param idioma the new idioma
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
}
