
public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double age;
    
    public  Student(int id, String name, double age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "id = " + id + "  name = " + name + "  age = " +age;
    }
    
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Student)){
           return false;
        }
        Student s = (Student) obj;
       
        return this.id == s.id && this.name.equals(s.name) && this.age == s.age;
    }

    @Override
    public int compareTo(Student o) {

        return equals(o) ? 0 : -1;
    }
}
