package controllers;

import models.Bus;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * @factory NSI - store get accessors for ORM entities
 */
public class Nsi extends Controller {

    public static Result getBus() {

        return ok(Json.toJson(Bus.find.all()));

    }
}
