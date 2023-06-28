package Fila_Salario;

import Fila_Salario.Logica_do_Programa;

public class Fila <T> extends Logica_do_Programa <T>
{
	public Fila()
	{
		super();
	}
	
	public Fila(int capacidade)
	{
		super(capacidade);
	}

	public void Enfileirar(T elemento)
	{
		
		this.Adicionar(elemento);
	}
	public T Espiar()
	{
		if(this.estaVazia())
		{
			return null;
		}
		
		return this.Elemento[0];
		
	}
	

	public T Desinfileirar(){
		
		final int posicao = 0;
		
		if (this.estaVazia())
		{
			return null;
		}
		
		T removerElemento = this.Elemento[posicao];
		
		this.Remover(posicao);
		
		return removerElemento;
		
	}


}