import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

public abstract class Grade {
	String [] tasks;
	DBmanager db;
	String absolute_path;
	String database_path;
	
	public Grade() {
		db = new DBmanager();
		Path currentRelativePath = Paths.get("");
		String path = currentRelativePath.toAbsolutePath().toString();
		absolute_path = path.replaceAll("\\\\", "/");
	}
	
	public void setVariant(int number) {
		JSONObject jo = db.getSource(database_path, number);
		variantModel variant = new variantModel();
		variant.fromJSObject(jo);
		int count_tasks = variant.tasks.length;
		tasks = new String[count_tasks];
		for(int i = 0; i < count_tasks; i++) {
			tasks[i] = variant.tasks[i];
		}
	}
	
	public String getTask(int number) {
		return tasks[number-1];
	}
	
	public int getCountOfVariants() {
		return db.getCountOfVariants(database_path);
	}

}
