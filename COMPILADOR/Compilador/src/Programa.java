import no.*;
import java.io.*;
import java.util.BitSet;

public class Programa {
	private static BufferedReader teclado;
	private No[] vetor;

	public static void main(String[] args) {
		teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Informe o caminho do arquivo");
		
		try 
		{
		String caminho = teclado.readLine();
		
		RandomAccessFile arq = new RandomAccessFile(caminho, "rw");
		
		
		}catch(Exception erro)
		{
			System.out.println("caminho n�o encontrado");
		}
	}
	
	private void compilar(Byte[] arquivo)
	{
		vetor = new No[256];
	}

}
