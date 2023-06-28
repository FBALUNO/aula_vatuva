package Fila_Salario;

public class Prioridades <T> extends Fila<T>
{
	@SuppressWarnings("unchecked")
	public void Enfileirar(T elemento)
	{
		
		Comparable<T> segredo=(Comparable<T>)elemento;
		int i;
		for( i=0; i < this.Tamanho; i++)
		{
			if(segredo.compareTo(this.Elemento[i]) < 0)
			{
				break;
			}
		}
		this.Adicionar(i, elemento);
	}
}