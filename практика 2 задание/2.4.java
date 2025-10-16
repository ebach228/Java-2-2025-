import java.util.*;
import java.util.stream.Collectors;
public class Task2_4 {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
            new Car("VIN101", "Model S", "Tesla", 2023, 10000, 80000),
            new Car("VIN102", "Camry", "Toyota", 2021, 60000, 25000),
            new Car("VIN103", "X5", "BMW", 2022, 30000, 65000),
            new Car("VIN104", "Civic", "Honda", 2020, 45000, 22000),
            new Car("VIN105", "Model 3", "Tesla", 2023, 15000, 45000),
            new Car("VIN106", "A4", "Audi", 2021, 55000, 35000),
            new Car("VIN107", "Corolla", "Toyota", 2019, 40000, 20000),
            new Car("VIN108", "iX", "BMW", 2023, 5000, 90000)
        );
        
        List<Car> lowMileageCars = cars.stream()
            .filter(car -> car.getMileage() < 50000)
            .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
            .collect(Collectors.toList());
        
        System.out.println("Топ-3 самые дорогие машины с пробегом < 50.000 км:");
        lowMileageCars.stream()
            .limit(3)
            .forEach(System.out::println);
        
        double averageMileage = cars.stream()
            .mapToInt(Car::getMileage)
            .average()
            .orElse(0.0);
        System.out.println("\nСредний пробег всех машин: " + averageMileage + " км");
        
        Map<String, List<Car>> carsByManufacturer = cars.stream()
            .collect(Collectors.groupingBy(Car::getManufacturer));
        
        System.out.println("\nМашины сгруппированные по производителю:");
        carsByManufacturer.forEach((manufacturer, carList) -> {
            System.out.println(manufacturer + ": " + carList.size() + " машин(ы)");
            carList.forEach(car -> System.out.println("  - " + car.getModel() + " (" + car.getYear() + ")"));
        });
    }
}