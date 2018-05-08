package humanResources;

public class Department {
    private String name;
    private Employee[] employees;
    private int amountEmployees;
    public static final int DEFAULT_SIZE = 8;


    Department(String name) {
        this(name, new Employee[DEFAULT_SIZE]);
    }

    Department(String name, int size) {
        this(name, new Employee[size]);
    }

    Department(String name, Employee[] employees) {
        this.name = name;
        this.employees = employees;
        //todo without null
//       amountEmployees = amountNoNull(employees);
    }

    //todo refact
//    private int amountNoNull(Employee[] employees) {
//        int counter = 0;
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i] != null) {
//                counter++;
//            }
//        }
//        return counter;
//    }

    public void add(Employee employee) {
        if (amountEmployees < employees.length) {
            employees[amountEmployees++] = employee;
        } else {
            incArraySize();
            add(employee);
        }
    }

    public void incArraySize() {
        Employee[] employees = new Employee[this.employees.length * 2];
        System.arraycopy(this.employees, 0, employees, 0, this.employees.length);
        this.employees = employees;
    }

    public boolean remove(String firstName, String secondName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstName().equals(firstName)) {
                if (employees[i].getSecondName().equals(secondName)) {
                    System.arraycopy(employees, i + 1, employees, i, amountEmployees - i - 1);
                    employees[-- amountEmployees] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public int getAmountEmployees() {
        return amountEmployees;
    }

    public Employee[] getEmployees() {
        Employee[] employees = new Employee[amountEmployees];
        System.arraycopy(this.employees, 0, employees, 0, amountEmployees);
        return employees;
    }

    public Employee[] getEmployees(String jobTitle) {
        Employee[] employee = getEmployees();
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getJobTitle().equals(jobTitle)) {
                counter++;
            }
        }
        Employee[] employeeJobTitle = new Employee[counter];
        counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getJobTitle().equals(jobTitle)) {
                employeeJobTitle[counter++] = employee[i];
            }
        }
        return employeeJobTitle;

    }

    public int employeesQuantity(String jobTitle) {
        Employee[] employee = getEmployees();
        int counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getJobTitle().equals(jobTitle)) {
                counter++;
            }
        }
        Employee[] employeeJobTitle = new Employee[counter];
        counter = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getJobTitle().equals(jobTitle)) {
                employeeJobTitle[counter++] = employee[i];
            }
        }
        return employeeJobTitle.length;
    }

    public Employee bestEmployee() {
        Employee emp = null;
        double maxSalary = - 1;
        for (int i = 0; i < amountEmployees; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                emp = employees[i];
            }
        }
        return emp;
    }

    public boolean hasEmployee(String firstName, String secondName) {
        for (int i = 0; i < amountEmployees; i++) {
            if (employees[i].getFirstName().equals(firstName) && employees[i].getSecondName().equals(secondName)) {
                return true;
            }
        }
        return false;
    }

//        private Employee[] orderOfEmployees(Employee[] employees, int Pos, int amountEmployees){
//            for (int i=0;i<employees.length;i++){
//                System.out.println(employees[i]);
//            }
//            System.arraycopy(employees,Pos+1,employees,Pos,amountEmployees-Pos);
//            //employees[amountEmployees-2]=null;
//            for (int i=0;i<employees.length;i++){
//                System.out.println(employees[i]);
//            }
//            return employees;
//        } //todo обнулять концовку массива

    public int size() {
        return amountEmployees;
    }

    public Employee[] employeesSortedBySalary() {
        employees = getEmployees();
        quickSort();
        return employees;
    }

    public void quickSort() {
        int startIndex = 0;
        int endIndex = employees.length - 1;
        doSort(startIndex, endIndex);
    }

    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        Employee temp;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (employees[i].getSalary() >= employees[cur].getSalary())) {
                i++;
            }
            while (j > cur && (employees[cur].getSalary() >= employees[j].getSalary())) {
                j--;
            }
            if (i < j) {
                temp = employees[i];
                employees[i] = employees[j];
                employees[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur + 1, end);
    }

    public String getName() {
        return name;
    }
}
