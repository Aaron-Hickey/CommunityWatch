package controllers;

import com.google.inject.Inject;
import play.mvc.Result;
import views.html.index;
import play.data.DynamicForm;
import play.data.FormFactory;

import static play.mvc.Results.ok;

public class ReportController {
   @Inject FormFactory formFactory;

    public Result handleReport() {

        System.out.println("volley http POST mapped correctly to this method.");
      //  DynamicForm dynamicForm = formFactory.form().bindFromRequest();
     //   System.out.println("Description: " + dynamicForm.get("description"));
     //   System.out.println("Latitude: " + dynamicForm.get("latitude"));
      //  System.out.println("Longitude: " + dynamicForm.get("longitude"));

     //   SQLController sqlc = SQLController.getInstance();
     //   String number = sqlc.getNumbers();

     //   SMSController smsc = new SMSController();
     //   smsc.sendSMS("Athlone", "Test Message", "Test User", number);

        return ok(index.render("WORK"));

    }
}
