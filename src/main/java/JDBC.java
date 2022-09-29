import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class JDBC {
    private static void listdrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("	"+driverClass.getClass().getName());
        }
    }

    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Surya@123";
        Connection con;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded !");
        }
        catch(ClassNotFoundException e){
            throw new IllegalStateException("Cannot Find The Driver in the Classpath !", e);
        }

        listdrivers();

        try {
            System.out.println("Connecting to the database : "+jdbcURL);
            con = DriverManager.getConnection(jdbcURL, userName, password);
            if(con.isClosed())
                System.out.println("Connection is not Established");
            else
                System.out.println("Connection Established successfully. " + con);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
