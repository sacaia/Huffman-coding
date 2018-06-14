package arvore;

import no.*;

public class Arvore {
	protected No raiz;

	public Arvore()
	{
		this.raiz = null;
	}
	
	public Arvore(byte cod, int qtd) throws Exception
	{
		raiz = new No(cod, qtd);
	}
	
	public No getRaiz()
	{
		return this.raiz;
	}
	
	public void setRaiz(No raiz)
	{
		this.raiz = raiz;
	}
	
	public void add(No no) 
	{
		if(raiz == null)
		{
			raiz = no;
			return;
		}
			
		No atual = raiz;
		
		while( (atual.getDir() != null)||(atual.getEsq() != null) )
		{
			if(no.compareTo(atual) == 0)
				return; //n adiciona igual
	
			if(no.compareTo(atual) < 0)
				if(atual.getDir() == null)
				{
					atual.setDir(no);
					return;
				}	
				else
					atual = atual.getEsq();
			else
				if(atual.getEsq() == null)
				{
					atual.setEsq(no);
					return;
				}
				else
					atual = atual.getDir();
		}
		
	}
	
	public void juntar(No a, No b)
	{
		if(a.compareTo(b) < 0)
			this.add(new No(a, b, a.mais(b)));
			else
				this.add(new No(b, a, b.mais(a)));
	}
	
	private void juntar(No[] vetor, int i, int j)
	{
		No aux;
		
		if((vetor[i] == null) || (vetor[j] == null))
			return;
		
		if(this.compararQtd(vetor[i], vetor[j]) > 0)
			aux = new No(vetor[i], vetor[j], vetor[i].mais(vetor[j]));
		else
			aux = new No(vetor[j], vetor[i], vetor[i].mais(vetor[j]));
		
		vetor[j] = aux;
		vetor[i] = null;
	}
	
	public No[] ordenarPrimeiraVez(No[] vetor)
	{	
		No aux;
		int i, j;
		
		for(i = 0; i<vetor.length; i++)
		{
			for(j = i+1; j<vetor.length; j++)
			{
				if(this.compararQtd(vetor[i], vetor[j]) < 0)
				{
					aux = vetor[i]; 	
					vetor[i] = vetor[j];
					vetor[j] = aux;	
				}
			}
		}
		
		return vetor;
	}
	
	public No[] ordenarNezimaVez(No[] vetor)
	{	
		No aux;
		int i, j;
		
		for(i = 0; i<vetor.length; i++)
		{
			for(j = i+1; j<vetor.length; j++)
			{
				if(vetor[i] == null)
					return vetor;
				
				if(vetor[j] == null)
					break;
				
				if(this.compararQtd(vetor[i], vetor[j]) < 0)
				{
					aux = vetor[i]; 	
					vetor[i] = vetor[j];
					vetor[j] = aux;	
				}
			}
		}
		
		return vetor;
	}
	
	public int compararQtd(No n1, No n2)
	{
		if( (n1 == null)&&(n2 == null) )
			return 0;
		
		if( (n1 == null)&&(n2 != null) )
			return -2;
		
		if( (n1 != null)&&(n2 == null) )
			return 2;
		
		if (n1.getQtd() == n2.getQtd())
			return 0;
		if (n1.getQtd() < n2.getQtd())
			return -1;
		else
			return 1;
	}
	
	public int compararCod(No n1, No n2)
	{
		if(n1.getCod() == n2.getCod())
			return 0;
		
		if(n1.getCod() < n2.getCod())
			return -1;
		
		return 1;
		
	}
	
	public void montarArore(No[] vetor)
	{
		this.ordenarPrimeiraVez(vetor);
		
		for(int i = vetor.length-1; i > 0; i--)
		{
			this.juntar(vetor, i, i-1);
			
			this.ordenarNezimaVez(vetor);
		}
		
		raiz = vetor[0];
	}
	
	public String toString()
	{
		String ret = "";
		
		ret = this.toString(raiz);
		
		return ret;
	}

	private String toString(No n)
	{
		String ret = "";
		
		if(n.getDir() == null)
			return n.toString() + "\n";
		else
			ret += toString(n.getDir());
		
		if(n.getEsq() == null)
			return n.toString() + "\n";
		else
			ret += toString(n.getEsq());
		
		return ret;
	}
	
	public int[] montarCod(No x)
	{
		String str = this.montarCod(raiz, x);
		int[] ret = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++)
			ret[i] = (int)str.charAt(i);
		
		return ret;
	}

	private String montarCod(No n, No x)
	{
		String ret = "";
		if(this.compararCod(x, n) > 0) // x>n direita
			ret += 1 + montarCod(n.getDir(), x);
		
		if(this.compararCod(x, n) < 0)
			ret += 0 + montarCod(n.getEsq(), x);
		
		// x == n achou
			return ret;
		
	}
}
