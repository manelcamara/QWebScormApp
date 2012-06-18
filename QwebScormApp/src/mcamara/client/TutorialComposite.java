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

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBoxBase;

/**
 * The Class TutorialComposite: classe que defineix els elements que conformen la UI
 * d'una pantalla en un tutorial
 */
public class TutorialComposite extends Composite {
	private Label titulo;
	private VerticalPanel menuPantallas;
	private ScrollPanel itemsMenuPantallas;
	private HorizontalPanel panelTitulo;
	private HorizontalPanel horizontalPanel;
	private TextArea explicacion;
	private Image image;
	private Button continuar;
	private Mensajes m = null;

	/**
	 * Instantiates a new tutorial composite.
	 *
	 * @param idioma the idioma
	 */
	@SuppressWarnings("deprecation")
	public TutorialComposite(String idioma) {
		m = Util.getMensajes(idioma);
		DockPanel dockPanel = new DockPanel();
		initWidget(dockPanel);
		dockPanel.setSize("800", "500");
		
		panelTitulo = new HorizontalPanel();
		panelTitulo.setSpacing(1);
		panelTitulo.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panelTitulo.setBorderWidth(0);
		titulo = new Label("New label");
		titulo.setStyleName("gwt-Label-Titulo");
		titulo.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panelTitulo.add(titulo);
		titulo.setWidth("100%");
		dockPanel.add(panelTitulo, DockPanel.NORTH);
		panelTitulo.setWidth("100%");
		
		itemsMenuPantallas = new ScrollPanel();
		menuPantallas = new VerticalPanel();
		menuPantallas.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		menuPantallas.setSpacing(1);
		menuPantallas.setBorderWidth(1);
		itemsMenuPantallas.add(menuPantallas);
		menuPantallas.setSize("120px", "100%");
		dockPanel.add(itemsMenuPantallas, DockPanel.WEST);
		itemsMenuPantallas.setSize("100%", "100%");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_1.setSpacing(5);
		verticalPanel_1.setBorderWidth(0);
		dockPanel.add(verticalPanel_1, DockPanel.CENTER);
		verticalPanel_1.setSize("100%", "100%");
		
		horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_1.add(horizontalPanel);
		horizontalPanel.setWidth("80%");
		
		image = new Image((String)null);
		horizontalPanel.add(image);
		
		explicacion = new TextArea();
		explicacion.setTextAlignment(TextBoxBase.ALIGN_CENTER);
		explicacion.setEnabled(false);
		explicacion.setVisibleLines(4);
		explicacion.setReadOnly(true);
		explicacion.setAlignment(TextAlignment.LEFT);
		verticalPanel_1.add(explicacion);
		explicacion.setWidth("100%");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(1);
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel_1.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("100%");
		
		continuar = new Button(m.continuar());
		horizontalPanel_1.add(continuar);
	}
	
	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public Label getTitulo() {
		return titulo;
	}

	/**
	 * Gets the menu pantallas.
	 *
	 * @return the menu pantallas
	 */
	public VerticalPanel getMenuPantallas() {
		return menuPantallas;
	}
	
	/**
	 * Gets the items menu pantallas.
	 *
	 * @return the items menu pantallas
	 */
	public ScrollPanel getItemsMenuPantallas(){
		return itemsMenuPantallas;
	}

	/**
	 * Gets the explicacion.
	 *
	 * @return the explicacion
	 */
	public TextArea getExplicacion() {
		return explicacion;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Gets the continuar.
	 *
	 * @return the continuar
	 */
	public Button getContinuar() {
		return continuar;
	}

}
