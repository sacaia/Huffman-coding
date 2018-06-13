import no.*;
import java.io.*;
import java.util.BitSet;

public class Programa {
	private static BufferedReader teclado;
	private static No[] vetor;

	public static void main(String[] args) {
		teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Informe o caminho do arquivo");
		
		try 
		{
		String caminho = teclado.readLine();
		
		RandomAccessFile arq = new RandomAccessFile(caminho, "r");
		arq.seek(0);
		byte[] infoArq = new byte[(int)arq.length()];
		arq.read(infoArq);
		arq.close();
		compilar(infoArq);
		
		}catch(Exception erro)
		{
			System.err.println(erro);
		}
	}
	
	private static void compilar(byte[] arquivo)
	{
		vetor = new No[256];
		int cont;
		
		try {
		
		for (int i = 0; i < arquivo.length; i++)
			if (vetor[arquivo[i]] == null)
				vetor[arquivo[i]] = new No(arquivo[i], 1);
			else
				vetor[arquivo[i]].addQtd();
		
		
		
		
		}catch(Exception err)
		{}
	}

}
