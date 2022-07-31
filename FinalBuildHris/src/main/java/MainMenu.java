import java.util.Scanner;

public class MainMenu {
    public static void mainMenu(){
        System.out.println("Hello welcome to Mcmillan & Son human resources information system." +
                "\n Please type the corresponding number for the type of information you'd like to modify\n" +
                "1. Employee Information\n2. Payroll Information\n3. Employee Benefits Information\n4. Department Information");

    }
    public static void main(String[] args){
        Employee emp = new Employee();
        Payroll pr = new Payroll();
        Benefits ben = new Benefits();
        Departments dep = new Departments();
        Scanner sc = new Scanner(System.in);
        mainMenu();
        int mainMenuInput = sc.nextInt();
        //Employee info scanner code
        if(mainMenuInput == 1){
            emp.displayEmployeeMenu();
            int menuInput = sc.nextInt();
            if(menuInput == 1){
                System.out.println("Please enter first name ");
                String fullName = sc.next();
                System.out.println("Please enter last name ");
                String lastName = sc.next();
                System.out.println("Please enter employee address ");
                String address = sc.next();
                System.out.println("Please enter employee city ");
                String city = sc.next();
                System.out.println("Please enter employee state ");
                String state = sc.next();
                System.out.println("Please enter employee zip ");
                int zip = sc.nextInt();
                System.out.println("Please enter employee country ");
                String country = sc.next();
                System.out.println("Please enter employee DOB ");
                String dob = sc.next();
                System.out.println("Please enter employee SSN ");
                String ssn = sc.next();
                System.out.println("Please enter job title ");
                String title = sc.next();
                System.out.println("Please enter employees department id");
                int depId = sc.nextInt();
                emp.saveEmployee(fullName,lastName,address,city,state,zip,country,dob,ssn,title,depId);
            }
            else if(menuInput == 2){
                System.out.println("Please enter updated first name ");
                String fullName = sc.next();
                System.out.println("Please enter updated last name ");
                String lastName = sc.next();
                System.out.println("Please enter updated employee address ");
                String address = sc.next();
                System.out.println("Please enter updated employee city ");
                String city = sc.next();
                System.out.println("Please enter updated employee state ");
                String state = sc.next();
                System.out.println("Please enter updated employee zip ");
                int zip = sc.nextInt();
                System.out.println("Please enter updated employee country ");
                String country = sc.next();
                System.out.println("Please enter updated employee DOB ");
                String dob = sc.next();
                System.out.println("Please enter updated employee SSN ");
                String ssn = sc.next();
                System.out.println("Please enter updated job title ");
                String title = sc.next();
                System.out.println("Please enter updated employee department ID. ");
                int depId = sc.nextInt();
                System.out.println("Please enter employee ID of the employee whose information you'd like to update ");
                int id = sc.nextInt();
                emp.updateEmployee(fullName,lastName,address,city,state,zip,country,dob,ssn,title, id,depId);
            }
            else if (menuInput == 3) {
                System.out.println("Please enter employee ID of the employee whose information you'd like to delete ");
                int id = sc.nextInt();
                emp.deleteEmployee(id);
            }
            else if (menuInput==4) {
                System.out.println("Please enter employee ID of the employee whose information you'd like to view ");
                int id = sc.nextInt();
                emp.showOneEmployee(id);
            }
            else if (menuInput==5) {
                System.out.println("Showing all employees: ");
                emp.showEmployees();

            }
            else{
                System.out.println("Please enter a valid menu option.");
            }

        }
        //Payroll info scanner code
        else if (mainMenuInput ==2) {
            pr.displayPayrollMenu();
            int menuInput2 = sc.nextInt();
            if(menuInput2 == 1){
                System.out.println("Please enter employee Id ");
                int empId = sc.nextInt();
                System.out.println("Please enter employees expected currency type. ");
                String currency = sc.next();
                System.out.println("Please enter employee worked hours for the last two week period ");
                Double timeClock = sc.nextDouble();
                System.out.println("Please enter employee salary ");
                Double salary = sc.nextDouble();
                System.out.println("Please enter employee bonus ");
                Double bonus = sc.nextDouble();
                pr.savePayroll(empId,currency,timeClock,salary,bonus);

            } else if (menuInput2 == 2) {
                System.out.println("Please enter employee Id to update payroll information. ");
                int empId = sc.nextInt();
                System.out.println("Please enter employees updated expected currency type. ");
                String currency = sc.next();
                System.out.println("Please enter employee updated worked hours for the last two week period ");
                Double timeClock = sc.nextDouble();
                System.out.println("Please enter updated employee salary ");
                Double salary = sc.nextDouble();
                System.out.println("Please enter updated employee bonus ");
                Double bonus = sc.nextDouble();
                pr.updatePayroll(currency, timeClock, salary, bonus, empId);
            } else if (menuInput2 == 3) {
                System.out.println("Please enter employee ID of the employee whose payroll information you'd like to delete ");
                int id = sc.nextInt();
                pr.deletePayroll(id);
            } else if (menuInput2==4) {
                System.out.println("Please enter employee ID of the employee whose payroll information you'd like to view ");
                int id = sc.nextInt();
                pr.showOnePayroll(id);
            } else if (menuInput2==5) {
                System.out.println("Showing all employees payroll information: ");
                pr.showPayroll();
            }else{
                System.out.println("Please enter a valid menu option.");
            }

        }
        //Benefits scanner code
        else if (mainMenuInput ==3) {
            ben.displayBenefitsMenu();
            int menuInput3 = sc.nextInt();
            if(menuInput3 == 1){
                System.out.println("Please enter employee Id. ");
                int empId = sc.nextInt();
                System.out.println("Please enter employees company savings plan. ");
                String savings = sc.next();
                System.out.println("Please enter employee retirement plan. ");
                String retirement = sc.next();
                System.out.println("Please enter employee paid time off ");
                Double pto = sc.nextDouble();
                System.out.println("Please enter employee sick days. ");
                Double sDays = sc.nextDouble();
                System.out.println("Please enter employee perosnal days. ");
                Double pDays = sc.nextDouble();
                System.out.println("Please enter employees company perks. ");
                String perks = sc.next();
                ben.saveBenefits(empId,savings,retirement,pto,sDays,pDays,perks);

            } else if (menuInput3 == 2) {
                System.out.println("Please enter employee Id. ");
                int empId = sc.nextInt();
                System.out.println("Please enter employees updated company savings plan. ");
                String savings = sc.next();
                System.out.println("Please enter employees updated retirement plan. ");
                String retirement = sc.next();
                System.out.println("Please enter employees updated paid time off ");
                Double pto = sc.nextDouble();
                System.out.println("Please enter employees updated sick days. ");
                Double sDays = sc.nextDouble();
                System.out.println("Please enter employees updated personal days. ");
                Double pDays = sc.nextDouble();
                System.out.println("Please enter employees updated company perks. ");
                String perks = sc.next();
                ben.updateBenefits(empId, savings, retirement, pto, sDays, pDays, perks);
            } else if (menuInput3 == 3) {
                System.out.println("Please enter employee ID of the employee whose payroll information you'd like to delete ");
                int id = sc.nextInt();
                ben.deleteBenefits(id);
            } else if (menuInput3==4) {
                System.out.println("Please enter employee ID of the employee whose payroll information you'd like to view ");
                int id = sc.nextInt();
                ben.showOneBenefits(id);
            } else if (menuInput3==5) {
                System.out.println("Showing all employees payroll information: ");
                ben.showBenefits();
            }else{
                System.out.println("Please enter a valid menu option.");
            }

        }
        //Departments scanner code
        else if (mainMenuInput ==4) {
            dep.displayDepartmentMenu();
            int menuInput4 = sc.nextInt();
            if(menuInput4 == 1){
                System.out.println("Please enter department name. ");
                String name = sc.next();
                System.out.println("Please enter department country. ");
                String country = sc.next();
                System.out.println("Please enter department state. ");
                String state = sc.next();
                System.out.println("Please enter department province. ");
                String province = sc.next();
                System.out.println("Please enter department zip. ");
                int zip = sc.nextInt();
                System.out.println("Please enter department address. ");
                String address = sc.next();
                System.out.println("Please enter department manager name. ");
                String depManager = sc.next();
                dep.saveDepartment(name, country, state, province, zip, address, depManager);

            } else if (menuInput4 == 2) {
                System.out.println("Please enter department id you'd like to update. ");
                int depId = sc.nextInt();
                System.out.println("Please enter updated department name. ");
                String name = sc.next();
                System.out.println("Please enter updated department country. ");
                String country = sc.next();
                System.out.println("Please enter updated department state. ");
                String state = sc.next();
                System.out.println("Please enter updated department province. ");
                String province = sc.next();
                System.out.println("Please enter updated department zip. ");
                int zip = sc.nextInt();
                System.out.println("Please enter updated department address. ");
                String address = sc.next();
                System.out.println("Please enter updated department manager name. ");
                String depManager = sc.next();
                dep.updateDepartment(name, country, state, province, zip, address, depManager, depId);
            } else if (menuInput4 == 3) {
                System.out.println("Please enter department ID of the department you'd like to delete.");
                int id = sc.nextInt();
                dep.deleteDepartment(id);
            } else if (menuInput4==4) {
                System.out.println("Please enter the department ID of the department you'd like to view. ");
                int id = sc.nextInt();
                dep.showOneDepartment(id);
            } else if (menuInput4==5) {
                System.out.println("Showing all departments. ");
                dep.showDepartment();
            }else{
                System.out.println("Please enter a valid menu option.");
            }

        }
    }
}
