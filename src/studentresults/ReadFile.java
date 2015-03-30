
package studentresults;

/**
 * @author David Kelly
 * student number: c05522382
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class ReadFile {
    //declare variable filename of file location

    /**
     *
     */
         public String filename = "";
    
    private final static List<Student> studentList = new ArrayList<Student>();
        
    /**
     *
     * @return
     */
    public static List<Student>getStudentList()
    {
        return studentList;
    }
    
// implementation to open a file

    /**
     *
     * @param choose
     * @return
     */
       public static String openFile(Object choose) {
        JFileChooser chooser = new JFileChooser();
    
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
    "txt", "doc", "dat");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(null);
    String input="";
    if(returnVal == JFileChooser.APPROVE_OPTION) {
        //print to console for testing purposes only
        System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
        //assign filename to string
        input = chooser.getSelectedFile().getName();
    }
    else
        System.out.print("User cancelled open file process");
   
    return input;
   }
   
   //implementation to read data from the file and put into ArrayList 

    /**
     *
     * @param filename
     * @return
     */
       public static List<String>readFile (String filename)
   {
        List<String> stringList = new ArrayList<String>();
       try
       {
           BufferedReader reader = new BufferedReader(new FileReader(filename));
           String line;
           int lineCount=0;
           
           while ((line = reader.readLine()) != null)
           {
               lineCount++;
               //add Strings from file to String ArrayList while replacing commas
               stringList.add(line.replace(",", " "));//.replace("]", "").replace("[ ", " "));
               
               //to read data from a file containing only 1 line for example the CorrectAnswers.dat file 
                if(lineCount==1 && reader.readLine() == null) 
                   
               stringList.add(line.replace(",", " "));       
           }
           reader.close();
           return stringList;
       }
       catch (FileNotFoundException e)
       {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            JOptionPane.showMessageDialog(null,"Exception occurred trying to read file "+ filename);
            e.printStackTrace();
            return null;
       }
       catch (IOException e)
       {
            System.err.format("Exception occured trying to read '%s'", filename);
            JOptionPane.showMessageDialog(null,"Exception occurred trying to read file "+ filename);
            e.printStackTrace();
            return null;
       }
   }
   
    /**
     *
     * @param filename
     * @return
     */
    public static List<Student> readLineSplit(String filename)
       {
	BufferedReader br = null;

	try {

		String line;

		br = new BufferedReader(new FileReader(filename));

		while ((line = br.readLine()) != null) {
		   /*Split each line into 4 sections by removing the first 4 commas. This divides the line into separate strings for studentID, first name and surname.
                     The students answers are separated into a different String array called str and each int within that array is then parsed into an int array.
                    */
		   String[] splitLine = line.split(",",4);
		   String studentId = splitLine[0];
		   String lastName = splitLine[1];
		   String firstName = splitLine[2];
                   int result=0;
                   int[] answers = new int[20];
                   //create a new String array for the students answers
                   String[] str = new String[20];
                   str[0] = splitLine[3];

                   String temp = str[0];
                   //iterate through the String array to parse ints to an int array
                   for (int i = 0; i < str.length; i++)
                        answers[i] = Integer.parseInt(temp.split(",")[i]);
                    //create a new Student object consisting of all the separated parts of the initial String
                    Student student = new Student(studentId,lastName, firstName, answers, result );
                    studentList.add(student );	
	   }
	} 
        catch(ArrayIndexOutOfBoundsException arrex){
                    JOptionPane.showMessageDialog(null,"Exception occurred trying to read file "+ filename);
                    arrex.printStackTrace();
        }
        catch (IOException e) 
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            JOptionPane.showMessageDialog(null,"Exception occurred trying to read file "+ filename);
            e.printStackTrace();
            return null;
	} finally {
		try {
			if (br != null)
				br.close();

		} catch (IOException ex) {
			System.err.format("Exception occured trying to read '%s'", filename);
                        JOptionPane.showMessageDialog(null,"Exception occurred trying to read file "+ filename);
                        ex.printStackTrace();
		}
                
                
	}
return studentList;
}
}
