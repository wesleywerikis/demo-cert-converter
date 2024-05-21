package br.com.weswerikis.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BinaryToPfx {

    public static byte[] readBinaryFile(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    public static void writePfxFile(String filePath, byte[] bytes) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        fos.write(bytes);
        fos.close();
    }

    public static void main(String[] args) {
        try {
            byte[] binaryBytes = readBinaryFile("C:\\CERTA1\\BINARIO\\CERTIFICADO TESTE.bin");
            writePfxFile("C:\\CERTA1\\CERT\\CERTIFICADO TESTE.pfx", binaryBytes);
            System.out.println("Arquivo binário convertido para .pfx com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
