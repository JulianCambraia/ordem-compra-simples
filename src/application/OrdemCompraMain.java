package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Pedido;
import entities.PedidoItem;
import entities.Produto;
import enums.PedidoStatusEnum;

public class OrdemCompraMain {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados do Cliente:");
		System.out.print("Nome:");
		String pNome = sc.nextLine();
		System.out.print("Email:");
		String pEmail = sc.nextLine();
		System.out.print("Dada de Aniversário (DD/MM/YYYY):");
		String pDataAniversario = sc.nextLine();

		Cliente cliente = new Cliente(pNome, pEmail, sdf.parse(pDataAniversario));

		System.out.println();
		System.out.println("Entre com os dados do Pedido:");
		System.out.print("Status:");
		PedidoStatusEnum pStatus = PedidoStatusEnum.valueOf(sc.nextLine());
		Pedido pedido = new Pedido(new Date(), pStatus, cliente);

		System.out.print("Quantos itens para terá este pedido?");
		Integer pQtdeItens = sc.nextInt();
		for (Integer i = 1; i <= pQtdeItens; i++) {
			System.out.println("Dados do Item #" + i + ":");
			System.out.print("Nome do Produto: ");
			String pNomeProduto = sc.next();
			System.out.print("Preço do Produto: ");
			Double pPrecoProduto = sc.nextDouble();
			System.out.print("Quantidade do Produto: ");
			Integer pQuantidade = sc.nextInt();
			PedidoItem item = new PedidoItem(pQuantidade, pPrecoProduto, new Produto(pNomeProduto, pPrecoProduto));
			pedido.adicionarItem(item);
			
		}

		System.out.println(pedido);
		
		
		
		sc.close();
	}

}
