package codigo;

public class Codigo {

	protected byte caracter;
	protected int[] cod;
	
	public Codigo()
	{
		this.caracter = (Byte) null;
		this.cod = null;
	}
	
	public Codigo(byte chr, int[] cod)
	{
		this.caracter = chr;
		this.cod = cod;
	}
	
	public byte getCaracter()
	{
		return this.caracter;
	}
	
	public int[] getCod()
	{
		return this.cod;
	}
	
	public void setCaracter(byte b)
	{
		this.caracter = b;
	}
	
	public void setCod(int[] c)
	{
		this.cod = c;
	}
}
