package lesson9;

import java.util.Objects;

public class Cource {
    private String name;

    public Cource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cource{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cource cource = (Cource) o;
        return Objects.equals(name, cource.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
