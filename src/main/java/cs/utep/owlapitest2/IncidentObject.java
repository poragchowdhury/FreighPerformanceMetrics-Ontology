package cs.utep.owlapitest2;

public class IncidentObject {
	
	public int Crash_ID = 0;
	public String Crash_Date = "";
	public String Crash_Time = "";
	public String Rpt_Street_Name = "";
	public String Rpt_Sec_Street_Name = "";
	public int Death_Cnt = 0;
	public int Othr_Factr_ID = 0;
	public int Wthr_Cond_ID = 0;
	public String Investigat_Arrv_Time = "";
	public String Investigat_Notify_Time = "";
	public double startTime =0;
	public double endTime =0;
	public double totalTime =0;
	
	
	
	public IncidentObject() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setCrashID(int id){
		System.out.println("SET ID: "+id);
		Crash_ID = id;
	}
	public int getCrashID(){
		return Crash_ID;
	}
}
