import java.util.*;

public class SimulatedDataSet {

    public static void main(String[] args) {
        int numberOfInstances = 100; // Change this value to set the desired number of instances
        List<String> dataSet = generateUniqueInstances(numberOfInstances);
        
        // Display the generated unique instances
        for (String instance : dataSet) {
            System.out.println(instance);
        }
    }

    public static List<String> generateUniqueInstances(int numberOfInstances) {
        List<String> dataSet = new ArrayList<>();
        Set<String> uniqueSet = new HashSet<>();

        Random random = new Random();

        // Generate unique instances until the desired number is reached
        while (uniqueSet.size() < numberOfInstances) {
            // Generate a random instance (modify this logic based on your requirements)
            String instance = generateRandomInstance(random);
            
            // Check if the generated instance is unique, then add it to the dataset
            if (!uniqueSet.contains(instance)) {
                uniqueSet.add(instance);
                dataSet.add(instance);
            }
        }

        return dataSet;
    }

    // Method to generate a random instance (replace this with your custom logic)
    public static String generateRandomInstance(Random random) {
        // This is an example of a random instance generation
        // Modify this based on the structure and nature of your data
        int value1 = random.nextInt(100);
        int value2 = random.nextInt(50);
        String instance = "Instance-" + value1 + "-" + value2;
        return instance;
    }
}
