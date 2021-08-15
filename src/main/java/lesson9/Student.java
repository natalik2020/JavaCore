package lesson9;

import java.util.List;

public class Student {
    private String name;
    private List<Cource> cources;

    public Student(String name, List<Cource> cources) {
        this.name = name;
        this.cources = cources;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cource> getCources() {
        return cources;
    }

    public void setCources(List<Cource> cources) {
        this.cources = cources;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cources=" + cources +
                '}';
    }
}
