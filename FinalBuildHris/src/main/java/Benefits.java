import java.sql.*;

public class Benefits {
    private static String url=  "jdbc:mysql:///hris";
    private static String user = "root";
    private static String pw = "Password1";

    public static void displayBenefitsMenu(){

        System.out.println("Please select which function you'd like to perform  " +
                "\n1. Create new employee benefits. \n2. Update existing employee benefits. \n3. Delete employee benefits information. \n4. Show one employee benefits information. \n5. Show all employee benefits information." );
    }
    static void saveBenefits(int empId,String savings, String retirement, double pto,double sickDays,double pDays, String cPerks){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //CREATE
            boolean inserted = st.execute("insert into benefits(empl_id,savings,retirement,pto,sick_days,personal_days,company_perks" + ") VALUES('"+empId+"','"+savings+"','"+retirement+"','"+pto+"','"+sickDays+"','"+pDays+"','"+cPerks+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }

    static void deleteBenefits(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //DELETE
            boolean delete = st.execute("DELETE FROM benefits\n" +
                    "WHERE empl_id =  '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    //Need to figure out how to return an error if updating an id DNE
    static void updateBenefits(int id,String savings, String retirement, double pto,double sickDays,double pDays, String cPerks){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //UPDATE
            boolean update = st.execute("UPDATE payroll\n" +
                    "SET\n" +
                    "savings = '"+savings+"',\n" +
                    "retirement = '"+retirement+"',\n" +
                    "pto = '"+pto+"',\n" +
                    "sick_days = '"+sickDays+"',\n" +
                    "personal_days = '"+pDays+"',\n" +
                    "company_perks = '"+cPerks+"'\n" +
                    "WHERE empl_id = '"+id+"'");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
    static void showOneBenefits(int id){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from benefits where empl_id = '"+id+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "\n " + "Comapny saving options: " + rs.getString("savings") + "\n " + "Company retirement plans: "
                        + rs.getString("retirement")+ "\n " + "Paid time off(hours): " + rs.getString("pto")+ "\n "+ "Employee sick days(hours): " + rs.getString("sick_days")+ "\n " +  "Employee personal days(hours): "+
                        rs.getString("personal_days") + "\n "+ "Employees company perks:  " +
                        rs.getString("company_perks"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }

    }
    static void showBenefits(){
        try {
            Connection con = DriverManager.getConnection(url,user,pw);
            Statement st = con.createStatement();
            //READ
            String query = "select * from benefits";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("Employee Id: " + rs.getString("empl_id") + "| " + "Comapny saving options: " + rs.getString("savings") + "| " + "Company retirement plans: "
                        + rs.getString("retirement")+ "| " + "Paid time off: " + rs.getString("pto")+ "| "+ "Employee sick days: " + rs.getString("sick_days")+ "| " +  "Employee personal days: "+
                        rs.getString("personal_days") + "| "+ "Employees company perks:  " +
                        rs.getString("company_perks"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){

        }
    }
}
