package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.PedidoStatusEnum;

public class Pedido {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date dataSolicitacao;
	private PedidoStatusEnum status;
	private Cliente cliente;
	private List<PedidoItem> items = new ArrayList<PedidoItem>();

	public Pedido() {
		super();
	}

	public Pedido(Date dataSolicitacao, PedidoStatusEnum status, Cliente cliente) {
		super();
		this.dataSolicitacao = dataSolicitacao;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public PedidoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PedidoStatusEnum status) {
		this.status = status;
	}

	public List<PedidoItem> getItems() {
		return items;
	}

	public void adicionarItem(PedidoItem item) {
		items.add(item);
	}

	public void removerItem(PedidoItem item) {
		items.remove(item);
	}

	public Double total() {
		Double soma = 0.00;
		for (PedidoItem pedidoItem : items) {
			soma += pedidoItem.subTotal();
		}
		return soma;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		String data = sdf.format(dataSolicitacao);
		sb.append("\n");
		sb.append("SUMÁRIO PEDIDO:" + data + "\n").append("Status do Pedido:" + this.getStatus() + "\n")
				.append("Cliente: " + this.cliente.getNome() + "("
						+ Cliente.sdf.format(this.cliente.getDataDeAniversario()) + ") - " + this.cliente.getEmail()
						+ "\n")
				.append("I T E N S - D E - P E D I D O\n");

		for (PedidoItem pedidoItem : items) {
			sb.append(pedidoItem.getProduto().getNome() + ", Quantidade: " + pedidoItem.getQuantidade() + ", SubTotal: "
					+ String.format("%.2f", pedidoItem.subTotal()) + "\n");
		}
		sb.append("PREÇO TOTAL: R$ " + String.format("%.2f", this.total()));
		return sb.toString();
	}

}
