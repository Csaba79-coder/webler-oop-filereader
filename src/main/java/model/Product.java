package model;

import value.Unit;

public class Product {

    private int id; // 0 index
    private String name; // 1 index
    private double quantity; // 2 index
    private Unit unit; // if you do not want to use Unit as enum, you can use String instead eg. private String unit; // 3 index

    public Product() {
    }

    public Product(int id, String name, double quantity, Unit unit) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit=" + unit + // unit.toString().toLowerCase()
                '}';
    }
}
