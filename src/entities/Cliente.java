package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	private String nome;
	private String email;
	private Date dataDeAniversario;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Cliente() {
		super();
	}

	public Cliente(String nome, String email, Date dataDeAniversario) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataDeAniversario = dataDeAniversario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDeAniversario() {
		return dataDeAniversario;
	}

	public void setDataDeAniversario(Date dataDeAniversario) {
		this.dataDeAniversario = dataDeAniversario;
	}

}
