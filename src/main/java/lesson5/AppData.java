package lesson5;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppData {
    private String[] header;
    private int[][] data;

    public void loadFrom(String filePath) {
        String absPath = Paths.get(filePath).toAbsolutePath().toString();
        try (BufferedReader reader = new BufferedReader(new FileReader(absPath))) {
            String str;
            String headerString = reader.readLine();
            header = headerString.split(";");
            List dataLines = new ArrayList();
            while ((str = reader.readLine()) != null) {
                // System.out.println(str);
                String[] split = str.split("[;,]");
                int[] chisla = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    String elem = split[i];
                    int chislo = Integer.parseInt(elem);
                    chisla[i] = chislo;
                }
                dataLines.add(chisla);
            }
            data = new int[dataLines.size()][];
            for (int i = 0; i < dataLines.size(); i++) {
                data[i] = (int[]) dataLines.get(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTo(String filePath) {
        String absPath = Paths.get(filePath).toAbsolutePath().toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(absPath))){
            writer.write(String.join(";", header) + "\n");

            for (int i = 0; i < data.length; i++) {
                int[] ints = data[i];
                List<String> collect = Arrays.stream(ints).mapToObj(x -> String.valueOf(x)).collect(Collectors.toList());
                writer.write(String.join(";", collect) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // ...
}
