import java.util.*;

class Car implements Comparable<Car> {
    private String VIN;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;
    
    public Car(String VIN, String model, String manufacturer, int year, int mileage, double price) {
        this.VIN = VIN;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Objects.equals(VIN, car.VIN);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(VIN);
    }
    
    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year);
    }
    
    public String getVIN() { return VIN; }
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }
    public double getPrice() { return price; }
    
    @Override
    public String toString() {
        return String.format("Car{VIN='%s', model='%s', manufacturer='%s', year=%d, mileage=%d, price=%.2f}", 
                           VIN, model, manufacturer, year, mileage, price);
    }
}

public class Task2_3 {
    public static void main(String[] args) {
        Set<Car> carSet = new HashSet<>();
        
        Car car1 = new Car("VIN001", "Camry", "Toyota", 2020, 30000, 25000);
        Car car2 = new Car("VIN002", "X5", "BMW", 2022, 15000, 60000);
        Car car3 = new Car("VIN001", "Corolla", "Toyota", 2018, 45000, 18000);
        Car car4 = new Car("VIN003", "Civic", "Honda", 2021, 20000, 22000);
        Car car5 = new Car("VIN002", "X3", "BMW", 2019, 35000, 40000);
        
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        carSet.add(car4);
        carSet.add(car5);
        
        System.out.println("Машины в HashSet (дубликаты по VIN не добавлены):");
        for (Car car : carSet) {
            System.out.println(car);
        }
        
        List<Car> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);
        
        System.out.println("\nОтсортированные по году (от новых к старым):");
        for (Car car : sortedCars) {
            System.out.println(car);
        }
    }
}
