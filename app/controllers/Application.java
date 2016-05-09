package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Result index() {
        TestData.set();
        return ok("server is up");

    }

}
