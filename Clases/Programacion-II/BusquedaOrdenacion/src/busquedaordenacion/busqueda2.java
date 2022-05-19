/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package busquedaordenacion;

import java.util.*;
public class busqueda2 {

	public static void main(String[]args)
	{
		int a[],n,n1,indice;

		Scanner sc=new Scanner(System.in);

		System.out.print("Ingresa tamaño del arreglo: ");
		n=sc.nextInt();

		a=new int[n];

		a=inicializa(n);
		muestra(a);

		System.out.print("Ingresa numero a buscar: ");
		n1=sc.nextInt();

		indice=busquedaLineal(a,n1);
		if(indice==-1)
		{
			System.out.println("tu número no esta en la lista");
		}
		else
		{
			System.out.println("tu número esta en el indice: "+indice);
		}
}

	static int[] inicializa(int n)
	{
		int i,j,a[]=new int[n];
		for(i=0;i<n;i++)
		{
			a[i]=randomxy(1,50);
		}

		return a;
	}

	static int busquedaLineal(int a[],int n)
	{
		int i;
		for (i=0;i<a.length;i++)
		{
			if (a[i] == n)
			{
				return i+1;
			}
		}
		return -1;
	}

	static void muestra(int a[])
	{
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.print("nn");

	}

	static int randomxy(int x,int y)
	{
		int ran=(int) (Math.floor(Math.random()*(y-x+1))+x);

		return ran;
	}
}
