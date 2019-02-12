package controllers;

import com.google.inject.Inject;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Result;

import static play.mvc.Results.ok;


public class RegisterController {
    @Inject FormFactory formFactory;


    public Result addUserToDatabase() {
        System.out.println("Adding user to database");
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();

        String nameFirst = dynamicForm.get("nameFirst");
        String nameLast = dynamicForm.get("nameLast");
        String email = dynamicForm.get("email");
        String password = dynamicForm.get("password");
        String phone = dynamicForm.get("phone");
        String town = dynamicForm.get("town");
        String county = dynamicForm.get("county");
        String country = dynamicForm.get("country");

        String insertStatement = "Insert into users (firstname,lastname,email,userpassword,phonenumber,town,county,country) values (" +
                "'"+nameFirst+"',"+
                "'"+nameLast+"',"+
                "'"+email+"',"+
                "'"+password+"',"+
                "'"+phone+"',"+
                "'"+town+"',"+
                "'"+county+"',"+
                "'"+country+"'"+
                ");";


        SQLController sqlController = SQLController.getInstance();
        boolean isSuccess = sqlController.InsertToMySQL(insertStatement);
        System.out.println(insertStatement);

        if(isSuccess)
        {
            System.out.println("User Added");
            return ok("Registered Successfully");
        }
        else
        {
            System.out.println("Failed to add User");

            return ok("Registration Failed, Please Try Again");
        }
    }
}
