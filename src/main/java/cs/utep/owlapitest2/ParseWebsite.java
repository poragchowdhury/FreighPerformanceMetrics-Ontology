package cs.utep.owlapitest2;
import java.io.*;
import java.net.*;

public class ParseWebsite {
   public double averageCrossTime;
	
   public void getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      String webData = result.toString();
      
      String [] arrString = webData.split("\"");
      
      //System.out.println("Website data : " + result.toString());
      
      int sum = 0;
      int count = 0;
      for (int i = 0; i < arrString.length; i++) {
    	    //System.out.println(i + " : " + item);
    	    if(arrString[i].trim().equals("AVG_CROSS_TIME=")){
    	    	i++;
    	    	count++;
    	    	sum += Integer.parseInt(arrString[i]);
    	    	//System.out.println("AvgCrossTime " + count + " : " +arrString[i]);
        	}
      }
      averageCrossTime = sum / count;
      System.out.println("Total AverageCrossTime : " + averageCrossTime);
      return;
   }
}