package it.unibg.info3b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstraiController {
	private EstraiModel model;
	private FinestraPrincipale view;
	
	public EstraiController(EstraiModel model, FinestraPrincipale view) {
		this.model = model;
		this.view = view;
		
		view.getEstraiButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.doEstrai();
				view.mostraNumEstratto();
			}
			
		});
	}
	
	
}
