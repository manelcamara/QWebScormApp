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

import com.google.gwt.i18n.client.Messages;

/**
 * The Interface Mensajes: interface 'genèrica' que s'utilitza per a presentar
 * els missatges de l'aplicació
 */
public interface Mensajes extends Messages {
	
/**
 * Cuestionarionovalido.
 *
 * @return the string
 */
String cuestionarionovalido();

/**
 * Error.
 *
 * @return the string
 */
String error();

/**
 * Obligatorioelegirrespuesta.
 *
 * @return the string
 */
String obligatorioelegirrespuesta();

/**
 * Respuestas.
 *
 * @return the string
 */
String respuestas();

/**
 * Respuestascorrectas.
 *
 * @return the string
 */
String respuestascorrectas();

/**
 * Respuestasincorrectas.
 *
 * @return the string
 */
String respuestasincorrectas();

/**
 * Titulo.
 *
 * @return the string
 */
String titulo();

/**
 * Resultados.
 *
 * @return the string
 */
String resultados();

/**
 * Salir.
 *
 * @return the string
 */
String salir();

/**
 * Continuar.
 *
 * @return the string
 */
String continuar();

/**
 * Empezar.
 *
 * @return the string
 */
String empezar();

/**
 * Informederesultados.
 *
 * @return the string
 */
String informederesultados();

/**
 * Pregunta.
 *
 * @return the string
 */
String pregunta();

/**
 * Totalpreguntas.
 *
 * @return the string
 */
String totalpreguntas();

/**
 * Pantallainicialtutorial.
 *
 * @return the string
 */
String pantallainicialtutorial();

/**
 * Finaldeltutorial.
 *
 * @return the string
 */
String finaldeltutorial();

/**
 * Tutorial.
 *
 * @return the string
 */
String tutorial();

	/**
	 * Lbl new label_text.
	 *
	 * @return the string
	 */
	String lblNewLabel_text();
}
