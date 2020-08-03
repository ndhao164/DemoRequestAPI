package demo.demo.entity;

public class Demo {

    private int id;
    private String name;

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

    public Demo(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Demo() {
        super();
    }

    @Override
    public String toString() {
        return "Demo [id=" + id + ", name=" + name + "]";
    }

}
