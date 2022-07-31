import java.sql.*;

public class Employee {
    private static String url = "jdbc:mysql:///hris";
    private static String user = "root";
    private static String pw = "Password1";
    public static void displayEmployeeMenu(){
        System.out.println("Please select which function you'd like to perform " +
                "\n1. Create new employee. \n2. Update existing employee. \n3. Delete employee information. \n4. Find a single employee. \n5. Show all employee information." );
    }
    static void saveEmployee(String firstName,String lastName,String address,String city,String state, int zip, String country, String dob,String ssn, String title, int depId){
        try {
            Connection con = DriverManager.getConnection(url,user,pw );
            Statement st = con.createStatement();
            //CREATE
            boolean inserted = st.execute("insert into employee(fname,lname,address,city,state," +
                    "zip,country,dob,ssn," +
                    "job_type" +
                    "department_id) VALUES('"+firstName+"','"+lastName+"','"+address+"','"+city+"','"+state+"'," +
                    "'"+zip+"','"+country+"'," +
                    "'"+dob+"','"+ssn+"','"+title+"','"+depId+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }

    static void deleteEmployee(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //DELETE
            boolean delete = st.execute("DELETE FROM employee\n" +
                    "WHERE empl_id =  '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    //Need to figure out how to return an error if updating an id DNE
    static void updateEmployee(String firstName,String lastName,String address,String city,String state, int zip, String country, String dob,String ssn, String title, int id, int depId){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //UPDATE

            boolean update = st.execute("UPDATE employee\n" +
                    "SET\n" +
                    "fname =  '"+firstName+"',\n"+
                    "lname = '"+lastName+"',\n" +
                    "address = '"+address+"',\n" +
                    "city = '"+city+"',\n" +
                    "state = '"+state+"',\n" +
                    "zip = '"+zip+"',\n" +
                    "country = '"+country+"',\n" +
                    "dob = '"+dob+"',\n" +
                    "ssn = '"+ssn+"',\n" +
                    "job_type = '"+title+"',\n" +
                    "department_id = '"+depId+"'\n" +
                    "WHERE empl_id = '"+id+"';");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void showOneEmployee(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from employee where empl_id = '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "\n " + "First name: " + rs.getString("fname") + "\n " + "Last name: "
                        + rs.getString("lname")+ "\n " + "Address: " + rs.getString("address")+ "\n "+ "City: " + rs.getString("city")+ "\n " +  "State: "+
                        rs.getString("state")+ "\n " +  "Zip code: " + rs.getString("zip")+ "\n " +"Country: " + rs.getString("country")+ "\n " + "Date of birth: " +
                        rs.getString("dob")+ "\n " + "SSN: " + rs.getString("ssn")+ "\n " + "Job title: " + rs.getString("job_type")+ "Department ID: " + rs.getString("department_id"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }
    static void showEmployees(){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from employee";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "| " + "First name: " + rs.getString("fname") + "| " + "Last name: "
                        + rs.getString("lname")+ "| " + "Address: " + rs.getString("address")+ " "+ "City: " + rs.getString("city")+ "| " +  "State: "+
                        rs.getString("state")+ "| " +  "Zip code: " + rs.getString("zip")+ "| " +"Country: " + rs.getString("country")+ "| " + "Date of birth: " +
                        rs.getString("dob")+ "| " + "SSN: " + rs.getString("ssn")+ "| " + "Job title: " + rs.getString("job_type")+ "| " + "Department ID: " + rs.getString("department_id"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
}
