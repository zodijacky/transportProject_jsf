package pi.transport.presentation.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean( name = "ScheduleMB" )
@ViewScoped
public class ScheduleBean {
	
	private String depStation;
	private String arrStation;
	
	
	public ScheduleBean() {
	}


	public String getDepStation() {
		return depStation;
	}


	public void setDepStation(String depStation) {
		this.depStation = depStation;
	}


	public String getArrStation() {
		return arrStation;
	}


	public void setArrStation(String arrStation) {
		this.arrStation = arrStation;
	}

	
	
	
}
