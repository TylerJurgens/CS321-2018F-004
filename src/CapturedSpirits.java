import java.io.File;
import java.util.logging.*;
import java.io.IOException;

public class CapturedSpirits
{
	public Logger logger;
	public FileHandler fh;
	public CapturedSpirits() throws SecurityException, IOException{

	LogManager.getLogManager().reset();
	File f = new File("captured_spirits.txt");
	if(!f.exists()){
		f.createNewFile();
	}
	fh = new FileHandler("captured_spirits.txt", true);
	logger = Logger.getLogger("CapturedSpirits");
	logger.addHandler(fh);
	SimpleFormatter formatter = new SimpleFormatter();
	fh.setFormatter(formatter);
	
	
	}
	

	public void spiritLog(String msg){
		try{
			logger.log(Level.SEVERE, msg);
		}catch (Exception e){}
		
	} 

}