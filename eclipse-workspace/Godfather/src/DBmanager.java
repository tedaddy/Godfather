// Instruction
/*


DBmanager db = new DBmanager();  -- Create object of DBmanager
db.addSource(databaseName, JSONObject) -- Add new model to db
db.getSource(databaseName, number of variant) -- Get variant model from db
db.getCountOfVariants(databaseName) -- Get count of all variants in some db


 */

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.*;
import java.io.FileWriter;

import javax.print.DocFlavor.URL;
import javax.swing.*;
import java.awt.event.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;




public class DBmanager {
	
	public JSONObject getSource(String database, int number) {
    	try {
    		FileInputStream fstream = new FileInputStream(database);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            JSONTokener tokener = new JSONTokener(br);
            JSONArray all_variants = new JSONObject(tokener).getJSONArray("items");
            JSONObject needed_var = all_variants.getJSONObject(number-1);
            return needed_var;
    	}catch(Exception ex) {
    		return null;
    	}
    
    }
    
    public int getCountOfVariants(String database) {
    	int count;
    	try {
    	    InputStream fstream = new FileInputStream(database);
    	    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    	    JSONTokener tokener = new JSONTokener(br);
    	    JSONArray all_variants = new JSONObject(tokener).getJSONArray("items");
    	    count = all_variants.length();
    	    return count;
    	}catch(Exception ex) {
    		return 0;
    	}
    }
    
    public void addSource(String database, JSONObject jObject) {
    	try {
    	    FileInputStream fstream = new FileInputStream(database);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            JSONTokener tokener = new JSONTokener(br);
            JSONArray ja = new JSONObject(tokener).getJSONArray("items");
            ja.put(jObject);
            JSONObject jo = new JSONObject();
            jo.put("items", ja);
		
            try (FileWriter file = new FileWriter(database)) {
	        	 
            	file.write(restructuring(jo.toString()));
            	file.flush();
				JOptionPane.showMessageDialog(null,"Successfully added","Added",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {JOptionPane.showMessageDialog(null, e,"Adding problem",JOptionPane.ERROR_MESSAGE);}
    	}catch(Exception ex) {JOptionPane.showMessageDialog(null, ex,"Adding problem",JOptionPane.ERROR_MESSAGE);}
    	
    }
    
    public String restructuring(String object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object jsonObject = mapper.readValue(object, Object.class);
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            return prettyJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
