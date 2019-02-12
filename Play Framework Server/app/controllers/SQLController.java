package controllers;

import play.mvc.*;

import java.sql.*;

public class SQLController extends Controller{
    private Connection conn = null;
    private Statement stmt = null;
    private static SQLController singleton;



    public static SQLController getInstance()
    {
        if(singleton == null)
        {
            singleton = new SQLController();
        }
        return singleton;
    }

    private SQLController ()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/communitywatch","root","admin");
            stmt = conn.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public String getNumbers(){
        String number = "0";
        try {
            String sql = "SELECT * from users where id = 1";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                number  = rs.getString("phonenumber");
                System.out.print("number: " + number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }



    public boolean InsertToMySQL(String sql)
    {
        try {
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }







































    //Test Classes

    public Result testInsert(){


        try {
            String sql = "INSERT INTO users (FirstName, LastName, PhoneNumber) VALUES ('John', 'Doe', '+353545353')";
            stmt.executeUpdate(sql);
            return ok("User added");

        } catch (SQLException e) {
            e.printStackTrace();
            return ok("Failed to enter user");

        }
    }

    public Result test() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/communitywatch","root","admin");

        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * from users where id = 1";
        ResultSet rs = stmt.executeQuery(sql);
        String number = "nullllll";
        while(rs.next()){
            number  = rs.getString("phonenumber");
            System.out.print("name: " + number);
        }
        rs.close();
        stmt.close();
        conn.close();

        return ok("Returned: "+number);

    }
}
