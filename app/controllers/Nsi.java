package controllers;

import models.Bus;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * Created by Egor on 07.05.2016.
 */
public class Nsi extends Controller {

    public static Result getBus() {

        return ok(Json.toJson(Bus.find.all()));

    }
}
