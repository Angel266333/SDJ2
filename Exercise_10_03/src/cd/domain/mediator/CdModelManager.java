package cd.domain.mediator;

import cd.domain.model.CdList;

public class CdModelManager {

	private static String TEXT_FILE_NAME;
	private CdPersistence persistance;	
	private CdList cdList;
		
		public CdModelManager() {
			
			this.TEXT_FILE_NAME = "src/cds.txt";
			
		}
}
