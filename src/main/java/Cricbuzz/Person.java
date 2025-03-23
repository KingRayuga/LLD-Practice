package Cricbuzz;

import java.util.UUID;

public class Person {
    private final UUID uuid;
    private final String name;
    private final int age;
    private final String nationality;

    Person(String name, int age, String nationality){
        uuid = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public UUID getUuid() {
        return uuid;
    }
}
