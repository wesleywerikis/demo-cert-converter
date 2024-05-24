package br.com.weswerikis.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PfxToBinary {

	public static byte[] readPfxFile(String filePath) throws IOException {
		System.out.println("Lendo o arquivo PFX de: " + filePath);

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];

		System.out.println("Tamanho do arquivo: " + file.length() + " bytes");

		fis.read(bytes);
		fis.close();

		System.out.println("Conteúdo lido do arquivo PFX (em bytes):");
		for (byte b : bytes) {
			System.out.print(String.format("%02X ", b));
		}
		System.out.println();

		return bytes;
	}

	public static void main(String[] args) {
		try {
			String pfxFilePath = "C:\\CERTA1\\CERTIFICADO TESTE.pfx";
			byte[] pfxBytes = readPfxFile(pfxFilePath);

			String binFilePath = "C:\\CERTA1\\BINARIO\\CERTIFICADO TESTE.bin";
			Files.write(Paths.get(binFilePath), pfxBytes);

			System.out.println("Arquivo .pfx convertido para binário com sucesso.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
