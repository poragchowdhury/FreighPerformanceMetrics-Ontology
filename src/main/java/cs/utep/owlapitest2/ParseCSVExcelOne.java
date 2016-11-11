package cs.utep.owlapitest2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseCSVExcelOne {

	static int weatherIssues=0;
	static int deathCount=0;
	static double startTime=0.0;
	static double endTime=0.0;
	static double totalTime=0.0;
	static double averageTime=0.0;
	static double incidentCount=0.0;

	public ParseCSVExcelOne() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String [] args){
		try{
			String csvFile = "C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv 2014 incidents.csv";
			String currentLine = "";
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			List<String []> dataList = new ArrayList<String []>();
			//FileInputStream file = new FileInputStream(new File("C:\\Users\\dmmej_000\\workspace\\owlapitest2\\src\\main\\java\\cs\\utep\\owlapitest2\\cmv 2014 incidents.csv"));
			while((currentLine = reader.readLine())!=null){
				//System.out.println(currentLine);


				String [] items = currentLine.split(",");
				dataList.add(items);

			}
			List<Object []> indexList = new ArrayList<Object []>();
			for(int i=0;i<dataList.get(0).length;i++){
				//System.out.println("COLUMN NAME: "+dataList.get(0)[i]);

				String columnName = dataList.get(0)[i];
				Object [] metaData = new Object[2];//Crash_ID
				if(columnName.equals("Crash_ID")){
					metaData[0] = "Crash_ID";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Crash_Date")){
					metaData[0] = "Crash_Date";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Crash_Time")){
					metaData[0] = "Crash_Time";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Death_Cnt")){
					metaData[0] = "Death_Cnt";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Othr_Factr_ID")){
					metaData[0] = "Othr_Factr_ID";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Wthr_Cond_ID")){
					metaData[0] = "Wthr_Cond_ID";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Investigat_Notify_Time")){
					metaData[0] = "Investigat_Notify_Time";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Investigat_Arrv_Time")){
					metaData[0] = "Investigat_Arrv_Time";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Rpt_Street_Name")){
					metaData[0] = "Rpt_Street_Name";
					metaData[1] = i;
					indexList.add(metaData);
				}else if(columnName.equals("Rpt_Sec_Street_Name")){
					metaData[0] = "Rpt_Sec_Street_Name";
					metaData[1] = i;
					indexList.add(metaData);
				}	






			}
			List<IncidentObject> allIncidents = new ArrayList<IncidentObject>();
			for(int i=1;i<dataList.size();i++){
				incidentCount++;
				IncidentObject currentIncident = new IncidentObject();

				for(int j=0;j<indexList.size();j++){


					if(indexList.get(j)[0].equals("Crash_ID")){

						currentIncident.Crash_ID = Integer.parseInt(dataList.get(i)[(Integer) indexList.get(j)[1]]);
					}
					if(indexList.get(j)[0].equals("Crash_Date")){

						currentIncident.Crash_Date = dataList.get(i)[(Integer) indexList.get(j)[1]];
					}
					if(indexList.get(j)[0].equals("Crash_Time")){

						currentIncident.Crash_Time = dataList.get(i)[(Integer) indexList.get(j)[1]];
					}
					/*
					if(hasITenMain){
					boolean hasITenMain = (dataList.get(i)[(Integer) indexList.get(j)[1]].contains("I10")||dataList.get(i)[(Integer) indexList.get(j)[1]].contains("I 10")||dataList.get(i)[(Integer) indexList.get(j)[1]].contains("IH 10")||dataList.get(i)[(Integer) indexList.get(j)[1]].contains("INTERSTATE 10"))&&indexList.get(j)[0].equals("Rpt_Street_Name");
						boolean hasHawkinsMinor = dataList.get(i)[(Integer) indexList.get(j+1)[1]].contains("HAWKINS")&&indexList.get(j+1)[0].equals("Rpt_Sec_Street_Name");
						if(hasHawkinsMinor){
							System.out.println("Incident ID: "+dataList.get(i)[0]);
							System.out.println("Incident at: "+dataList.get(i)[(Integer) indexList.get(j)[1]]+" & "+dataList.get(i)[(Integer) indexList.get(j+1)[1]]);
						}
					}
					 */
					if(indexList.get(j)[0].equals(("Rpt_Street_Name"))){
						String mainStreet = dataList.get(i)[(Integer)indexList.get(j)[1]];
						if(mainStreet.contains("I10")||mainStreet.contains("I 10")||mainStreet.contains("IH 10")||mainStreet.contains("INTERSTATE 10")){
							mainStreet = "I 10";
							
						}
						if(mainStreet.contains("375")){
							mainStreet = "LOOP 375";
							
						}
						currentIncident.Rpt_Street_Name=mainStreet;

					}
					if(indexList.get(j)[0].equals(("Rpt_Sec_Street_Name"))){
						String secStreet = dataList.get(i)[(Integer)indexList.get(j)[1]];
						if(secStreet.contains("I10")||secStreet.contains("I 10")||secStreet.contains("IH 10")||secStreet.contains("INTERSTATE 10")){
							secStreet = "I 10";
						}
						if(secStreet.contains("375")){
							secStreet = "LOOP 375";
							
						}
						currentIncident.Rpt_Sec_Street_Name= secStreet;

					}
					//System.out.println(indexList.get(j)[0]);
					if(indexList.get(j)[0].equals("Death_Cnt")){
						deathCount+=Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
						currentIncident.Death_Cnt = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

					}
					if(indexList.get(j)[0].equals("Othr_Factr_ID")){
						int weatherValue =Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
						if(weatherValue==1){
							weatherIssues++;
							currentIncident.Othr_Factr_ID = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

						}
					}
					if(indexList.get(j)[0].equals("Wthr_Cond_ID")){
						int weatherValue =Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);
						if(weatherValue==1||weatherValue==2||weatherValue==4||weatherValue==6){
							weatherIssues++;
							currentIncident.Wthr_Cond_ID = Integer.parseInt(dataList.get(i)[(Integer)indexList.get(j)[1]]);

						}
					}
					if(indexList.get(j)[0].equals("Investigat_Arrv_Time")&&indexList.get(j-1)[0].equals("Investigat_Notify_Time")){
						//Arrive Time
						String arriveTime = dataList.get(i)[(Integer)indexList.get(j)[1]];
						String[] atime = arriveTime.split(" ");
						int ahour = Integer.parseInt(atime[0].split(":")[0]);
						int aminutes = Integer.parseInt(atime[0].split(":")[1]);
						if(atime[1].equals("PM")){
							ahour+=12;
						}

						endTime = (ahour*60)+aminutes;

						currentIncident.Investigat_Arrv_Time = dataList.get(i)[(Integer)indexList.get(j)[1]];
						currentIncident.endTime = endTime;

						//Notify Time
						String notifyTime = dataList.get(i)[(Integer)indexList.get(j-1)[1]];
						String[] ntime = notifyTime.split(" ");
						int nhour = Integer.parseInt(ntime[0].split(":")[0]);
						int nminutes = Integer.parseInt(ntime[0].split(":")[1]);
						if(ntime[1].equals("PM")){
							nhour+=12;
						}

						startTime = (nhour*60)+nminutes;
						currentIncident.Investigat_Notify_Time = dataList.get(i)[(Integer)indexList.get(j-1)[1]];
						currentIncident.startTime = startTime;

						totalTime+=endTime - startTime;
						currentIncident.totalTime = (endTime-startTime);



					}

					/*if(indexList.get(j)[0].equals("Investigat_Notify_Time")){
						String inputTime = dataList.get(i)[(Integer)indexList.get(j)[1]];
						String[] time = inputTime.split(" ");
						int hour = Integer.parseInt(time[0].split(":")[0]);
						int minutes = Integer.parseInt(time[0].split(":")[1]);
						if(time[1].equals("PM")){
							hour+=12;
						}
						startTime = (hour*60)+minutes;
						System.out.println("HOUR: "+hour);
						System.out.println("MIN: "+minutes);
						System.out.println("TIME: "+dataList.get(i)[(Integer)indexList.get(j)[1]]);
						totalTime +=endTime-startTime;
					}
					 */






				}
				allIncidents.add(currentIncident);
				//System.out.println(dataList.get(455)[(Integer) indexList.get(2)[1]]);
				//System.out.println("");




			}


			for(int i=0;i<allIncidents.size();i++){

				System.out.println("allIncidents.get(i).Crash_ID: "+allIncidents.get(i).Crash_ID);
				System.out.println("allIncidents.get(i).Crash_Date: "+allIncidents.get(i).Crash_Date);
				System.out.println("allIncidents.get(i).Crash_Time: "+allIncidents.get(i).Crash_Time);
				System.out.println("allIncidents.get(i).Death_Cnt: "+allIncidents.get(i).Death_Cnt);
				System.out.println("allIncidents.get(i).Investigat_Arrv_Time: "+allIncidents.get(i).Investigat_Arrv_Time);
				System.out.println("allIncidents.get(i).Investigat_Notify_Time: "+allIncidents.get(i).Investigat_Notify_Time);
				System.out.println("allIncidents.get(i).Rpt_Sec_Street_Name: "+allIncidents.get(i).Rpt_Sec_Street_Name);
				System.out.println("allIncidents.get(i).Rpt_Street_Name: "+allIncidents.get(i).Rpt_Street_Name);
				System.out.println("allIncidents.get(i).Wthr_Cond_ID: "+allIncidents.get(i).Wthr_Cond_ID);
				System.out.println("allIncidents.get(i).Othr_Factr_ID: "+allIncidents.get(i).Othr_Factr_ID);
				System.out.println("allIncidents.get(i).startTime: "+allIncidents.get(i).startTime);
				System.out.println("allIncidents.get(i).endTime: "+allIncidents.get(i).endTime);
				System.out.println("allIncidents.get(i).totalTime: "+allIncidents.get(i).totalTime);

				System.out.println("");

			}

			System.out.println("Fatal Incidents: "+deathCount);
			System.out.println("WeatherIssues: "+weatherIssues);
			System.out.println("Incident Count: "+incidentCount);
			System.out.println("Average Wait Time: "+totalTime/incidentCount +" Minutes" );


		}catch(Exception e){}
	}

}
