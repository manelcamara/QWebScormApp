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


import com.google.gwt.user.client.ui.DialogBox;

/**
 * The Class PPresentacion: pantalla que presenta a l'usuari la presentació d'un 
 * qüestionari (autoavaluació o tutorial). Els elements visualitzats estan definits
 * a la classe PresentacionComposite.
 */
public class PPresentacion extends DialogBox {

	/**
	 * Instantiates a new p presentacion.
	 *
	 * @param cuestionario the cuestionario
	 */
	public PPresentacion(Cuestionario cuestionario) {
		setHTML(cuestionario.getTituloCuestionario());
		
		PresentacionComposite presentacionComposite = new PresentacionComposite(cuestionario, this);
		setWidget(presentacionComposite);
		presentacionComposite.setSize("100%", "100%");
	}

}
