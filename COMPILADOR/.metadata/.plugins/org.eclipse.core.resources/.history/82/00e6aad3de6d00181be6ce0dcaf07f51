package arvore;

import no.*;

public class Arvore {
	private No raiz;
	
	public Arvore(int cod, int qtd) throws Exception
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
	
	public void montarArore(No[] vetor)
	{
		
	}

	
	
}
