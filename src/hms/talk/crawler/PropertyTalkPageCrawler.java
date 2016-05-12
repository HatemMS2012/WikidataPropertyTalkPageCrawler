package hms.talk.crawler;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;


public class PropertyTalkPageCrawler {
	
	
	
	public static void main(String[] args) throws Exception {

			
		PropertyTalkMetadata metadata = extractMetaData("P108");
	        
	     System.out.println(metadata);
	     
	     extractMetadata("input/Full_Prop_List.txt", "output/prop_talk_metadata.txt");

	}
	
	
	public static void extractMetadata(String propertyListFile, String output){
		
		List<String> propertyList;
		try {
		
			propertyList = loadPropertyIdsFromFile(propertyListFile);
			
			PrintWriter out = new PrintWriter(new File(output));
			
			out.println("Property ID \t Description \t Represents \t Domain \t Allowed Values \t Examples \t Data Type");
			
			for(String prop : propertyList){
				
				PropertyTalkMetadata metadata = extractMetaData(prop);
				System.out.println(metadata.getPropertyID() + "\t" + metadata.getDescription() 
				+ "\t" + metadata.getRepresents() 
				+ "\t" + metadata.getDomain() 
				+ "\t" +  metadata.getAllowedValues() + "\t" + metadata.getExamples() + "\t" + metadata.getDataType());
				
				out.println(metadata.getPropertyID() + "\t" + metadata.getDescription() 
				+ "\t" + metadata.getRepresents() 
				+ "\t" + metadata.getDomain() 
				+ "\t" +  metadata.getAllowedValues() + "\t" + metadata.getExamples() + "\t" + metadata.getDataType());
				out.flush();
			}
			out.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	/**
	 * Get metadata about a property from the talk page
	 * @param propertyID
	 * @return
	 */
	public static PropertyTalkMetadata extractMetaData(String propertyID) {

		PropertyTalkMetadata metadata = new PropertyTalkMetadata() ;
		
		metadata.setPropertyID(propertyID);


		try {
			
			
			
			Document doc = Jsoup.connect("https://www.wikidata.org/wiki/Property_talk:" + propertyID).get();
			
			Elements descriptionTableRecords = doc.select("tr"); // a with href

			for (int i = 0; i < descriptionTableRecords.size(); i++) {
				String fieldName = "";
				String fieldValue = "";
				Element record = descriptionTableRecords.get(i);
				// Get the name of the header filed
				Elements headerOfElement = record.select("th");
				fieldName = headerOfElement.text();

				Elements headerValue = record.select("td");
				fieldValue = headerValue.text();
//				System.out.println(fieldName + ": " + fieldValue);
				
				if(fieldName.equals("Description")){
					metadata.setDescription(fieldValue);
				}
				if(fieldName.equals("Represents")){
					metadata.setRepresents(fieldValue);
				}
				if(fieldName.equals("Data type")){
					metadata.setDataType(fieldValue);
				}
				if(fieldName.equals("Domain")){
					metadata.setDomain(fieldValue);
				}
				if(fieldName.equals("Allowed values")){
					metadata.setAllowedValues(fieldValue);
				}
				if(fieldName.equals("Example")){
					metadata.setExamples(fieldValue);
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return metadata;
	}
	
	public static List<String> loadPropertyIdsFromFile(String testCaseFile) throws IOException{
		
		List<String> propIdList  = new ArrayList<String>();
		
		FileInputStream fstream = new FileInputStream(testCaseFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		//Read File Line By Line
		
		int i = 0;
		while ((strLine = br.readLine()) != null)   {
			
			i++;
			//ignore the first line
			if(i==1)
				continue;
				 
			String[] lineArr = strLine.split("\t");
			String propertyID = lineArr[0];
			propIdList.add(propertyID);
			
		}
		
		br.close();
		return propIdList;
	}
	
}

