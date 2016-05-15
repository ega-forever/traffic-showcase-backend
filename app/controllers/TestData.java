package controllers;

import com.avaje.ebean.Ebean;
import models.Bus;
import models.Fuel;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@action TestData - upload test data to db
 */
public class TestData {

    public static void set() {

        List<Fuel> fuels = new ArrayList<>();
        fuels.add(new Fuel("AI-95", 123.4d));
        fuels.add(new Fuel("AI-98", 13.4d));
        fuels.add(new Fuel("AI-92", 165.2d));
        fuels.add(new Fuel("DT", 1653.1d));
        Ebean.save(fuels);

        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus("Super bas 1", fuels.get(0)));
        buses.add(new Bus("Super bas 2", fuels.get(1)));
        buses.add(new Bus("Super bas 3", fuels.get(2)));
        Ebean.save(buses);

    }
}
