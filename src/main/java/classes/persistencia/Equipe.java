package classes.persistencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

@Entity(name = "equipe")
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("nome")
	@JoinTable(name = "membro_equipe", 
		joinColumns = { 
			@JoinColumn(name = "equipe_id")
		}, 
		inverseJoinColumns = { 
			@JoinColumn(name = "membro_id")
		})
	private List<Pessoa> membros;

	public Equipe() {
		membros = new ArrayList<Pessoa>();
	}
	
	public Equipe(String nome, Pessoa... membros) {
		this();
		this.nome = nome;
		for (Pessoa pessoa : membros) {
			this.membros.add(pessoa);
		}
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pessoa> getMembros() {
		return Collections.unmodifiableList(membros);
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", nome=" + nome + ", membros=" + membros
				+ "]";
	}

}
