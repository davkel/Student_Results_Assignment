
package studentresults;

/**
 * @author David Kelly
 * student number: c05522382
 */
public class Person {
    
    private String firstName;
    private String surname;
    
    /**
     *
     * @param sname
     * @param fName
     */
    public Person(String sname,String fName) 
    {
        this.surname = sname;
        this.firstName = fName;
    }

    /**
     *
     */
    public Person()
    {
        
    }

    /**
     *
     * @return
     */
    public String getFirstName() 
    {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     *
     * @param firName
     */
    public void setFirstName(String firName)
    {
        this.firstName= firName;
    }

    /**
     *
     * @param lastName
     */
    public void setSurname(String lastName) 
    {
        this.surname = lastName;
    }
}
