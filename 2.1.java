import java.util.Random;

public class Task2_1 {
    public static void main(String[] args) {
        int[] carYears = new int[50];
        Random rand = new Random();
        
        for (int i = 0; i < carYears.length; i++) {
            carYears[i] = 2000 + rand.nextInt(26);
        }
        
        System.out.println("Машины после 2015 года:");
        int totalAge = 0;
        for (int year : carYears) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
            totalAge += (2025 - year);
        }
        
        double averageAge = (double) totalAge / carYears.length;
        System.out.println("\nСредний возраст авто: " + averageAge + " лет");
    }
}
