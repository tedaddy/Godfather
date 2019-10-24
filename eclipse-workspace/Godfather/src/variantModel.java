// Instruction
/*


variantModel variant = new variantModel()  -- Create new object of variantModel
variant.tasks -- Array of tasks of variant
variant.fromJSObject(JSONObject) -- Create from JSONObject variant model
variant.createJSONObject() -- From variant model create JSONObject


 */

import org.json.JSONObject;

public class variantModel {
	
	int number;
	String[] tasks = new String[3];
	
	public void fromJSObject(JSONObject obj) {
		try {
			tasks[0] = obj.getString("task1");
			tasks[1] = obj.getString("task2");
			tasks[2] = obj.getString("task3");
		}catch(Exception ex) {}
	}
	
	public String getTask(int taskNumber) {
		System.out.println(tasks[taskNumber-1]);
		return tasks[taskNumber-1];
	}
	
	public JSONObject createJSONObject() {
		JSONObject jo = new JSONObject();
		try {
			jo.put("task1", tasks[0]);
			jo.put("task2", tasks[1]);
			jo.put("task3", tasks[2]);
		}catch(Exception ex) {}
		return jo;
	}

}
