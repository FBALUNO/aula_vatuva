package Fila_Salario;

public class Logica_do_Programa <T>
{
	protected T[] Elemento;
	protected int Tamanho;

	public Logica_do_Programa(int capacidade)
	{
		this.Elemento=(T[]) new Object[capacidade];
		this.Tamanho=0;
		
	}
	public Logica_do_Programa()
	{
		this(12);
	}
	public int Tamanho()
	{
		return this.Tamanho;
	}
	public boolean Adicionar(T elemento)
	{
		this.AumentarCapacidade();
		if(this.Tamanho <this.Elemento.length)
		{
			this.Elemento[this.Tamanho]=elemento;
			this.Tamanho++;
			return true;
		}
		return false;
	}
	public boolean estaVazia()
	{
		return this.Tamanho==0;
	}
	public boolean Adicionar(int posicao, T elemento)
	{
		if (posicao < 0 || posicao > this.Tamanho)
		{
			throw new IllegalArgumentException("Posição inválida");
		}
		this.AumentarCapacidade();
		for (int i=this.Tamanho-1; i>=posicao; i--){
			this.Elemento[i+1] = this.Elemento[i];
		}
		this.Elemento[posicao] = elemento;
		this.Tamanho++;

		return true;
	}
	
	@SuppressWarnings("unchecked")
	public void AumentarCapacidade()
	{
		if (this.Tamanho== this.Elemento.length)
		{
		
			T[] novoElemento = (T[]) new Object[this.Elemento.length * 2];
			for (int i=0; i<this.Elemento.length; i++)
			{
				novoElemento[i] = this.Elemento[i];
			}
			this.Elemento = novoElemento;
		}
		
	}
	public void Remover(int posicao)
	{
		if (!(posicao >= 0 && posicao < this.Tamanho))
		{
			throw new IllegalArgumentException("Posicao inválida");
		}
		for (int i=posicao; i<this.Tamanho-1; i++)
		{
			Elemento[i] =Elemento[i+1];
		}
		this.Tamanho--;
	}
	@Override
	public String toString() 
	{
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i=0; i<this.Tamanho-1; i++){
			s.append(this.Elemento[i]);
			s.append(", ");
		}
		
		if (this.Tamanho>0 )
		{
			s.append(this.Elemento[this.Tamanho-1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
}