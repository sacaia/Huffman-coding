package no;

public class No implements Comparable<No> {
	protected No dir = null;
	protected No esq = null;
	protected int qtd = 0;
	protected byte cod;
	
	public No (No dir, No esq, int qtd) //construtor destinado aos n�s n�o folhas
	{
		this.dir = dir;
		this.esq = esq;
		this.qtd = qtd;
		this.cod = -1; //se o n� tiver o c�digo como -1 significas que n�o possui um c�digo
	}
	
	public No (byte cod, int qtd) throws Exception //construtor destinado aos n�s folhas
	{
		if (qtd < 1)
			throw new Exception("Quantidade inv�lida");
		
		if (cod < 0 || cod > 255)
			throw new Exception("C�digo inv�lido");
		
		this.cod = cod;
		this.qtd = qtd;
	}
	
	public No getDir()
	{
		return dir;
	}
	
	public void setDir( No dir)
	{
		this.dir = dir;
	}
	
	public No getEsq()
	{
		return esq;
	}
	
	public void setEsq( No esq)
	{
		this.esq = esq;
	}
	
	public int getQtd()
	{
		return qtd;
	}
	
	public void setQtd( int qtd) throws Exception
	{
		if (qtd < 1)
			throw new Exception("Quantidade inv�lida");
		
		this.qtd = qtd;
	}
	
	public int getCod()
	{
		return cod;
	}
	
	public void setCod(byte cod) throws Exception
	{
		if (cod < -1 || cod > 255)
			throw new Exception("C�digo inv�lido");
		
		this.cod = cod;
	}
	
	public int mais(No outro)
	{
		return this.qtd+outro.qtd;
	}
	
	public String toString()
	{
		String ret = "cod: " + cod;
		ret += "\nqtd: " + qtd;
		
		return ret;
	}
	
	public int compareTo(No x)
	{
		if (this.qtd == x.qtd)
			return 0;
		if (this.qtd < x.qtd)
			return -1;
		else
			return 1;
	}
	
	public void addQtd()
	{
		this.qtd++;
	}
}
