package eltex.tasks;

public class Student {

    private String name;
    private String number;

    public Student () {

    	this.name = "Gena";
    	this.number = "+71421421542";
    };

    public Student (String name, String number) {

    	this.name = name;
    	this.number = number;
    }

    private String getName() {

    	return this.name;
    }

    private String getNumber() {

    	return this.number;
    }
}
