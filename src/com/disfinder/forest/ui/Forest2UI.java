package com.disfinder.forest.ui;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebServlet;

import com.disfinder.forest.cache.ForestCache;
import com.disfinder.forest.jenkins.model.Job;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("forest2")
public class Forest2UI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = Forest2UI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
	final VerticalLayout layout = new VerticalLayout();
	// layout.setMargin(true);
	setContent(layout);
	//
	// Button button = new Button("Click Me");
	// button.addClickListener(new Button.ClickListener() {
	// public void buttonClick(ClickEvent event) {
	// layout.addComponent(new Label("Thank you for clicking"));
	// }
	// });
	// layout.addComponent(button);

	TabSheet tabsheet = new TabSheet();
	layout.addComponent(tabsheet);

	// Create the first tab
	VerticalLayout tab1 = new VerticalLayout();
	// tab1.addComponent(new Embedded(null, new
	// ThemeResource("img/planets/Mercury.jpg")));
	tabsheet.addTab(tab1, "Common");
	//OptionGroup list = new OptionGroup("Jobs");
	TwinColSelect list = new TwinColSelect();
	list.setMultiSelect(true);
	Item i=list.addItem("First");
	for (Job a:ForestCache.getInstance().jobs.jobsList)
	{
	    list.addItem(a.name);
	    
	}
	
	list.select(i);
	i = list.addItem("second");
	list.select(i);
	list.select("second");
	//for (a:)
	list.setImmediate(true);
	//list.setValue(i.getItemPropertyIds());
	
	//list.getValue()
	//list.setValue(i);
	// i.addItemProperty(id, property)
	// list.add
	
	
	tab1.addComponent(list);
	// CommonTab.ad
	
	final String[] cities =
	        new String[] { "Berlin", "Brussels", "Helsinki", "Madrid", "Oslo",
	            "Paris", "Stockholm" };
	   final ListSelect l = new ListSelect("Please select some cities");

	        for (final String city : cities) {
	            l.addItem(city);
	        }
	        l.setRows(7);
	        l.setNullSelectionAllowed(true);
	        l.setMultiSelect(true);
	        l.setImmediate(true);
	        //l.addListener(this);

	        Set<String> selected = new HashSet<String>();
	        selected.add("Berlin");
	        selected.add("Helsinki");

	        //l.select(selected);
	        l.setValue(selected);
	        tab1.addComponent(l);	
	
	
	
	
	
	
	
	
	

	// This tab gets its caption from the component caption
	VerticalLayout tab2 = new VerticalLayout();
	// tab2.addComponent(new Embedded(null, new
	// ThemeResource("img/planets/Venus.jpg")));
	tab2.setCaption("Settings");
	tabsheet.addTab(tab2);// .setIcon( new
			      // ThemeResource("img/planets/Venus_symbol.png"));

	VerticalLayout tab3 = new VerticalLayout();
	// tab2.addComponent(new Embedded(null, new
	// ThemeResource("img/planets/Venus.jpg")));
	tab3.setCaption("TABLE");
	tabsheet.addTab(tab3);// .setIcon( new
			      // ThemeResource("img/planets/Venus_symbol.png"));

	Table table = new Table("The Brightest Stars");

	// Define two columns for the built-in container
	table.addContainerProperty("Name", String.class, null);
	table.addContainerProperty("Mag", Float.class, null);

	// Add a row the hard way
	Object newItemId = table.addItem();
	Item row1 = table.getItem(newItemId);
	row1.getItemProperty("Name").setValue("Sirius");
	row1.getItemProperty("Mag").setValue(-1.46f);
	// row1.
	table.setEditable(true);

	// Add a few other rows using shorthand addItem()
	table.addItem(new Object[] { "Canopus", -0.72f }, 2);
	table.addItem(new Object[] { "Arcturus", -0.04f }, 3);
	table.addItem(new Object[] { "Alpha Centauri", -0.01f }, 4);

	// Show exactly the currently contained rows (items)
	table.setPageLength(table.size());

	tab3.addComponent(table);

    }

}