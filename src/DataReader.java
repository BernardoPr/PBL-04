import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import estruturas.ListaDinamica;

public class DataReader {
    
    public static int[] readCSV(String filePath) throws IOException {
        ListaDinamica data = new ListaDinamica();
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine(); // Skip header
            
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    data.adicionar(Integer.parseInt(line));
                }
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        
        return data.toArray();
    }
    
    public static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
}
