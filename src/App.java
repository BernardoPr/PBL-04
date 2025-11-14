public class App {
    public static void main(String[] args) throws Exception {
        String[] dataTypes = {"aleatorio", "crescente", "decrescente"};
        int[] sizes = {100, 1000, 10000};
        
        System.out.println("\n╔════════════════════╦═════════════════╦═════════════════╦═════════════════╗");
        System.out.println("║                    ║ Bubble Sort     ║ Insertion Sort  ║ Quick Sort      ║");
        System.out.println("╠════════════════════╬═════════════════╬═════════════════╬═════════════════╣");
        
        for (String dataType : dataTypes) {
            for (int size : sizes) {
                String fileName = "src/Dados/" + dataType + "_" + size + ".csv";
                String rowLabel = dataType + "_" + size;
                
                int[] originalData = DataReader.readCSV(fileName);
                
                double bubbleTime = measureSortNumeric(DataReader.copyArray(originalData), "bubbleSort");
                double insertionTime = measureSortNumeric(DataReader.copyArray(originalData), "insertionSort");
                double quickTime = measureSortNumeric(DataReader.copyArray(originalData), "quickSort");
                
                System.out.printf("║ %-18s ║ %-15s ║ %-15s ║ %-15s ║%n",
                    rowLabel, 
                    String.format("%.2f ms", bubbleTime),
                    String.format("%.2f ms", insertionTime),
                    String.format("%.2f ms", quickTime));
            }
        }
        
        System.out.println("╚════════════════════╩═════════════════╩═════════════════╩═════════════════╝");
    }
    
    private static double measureSortNumeric(int[] data, String method) {
        long startTime = System.nanoTime();
        
        switch (method) {
            case "bubbleSort":
                SortingAlgorithms.bubbleSort(data);
                break;
            case "insertionSort":
                SortingAlgorithms.insertionSort(data);
                break;
            case "quickSort":
                SortingAlgorithms.quickSort(data, 0, data.length - 1);
                break;
        }
        
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        return duration / 1000000.0;
    }
}
