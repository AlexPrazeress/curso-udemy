package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Produto> list = new ArrayList<>();
		
		System.out.print("Entre com o numero de produtos: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Comun, usado ou importado (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preco: ");
			double preco = sc.nextDouble();
			if (type == 'c') {
				list.add(new Produto(nome, preco));
			}
			else if (type == 'u') {
				System.out.print("Data fabricacao (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				list.add(new ProdutoUsado(nome, preco, data));
			}
			else {
				System.out.print("Taxa adicional: ");
				double taxaAdicional = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, taxaAdicional));
			}
		}

		System.out.println();
		System.out.println("Etiqueta de preco:");
		for (Produto prod : list) {
			System.out.println(prod.etiquetaPreco());
		}
		sc.close();
	}

}
