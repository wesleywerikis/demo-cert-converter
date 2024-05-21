package br.com.weswerikis.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PfxToBinary {

    public static byte[] readPfxFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fis.close();
        return bytes;
    }

    public static void main(String[] args) {
        try {
            byte[] pfxBytes = readPfxFile("C:\\CERTA1\\CERTIFICADO TESTE.pfx");
            Files.write(Paths.get("C:\\CERTA1\\BINARIO\\CERTIFICADO TESTE.bin"), pfxBytes);
            System.out.println("Arquivo .pfx convertido para binário com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
