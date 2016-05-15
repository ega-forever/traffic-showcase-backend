package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Bus;
import org.apache.commons.lang3.math.NumberUtils;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Map;

/**
 * @method GET
 * @params: busId, distance
 * @controller Calculate - calculates total income by bus type and distance
 * @return json message
 */
public class Calculate extends Controller {

    public static Result get() {

        Map<String, String[]> params = Controller.request().queryString();
        Logger.debug(params.toString());

        Long busId = params.get("busId") == null || !NumberUtils.isNumber(params.get("busId")[0]) ? null : Long.parseLong(params.get("busId")[0]);
        Double distance = params.get("distance") == null || !NumberUtils.isNumber(params.get("distance")[0]) ? null : Double.parseDouble(params.get("distance")[0]);
        if (busId == null || distance == null) {
            return ok();
        }

        Bus bus = Bus.find.fetch("fuel").where().eq("Id", busId).findUnique();

        if (bus == null || bus.fuel == null) {
            return ok();
        }


        ObjectNode node = Json.newObject();
        node.put("calculated", bus.fuel.price * distance);
        node.put("fuelType", bus.fuel.name);
        node.put("distance", distance + " km");
        node.put("total income", bus.fuel.price * distance * 1.2);


        return ok(node);
    }
}
