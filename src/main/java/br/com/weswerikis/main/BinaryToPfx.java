package br.com.weswerikis.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BinaryToPfx {

	public static byte[] readBinaryFile(String filePath) throws IOException {
		System.out.println("Lendo o arquivo binário de: " + filePath);

		byte[] bytes = Files.readAllBytes(Paths.get(filePath));

		System.out.println("Conteúdo lido do arquivo binário (em bytes):");
		for (byte b : bytes) {
			System.out.print(String.format("%02X ", b));
		}
		System.out.println();

		return bytes;
	}

	public static void writePfxFile(String filePath, byte[] bytes) throws IOException {
		System.out.println("Escrevendo no arquivo PFX: " + filePath);

		Files.write(Paths.get(filePath), bytes);

		System.out.println("Conteúdo escrito no arquivo PFX (em bytes):");
		for (byte b : bytes) {
			System.out.print(String.format("%02X ", b));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		try {
			String binFilePath = "C:\\CERTA1\\BINARIO\\CERTIFICADO TESTE.bin";
			byte[] binaryBytes = readBinaryFile(binFilePath);

			String pfxFilePath = "C:\\CERTA1\\CERT\\CERTIFICADO TESTE.pfx";
			writePfxFile(pfxFilePath, binaryBytes);

			System.out.println("Arquivo binário convertido para .pfx com sucesso.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
