package cd.controller;

import cd.domain.mediator.CdModel;
import cd.view.CdView;

public class CdController {

	private CdView cdView;
	private CdModel cdModel;
	
	public CdController(CdModel model, CdView view) {
		
		this.cdView = view;
		this.cdModel = model;
		
	}
	

public void exectute(String what) {

	switch(what) {
	}
}
}
