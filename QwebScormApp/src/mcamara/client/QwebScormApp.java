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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * The Class QwebScormApp: classe 'entry point' de l'aplicació web. És la classe que
 * s'encarrega d'executar l'aplicació web Ajax i presentar-la en el navegador de l'usuari
 */
public class QwebScormApp implements EntryPoint {
	private static Mensajes m = null;
	private Cuestionario cuestionario = null;
	
	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onModuleLoad() {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "cuestionario.xml");
		try {
			builder.sendRequest(null, new RequestCallback(){
				public void onResponseReceived(Request request,
						Response response) {
					cuestionario = Util.XMLtoCuestionario(response.getText());
					m = Util.getMensajes(cuestionario.getIdioma());
					if (cuestionario.getTipo().equals("autoevaluacion")){
						DialogBox ppresentacion = new PPresentacion(cuestionario);
						RootPanel.get().add(ppresentacion);
					} else if (cuestionario.getTipo().equals("tutorial")){
						DialogBox ptutorial = new PTutorial(cuestionario, -1);
						RootPanel.get().add(ptutorial);
					} else Window.alert(m.cuestionarionovalido());
				}
				public void onError(Request request, Throwable exception) {
					Window.alert(m.error());
				}});
		} catch (RequestException e) {
			Window.alert(m.error());
		}
	}
}
