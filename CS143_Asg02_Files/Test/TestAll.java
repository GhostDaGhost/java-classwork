
import java.io.*;

public class TestAll {

	public static void main(String[] args)
	{

		try
		{
			System.out.println("Starting...");
			File file = new File("_gradingLog.txt");
			if(file.exists())
			{
				file.delete();
			}
			FileWriter fw = new FileWriter(file,true);
			PrintWriter out = new PrintWriter(fw,true);	
			
			// CustomerData class test calls
			TestCustomerData.tests(out);
         
			// PersonData class test calls
			TestPersonData.tests(out);	
			
			// Circle class test calls
			TestCircle.tests(out);		
			
			// Rectangle class test calls
			TestRectangle.tests(out);	
			
			// Relatable Methods test calls
			TestRelatableMethods.tests(out);	
			
			out.close();

	        
			System.out.println("Testing complete. See results in file \"_gradingLog.txt\"");
		}
		catch (IOException e)
		{
			System.out.println("File IO troubles"+ e.getMessage());
		}
	}
}

