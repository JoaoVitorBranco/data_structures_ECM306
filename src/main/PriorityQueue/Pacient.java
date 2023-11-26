package main.PriorityQueue;

public class Pacient {
    public int id;
    public String name;
    public int priority;

    public Pacient(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public String toString(){
        return this.name + ":" + this.priority + this.id;
    }
}
