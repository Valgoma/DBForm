package com.example.dbform;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Liquer {
    int id;
    SimpleStringProperty label;
    SimpleFloatProperty volume;
    AlcoCategory category;
    SimpleStringProperty subcategory;
    SimpleStringProperty country;
    SimpleFloatProperty strength;
    SimpleFloatProperty sugar;
    SimpleIntegerProperty year;
    SimpleIntegerProperty age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label.get();
    }

    public SimpleStringProperty labelProperty() {
        return label;
    }

    public void setLabel(String label) {
        this.label.set(label);
    }

    public float getVolume() {
        return volume.get();
    }

    public SimpleFloatProperty volumeProperty() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume.set(volume);
    }

    public AlcoCategory getCategory() {
        return category;
    }

    public void setCategory(AlcoCategory category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory.get();
    }

    public SimpleStringProperty subcategoryProperty() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory.set(subcategory);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public float getStrength() {
        return strength.get();
    }

    public SimpleFloatProperty strengthProperty() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength.set(strength);
    }

    public float getSugar() {
        return sugar.get();
    }

    public SimpleFloatProperty sugarProperty() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar.set(sugar);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public Liquer(int id, String label, float volume, AlcoCategory category, String subcategory, String country, float strength, float sugar, int year, int age) {
      this.id = id;
        this.label = new SimpleStringProperty(label);
        this.volume = new SimpleFloatProperty(volume);
        this.category = category;
        this.subcategory = new SimpleStringProperty(subcategory);
        this.country = new SimpleStringProperty(country);
        this.strength = new SimpleFloatProperty(strength);
        this.sugar = new SimpleFloatProperty(sugar);
        this.year = new SimpleIntegerProperty(year);
        this.age = new SimpleIntegerProperty(age);
    }


}
