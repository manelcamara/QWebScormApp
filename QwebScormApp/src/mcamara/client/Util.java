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


import com.google.gwt.core.client.GWT;
import com.google.gwt.xml.client.*;

/**
 * The Class Util:
 * classe estàtica amb utilitats necessàries per a llegir l'arxiu xml de continguts
 * i gestionar els missatges de l'aplicació
 */
public class Util {
	
	/**
	 * XM lto cuestionario.
	 *
	 * @param text the text
	 * @return the cuestionario
	 */
	public static Cuestionario XMLtoCuestionario(String text) {
		com.google.gwt.xml.client.Document cuestionarioXML = XMLParser.parse(text);
		cuestionarioXML.getDocumentElement().normalize();
		Cuestionario cuestionario = new Cuestionario();
		Pregunta pregunta = null;
		Respuesta respuesta = null;
		String textoPregunta = "";
		String textoCortoPregunta = "";
		String imagenPregunta = "";
		String textoRespuesta = "";
		String tipoRespuesta = "";
		Element elementCuestionario = cuestionarioXML.getDocumentElement();
		String tituloCuestionario = elementCuestionario.getAttribute("titulo");
		String tipoCuestionario = elementCuestionario.getAttribute("tipoCuestionario");
		String presentacion = elementCuestionario.getAttribute("presentacion");
		String idioma = elementCuestionario.getAttribute("idioma");
		cuestionario.setTituloCuestionario(tituloCuestionario);
		cuestionario.setPresentacionCuestionario(presentacion);
		cuestionario.setTipo(tipoCuestionario);
		cuestionario.setIdioma(idioma);
		NodeList listaPreguntas = cuestionarioXML.getElementsByTagName("pregunta");

		for (int i = 0; i < listaPreguntas.getLength() ; i ++) {
			
			Node nodoPregunta = listaPreguntas.item(i);
		    
		    if (nodoPregunta.getNodeType() == Node.ELEMENT_NODE) {
		    	pregunta = new Pregunta();
		    	Element preguntaElement = (Element) nodoPregunta;
		    	//textoPregunta
		    	NodeList textoPreguntaElementList = preguntaElement.getElementsByTagName("textoPregunta");
		    	Element textoPreguntaElement = (Element) textoPreguntaElementList.item(0);
		    	NodeList textoPreguntaNodeList = textoPreguntaElement.getChildNodes();
		    	textoPregunta = ((Node)textoPreguntaNodeList.item(0)).getNodeValue();
		    	pregunta.setTextoPregunta(textoPregunta);
		    	//textoCortoPregunta
		    	if (tipoCuestionario.equals("tutorial")){
		    		NodeList textoCortoPreguntaElementList = 
		    				preguntaElement.getElementsByTagName("textoCortoPregunta");
		    		Element textoCortoPreguntaElement = (Element)textoCortoPreguntaElementList.item(0);
		    		NodeList textoCortoPreguntaNodeList = textoCortoPreguntaElement.getChildNodes();
		    		textoCortoPregunta = ((Node)textoCortoPreguntaNodeList.item(0)).getNodeValue();
		    		pregunta.setTextoCortoPregunta(textoCortoPregunta);
		    	}
		    	//imagenPregunta
		    	NodeList imagenPreguntaElementList = preguntaElement.getElementsByTagName("imagenPregunta");
		    	if (imagenPreguntaElementList.getLength()>0){
		    		Element imagenPreguntaElement = (Element) imagenPreguntaElementList.item(0);
		    		NodeList imagenPreguntaNodeList = imagenPreguntaElement.getChildNodes();
		    		imagenPregunta = ((Node) imagenPreguntaNodeList.item(0)).getNodeValue();
		    		pregunta.setImagenPregunta(imagenPregunta);
		    	}
		    	NodeList listaRespuestas = preguntaElement.getElementsByTagName("respuesta");
		    	for (int j=0; j<listaRespuestas.getLength();j++){
		    		
		    		Node nodoRespuesta = listaRespuestas.item(j);
		    		
		    		if (nodoRespuesta.getNodeType() == Node.ELEMENT_NODE){
		    			
		    			Element respuestaElement = (Element) nodoRespuesta;
		    			NodeList textoRespuestaElementList = respuestaElement.getElementsByTagName("textoRespuesta");
		    			NodeList tipoRespuestaElementList = respuestaElement.getElementsByTagName("tipoRespuesta");
		    			Element textoRespuestaElement = (Element) textoRespuestaElementList.item(0);
		    			Element tipoRespuestaElement = (Element) tipoRespuestaElementList.item(0);
		    			NodeList textoRespuestaNodeList = textoRespuestaElement.getChildNodes();
		    			NodeList tipoRespuestaNodeList = tipoRespuestaElement.getChildNodes();
		    			textoRespuesta = ((Node)textoRespuestaNodeList.item(0)).getNodeValue();
		    			tipoRespuesta = ((Node)tipoRespuestaNodeList.item(0)).getNodeValue();
		    			respuesta = new Respuesta();
		    			respuesta.setTextoRespuesta(textoRespuesta);
		    			respuesta.setTipoRespuesta(tipoRespuesta.equals("true"));
		    			
		    		}
		    		pregunta.addRespuesta(respuesta);
		    	}
		    	cuestionario.addPregunta(pregunta);
			}
		}
	return cuestionario;
	}
	
	/**
	 * Gets the mensajes.
	 *
	 * @param idioma the idioma
	 * @return the mensajes
	 */
	public static Mensajes getMensajes(String idioma){
		Mensajes m = null;
		if (idioma.equals("ca_ES")){
			m = (Mensajes_ca_ES) GWT.create(Mensajes_ca_ES.class);
		} else if (idioma.equals("es_ES")){
			m = (Mensajes_es_ES) GWT.create(Mensajes_es_ES.class);
		}
	return m;
	}

}
