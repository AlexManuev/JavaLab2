package humanResources;

public class Test {

    public static void main(String[] args) {
        System.out.println("");


        System.out.println("              DEPARTMENTS");

        //                                              SOFTWARE DEPARTMENT

        Department softwareDepartment = new Department("Software Department");
        Employee emp10 = new Employee("Esmeralda", "Shannen", "Software Developer", 1000);
        Employee emp11 = new Employee("Raphael", "Castruita", "Web Programmer", 5000);
        Employee emp12 = new Employee("Calvin", "Tongue", "Java programmer", 7500);

        softwareDepartment.add(emp10);
        softwareDepartment.add(emp11);
        softwareDepartment.add(emp12);

        //                                              MARKETING DEPARTMENT

        Department marketingDepartment = new Department("Marketing Department");
        Employee emp20 = new Employee("Jeffrey", "Bezos", "SEO Manager", 10000);
        Employee emp21 = new Employee("Willian", "Amy", "SMM Analyst", 13000);
        Employee emp22 = new Employee("Philip", "Schiller", "Vice President for Marketing", 15000);
        marketingDepartment.add(emp20);
        marketingDepartment.add(emp21);
        marketingDepartment.add(emp22);

        //                                              EVENT DEPARTMENT

        Department eventDepartment = new Department("Event Department");
        Employee emp30 = new Employee("Georgetta", "Ozment", "Event Planner", 10000);
        Employee emp31 = new Employee("Leigh", "Hankinson", "Meeting Planner", 13000);
        Employee emp32 = new Employee("Jessia", "Kindred", "Festival Organizer", 15000);
        eventDepartment.add(emp30);
        eventDepartment.add(emp31);
        eventDepartment.add(emp32);

        System.out.println("Общее количество работников: " + softwareDepartment.getAmountEmployees());
        softwareDepartment.remove("Calvin", "Tongue");
        System.out.println("Общее количество работников после удаления: " + softwareDepartment.getAmountEmployees());
        System.out.println("");
        System.out.println("Массив сотрудников:");

        for (int i = 0; i < softwareDepartment.getEmployees().length; i++) {
            System.out.println(i + 1 + " - " + softwareDepartment.getEmployees()[i].getFirstName() + " " + softwareDepartment.getEmployees()[i].getSecondName() + " - " + softwareDepartment.getEmployees()[i].getJobTitle() + " - " + softwareDepartment.getEmployees()[i].getSalary());
        }

        System.out.println("");
        System.out.println("Массив сотрудников занимающих заданную должность (Web Programmer):");
        for (int i = 0; i < softwareDepartment.getEmployees("Web Programmer").length; i++) {
            System.out.println(i + 1 + " - " + softwareDepartment.getEmployees("Web Programmer")[i].getFirstName() + " " + softwareDepartment.getEmployees("Web Programmer")[i].getSecondName() + " - " + softwareDepartment.getEmployees("Web Programmer")[i].getJobTitle() + " - " + softwareDepartment.getEmployees("Web Programmer")[i].getSalary());
        }

        System.out.println("");
        System.out.println("Массив сотрудников отсортированный по убыванию зарплаты");
        for (int i = 0; i < softwareDepartment.getEmployees().length; i++) {
            System.out.println(i + 1 + " - " + softwareDepartment.employeesSortedBySalary()[i].getFirstName() + " " + softwareDepartment.employeesSortedBySalary()[i].getSecondName() + " - " + softwareDepartment.employeesSortedBySalary()[i].getJobTitle() + " - " + softwareDepartment.employeesSortedBySalary()[i].getSalary());
        }
        System.out.println("");

        //                              ORGANIZATION


        Organization org1 = new Organization("Apple");
        org1.add(softwareDepartment);
        org1.add(marketingDepartment);
        Organization org2 = new Organization("Google");
        org2.add(eventDepartment);
        System.out.println("Общее количество департаментов: " + org1.getAmountDepartments());
        org1.remove("Software Department");
        System.out.println("Общее количество департаментов после удаления: " + org1.getAmountDepartments());
        org1.getDepartment("Marketing Department");
        System.out.println("Общее число сотрудников в организации - " + org1.employeesQuantity());
        System.out.println("Число сотрудников занимающих заданную должность (SEO Manager) - " + org1.employeesQuantity("SEO Manager"));
        System.out.println("Сотрудник с максимальной зарплатой - " + org1.bestEmployee().getFirstName() + " " + org1.bestEmployee().getSecondName() + " - " + org1.bestEmployee().getJobTitle() + " - " + org1.bestEmployee().getSalary());
        System.out.println("Сотрудник Willian Amy работает в - " + org1.getEmployeesDepartment("Willian", "Amy").getName());

        System.out.println("");
        System.out.println("ТЕСТИРОВАНИЕ ДОБАВОЧНЫХ МЕТОДОВ В ДЕПАРТМЕНТЕ");
        System.out.println("1 метод, Число сотрудников занимающих заданную должность (SMM Analyst) – " + marketingDepartment.employeesQuantity("SMM Analyst"));
        System.out.println("2 метод, Сотрудник с наивысшей зарплатой в отделе маркетинга – " + marketingDepartment.bestEmployee().getSalary() + " " + marketingDepartment.bestEmployee().getFirstName() + " " + marketingDepartment.bestEmployee().getSecondName());
        System.out.println("3 метод, есть ли сотрудник в отделе? (William Amy) – " + marketingDepartment.hasEmployee("William", "Amy"));
    }


}
