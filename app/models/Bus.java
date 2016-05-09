package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Egor on 07.05.2016.
 */
@Entity
@Table(name = "BUS")
public class Bus extends Model {

    public Bus() {
    }

    public Bus(String name, Fuel fuel) {
        this.name = name;
        this.fuel = fuel;
    }


    public static Finder<Long, Bus> find = new Finder<>(Bus.class);


    @Id
    @Column(name = "ID")
    public Long Id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "FUEL_KIND_ID")
    public Fuel fuel;

    @Column(name = "NAME")
    public String name;

}
