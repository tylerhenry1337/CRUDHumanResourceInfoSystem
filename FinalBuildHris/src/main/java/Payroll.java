import java.sql.*;

public class Payroll {
    private static String url=  "jdbc:mysql:///hris";
    private static String user = "root";
    private static String pw = "Password1";
    public static void displayPayrollMenu(){

        System.out.println("Please select which function you'd like to perform  " +
                "\n1. Create new employee payroll. \n2. Update existing employee payroll. \n3. Delete employee payroll information. \n4. Show one employee payroll information. \n5. Show all employee payroll information." );
    }
    static void savePayroll(int empId, String currencyType,double timeClock,double salary,double bonus){
        try {
            Connection con = DriverManager.getConnection(url,user,pw );
            Statement st = con.createStatement();
            //CREATE
            boolean inserted = st.execute("insert into payroll(empl_id,currency_type,time_clock,salary,bonus" + ") VALUES('"+empId+"','"+currencyType+"','"+timeClock+"','"+salary+"','"+bonus+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }

    static void deletePayroll(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //DELETE
            boolean delete = st.execute("DELETE FROM payroll\n" +
                    "WHERE empl_id =  '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    //Need to figure out how to return an error if updating an id DNE
    static void updatePayroll( String currencyType,double timeClock,double salary,double bonus, int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //UPDATE
            boolean update = st.execute("UPDATE payroll\n" +
                    "SET\n" +
                    "currency_type =  '"+currencyType+"',\n"+
                    "time_clock = '"+timeClock+"',\n" +
                    "salary = '"+salary+"',\n" +
                    "bonus = '"+bonus+"'\n" +
                    "WHERE empl_id = '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void showOnePayroll(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from payroll where empl_id = '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "\n " + "Tax id: " + rs.getString("tax_id") + "\n " + "Currency type: "
                        + rs.getString("currency_type")+ "\n " + "Hours worked: " + rs.getString("time_clock")+ "\n "+ "Salary: " + rs.getString("salary")+ "\n " +  "Bonus: "+
                        rs.getString("bonus"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }
    static void showPayroll(){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from payroll";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "| " + "Tax id: " + rs.getString("tax_id") + "| " + "Currency type: "
                        + rs.getString("currency_type")+ "| " + "Hours worked: " + rs.getString("time_clock")+ "| "+ "Salary: " + rs.getString("salary")+ "| " +  "Bonus: "+
                        rs.getString("bonus"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }

}
