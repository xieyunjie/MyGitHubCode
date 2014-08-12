package de.oio.bestPractices.example7;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class DebugPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Map<String, Object> application = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.INVOKE_APPLICATION;
	}

	
	
}
