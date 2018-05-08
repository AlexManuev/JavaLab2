package humanResources;

public class Organization {
    private String name;
    private Department[] departments;
    private static final int DEFAULT_SIZE = 1;
    private int amountDepartments;

    Organization(String name) {
        this(name, new Department[DEFAULT_SIZE]);
    }

    Organization(String name, Department[] departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Department department) {
        if (amountDepartments < departments.length) {
            departments[amountDepartments] = department;
            amountDepartments++;
        } else {
            incArraySize();
            add(department);
        }
    }

    public void incArraySize() {
        Department[] departments = new Department[this.departments.length * 2];
        System.arraycopy(this.departments, 0, departments, 0, this.departments.length);
        this.departments = departments;
    }

    public void remove(String name) {
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                if (departments[i].getName().equals(name)) {
                    System.arraycopy(departments, i + 1, departments, i, amountDepartments - i - 1);
                    amountDepartments--;
                    return;
                }
            }
        }
    }

    public Department getDepartment(String name) {
        for (int i = 0; i < amountDepartments; i++) {
            if (departments[i] != null) {
                if (departments[i].getName().equals(name)) {
                    return departments[i];
                }
            }
        }
        return null;
    }

    public Department[] getDepartments() {
        Department[] departments = new Department[amountDepartments];
        System.arraycopy(this.departments, 0, departments, 0, amountDepartments);
        return departments;
    }


    public int getAmountDepartments() {
        return amountDepartments;
    }

    public int employeesQuantity() {
        int employeesQuantity = 0;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                employeesQuantity += departments[i].getAmountEmployees();
            }
        }
        return employeesQuantity;
    }
    //todo сделай метод в департаменте - employeesQuantity(jobtitle)
    public int employeesQuantity(String jobTitle) {
        int ind=0;
        for (int i =0; i<amountDepartments;i++) {
            ind += departments[i].getEmployees(jobTitle).length;
        }
        return ind;
    }

    //todo сделай функция в департаменте bestEmployee()
    public Employee bestEmployee() {
        Employee employee = departments[0].employeesSortedBySalary()[0];
        for (int i = 1; i < amountDepartments; i++) {
            if (departments[i].employeesSortedBySalary()[0].getSalary() > employee.getSalary()) {
                employee=departments[i].employeesSortedBySalary()[0];
            }
        }
        return employee;
    }
    //todo сделай функция в департаменте hasEmployee(fname sname)
    public Department getEmployeesDepartment(String firstName, String secondName) {
        for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments[i].getEmployees().length; j++) {
                if (departments[i].getEmployees()[j].getFirstName().equals(firstName)) {
                    if (departments[i].getEmployees()[j].getSecondName().equals(secondName)) {
                        return departments[i];
                    }
                }
            }
        }
        return null;
    }
}

