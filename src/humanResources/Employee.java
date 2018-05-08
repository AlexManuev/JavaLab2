package humanResources;

public class Employee {
    private String firstName;
    private String jobTitle;
    private String secondName;
    private int salary;

    public static final int DEFAULT_SALARY = 0;
    public static final String DEFAULT_JOB_TITLE = "";


    Employee(String firstName, String secondName) {
        this(firstName, secondName, DEFAULT_JOB_TITLE, DEFAULT_SALARY);
    }

    Employee(String firstName, String secondName, String jobTitle, int salary) {
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

}