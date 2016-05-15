package controllers;

import play.mvc.Controller;
import play.mvc.Result;
/**
 * @method GET
 * @controller Main - rootPoint, needed to be called from start to init test data
 * @return string message
 */
public class Application extends Controller {

    public static Result index() {
        TestData.set();//test data initialization
        return ok("server is up");

    }

}
