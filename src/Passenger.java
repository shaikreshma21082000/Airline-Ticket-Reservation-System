public class Passenger{
    String name;
    int age;
    long phnNo;
    String city;

    public Passenger(String name, int age, long phnNo, String city) {
        this.name = name;
        this.age = age;
        this.phnNo = phnNo;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phnNo=" + phnNo +
                ", city='" + city + '\'' +
                '}';
    }
}

