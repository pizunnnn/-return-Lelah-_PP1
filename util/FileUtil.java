package util;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class FileUtil {
    private static final String FILE_PATH = "data_barang.txt";

    public static void hapusBarangDariFile(int idBarang) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            List<String> updatedLines = new ArrayList<>();

            for (String line : lines) {
                if (!line.startsWith(idBarang + ";")) {
                    updatedLines.add(line);
                }
            }

            Files.write(Paths.get(FILE_PATH), updatedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void simpanBarangKeFile(int id, String nama, String distributor, String tanggalKadaluarsa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(id + ";" + nama + ";" + distributor + ";" + tanggalKadaluarsa);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
