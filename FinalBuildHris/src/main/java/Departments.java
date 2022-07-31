import java.sql.*;

public class Departments {
    private static String url=  "jdbc:mysql:///hris";
    private static String user = "root";
    private static String pw = "Password1";
    public static void displayDepartmentMenu(){

        System.out.println("Please select which function you'd like to perform  " +
                "\n1. Create new employee department information. \n2. Update existing employee department information. \n3. Delete employee department information. \n4. Show one employee department information. \n5. Show all employee department information." );
    }
    static void saveDepartment(String name, String country, String state,String province,int zip,String address, String depManager){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //CREATE
            boolean inserted = st.execute("insert into department(name,country,state,province,zip,address,department_manager" + ") " +
                    "VALUES('"+name+"','"+country+"','"+state+"','"+province+"','"+zip+"','"+address+"','"+depManager+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }

    static void deleteDepartment(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //DELETE
            boolean delete = st.execute("DELETE FROM department\n" +
                    "WHERE department_id =  '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    //Need to figure out how to return an error if updating an id DNE
    static void updateDepartment(String name, String country, String state,String province,int zip,String address, String depManager, int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //UPDATE
            boolean update = st.execute("UPDATE payroll\n" +
                    "SET\n" +
                    "name = '"+name+"',\n" +
                    "country = '"+country+"',\n" +
                    "state = '"+state+"',\n" +
                    "province = '"+province+"',\n" +
                    "zip = '"+zip+"',\n" +
                    "address = '"+address+"',\n" +
                    "department_manager = '"+depManager+"'\n" +
                    "WHERE department_id = '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void showOneDepartment(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from department where department_id= '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "\n " + "Department name: " + rs.getString("name") + "\n " + "Country: "
                        + rs.getString("country")+ "\n " + "State: " + rs.getString("state")+ "\n "+ "Province: " + rs.getString("province")+ "\n " +  "Zip: "+
                        rs.getString("zip") + "\n "+ "Address:  " +
                        rs.getString("address")+ "Department manager: " +
                        rs.getString("department_manager"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }
    static void showDepartment(){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from department";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Department ID: " + rs.getString("department_id") + "| " + "Department name: " + rs.getString("name") + "| " + "Country: "
                        + rs.getString("country")+ "| " + "State: " + rs.getString("state")+ "| "+ "Province: " + rs.getString("province")+ "| " +  "Zip: "+
                        rs.getString("zip") + "| "+ "Address: " + " "+
                        rs.getString("address")+ "| " + "Department manager: " + " "+
                        rs.getString("department_manager"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
}
