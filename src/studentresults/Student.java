/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentresults;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author David Kelly
 * student number: c05522382
 */

public class Student extends Person implements Comparable<Student> {
    //declare variables
    private String studentId;
    private int[] answers;
    private int result;
    
    //Student constructors

    /**
     *
     * @param studId
     * @param fName
     * @param sName
     * @param studAnswers
     * @param res
     */
        public Student (String studId,String fName, String sName, int[]studAnswers, int res)
    {
       super( fName, sName);
       this.studentId = studId;
       this.answers= studAnswers;
       this.result=res;      
    }

    /**
     *
     */
    public Student ()
    {
        
    }

    //accessor & mutator methods

    /**
     *
     * @return
     */
        public  String getStudentId()
    {
        return studentId;
    }

    /**
     *
     * @param studentId
     */
    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    /**
     *
     * @return
     */
    public int[] getAnswers() 
    {
        return answers;
    }

    /**
     *
     * @param ans
     */
    public void setAnswers(int[] ans) 
    {
        this.answers = ans;
    }
    
    /**
     *
     * @return
     */
    public int getResults()
    {
        return result;
    }

    /**
     *
     * @param res
     */
    public void setResults (int res)
    {
        this.result= res;
    }
  
    /**
     *
     * @param student
     * compareTo method to sort Students by last name. implements comparable interface
     */
    @Override
   public int compareTo(Student student)
    {
        return this.getSurname().compareToIgnoreCase(student.getSurname());
    }

    @Override
    public String toString(){
        return getStudentId()+"\t"+getSurname() + "\t" +getFirstName() +"\t "+ getResults()+"\t" +Arrays.toString(answers) ;
    }

    /**
     *
     * @return
     */
    public String writeToFileToString(){
        return getStudentId()+","+getSurname()+"," +getFirstName()+"," +Arrays.toString(answers).replace("]", "").replace("[", "").replace(" ", "") ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.studentId);
        return hash;
    }
    
    @Override
    public boolean equals(Object other)
    {
        return getStudentId().equals(((Student)other).getStudentId());
    }
    
    /**
     *
     * @param correct
     * @return
     */
    public int result(int[]correct){
        double count=0;
        int CORRECT=1;
        double INCORRECT= -0.25;
        int NOANSWER= 0;
                
        for (int i=0;i<answers.length;i++){
                    
            if(answers[i]== correct[i]){
                        count+=CORRECT;
                        //System.out.print( student.getFirstName()+" answer " + i+ " is correct\n ");
                    }
                    else if(answers[i]== 0){
                        count+=NOANSWER;
                       // System.out.print(student.getFirstName()+" answer " + i+" not answered\n");
                    }
                    else{
                        count+=INCORRECT;
                       // System.out.print(student.getFirstName()+" answer " + i+" wrong\n");
                    }
                result = (int)count;      
               
        }
        return result;
    }
    
    /**
     *
     */
    public class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student stu1, Student stu2) {
            return stu1.getSurname().compareToIgnoreCase(stu2.getSurname());
        }
    }
}
