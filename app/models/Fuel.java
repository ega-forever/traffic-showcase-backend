package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Egor on 07.05.2016.
 */
@Entity
@Table(name = "Fuel")
public class Fuel extends Model {

    public Fuel(){}

    public Fuel(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public static Finder<Long, Fuel> find = new Finder<>(Fuel.class);


    @Id
    @Column(name = "ID")
    public Long Id;

    @Column(name = "PRICE")
    public Double price;

    @Column(name = "NAME")
    public String name;

}
