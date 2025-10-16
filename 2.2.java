import java.util.*;

public class Task2_2 {
    public static void main(String[] args) {
        List<String> carModels = Arrays.asList(
            "Toyota Camry", "BMW X5", "Tesla Model S", "Honda Civic", 
            "Toyota Camry", "Tesla Model 3", "Audi A4", "BMW X5"
        );
        
        List<String> noDuplicates = new ArrayList<>(new LinkedHashSet<>(carModels));
        
        noDuplicates.sort(Collections.reverseOrder());
        
        for (int i = 0; i < noDuplicates.size(); i++) {
            if (noDuplicates.get(i).contains("Tesla")) {
                noDuplicates.set(i, "ELECTRO_CAR");
            }
        }
        
        System.out.println("Обработанные модели: " + noDuplicates);
        
        Set<String> modelSet = new HashSet<>(noDuplicates);
        System.out.println("Set моделей: " + modelSet);
    }
}
