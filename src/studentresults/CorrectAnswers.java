
package studentresults;

/**
 * @author David Kelly
 * student number: c05522382
 * 
 */
import java.util.*;

/**
 *
 * @author david
 */
public class CorrectAnswers {

    //read correct answers from file
    private final static List<String> correctAns=ReadFile.readFile("CorrectAnswers.dat");
    
    //Convert String ArrayList to array of integers

    /**
     *
     */
        private static int [] correct= convertIntegers(correctAns);
    
    //Get and set methods

    /**
     *
     * @return
     */
        public int[] getCorrect()
    {
        
        return correct;
    }

    /**
     *
     * @param cor
     */
    public void setCorrect (int[]cor)
    {
        this.correct =cor;
    }
    
    //Convert List <String> read in from file to an int array

    /**
     *
     * @param strings
     * @return
     */
    public static int[] convertIntegers(List<String> strings)
{
    String str = strings.get(0);
        
    int []integers= new int[20];
    for (int i=0;i<integers.length;i++)
        integers[i]=Integer.parseInt(str.split(" ")[i]);
    
    return integers;
}
    
    /**
     *
     * @param studList
     * @return
     */
    public static int calcResults(List<Student>studList)
    {      
        int result=0;
        for (Student student:studList)
        {
            result=student.result(correct);
            //System.out.print(student + " " +student.result(correct)+"\n");
        }
        
        return result;
    }// end of calcResults method
}// end of class
