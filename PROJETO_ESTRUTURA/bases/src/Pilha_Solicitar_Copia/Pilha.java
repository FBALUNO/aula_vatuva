package Pilha_Solicitar_Copia;

import Fila_Salario.Logica_do_Programa;

public class Pilha <T> extends Logica_do_Programa <T>
{

	public Pilha()
	{
		super();
	}
	
	public Pilha(int capacidade){
		super(capacidade);
	}
	
	public void Empilhar(T elemento)
	{
		super.Adicionar(elemento);
	}
	
	public T Topo()
	{
		
		if (this.estaVazia())
		{
			return null;
		} 
		
		return this.Elemento[this.Tamanho-1];
	}
	
	public T Desempilhar(){
		
		if (this.estaVazia())
		{
			return null;
		}
		
		return this.Elemento[this.Tamanho--];
	}
}
