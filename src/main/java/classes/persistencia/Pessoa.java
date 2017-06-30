package classes.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

@Entity(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne
	private Casa casa;
	
	@ManyToMany(mappedBy = "membros", fetch = FetchType.EAGER)
	@OrderBy("nome")
	private List<Equipe> equipes;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	@Override
	public String toString() {
		String casaId = casa != null ? casa.getId().toString() : "<null>";
		List<String> nomesEquipes = new ArrayList<String>();
		
		for (Equipe equipe : equipes) {
			nomesEquipes.add(equipe.getNome());
		}
		return "Pessoa [id=" + id + ", nome=" + nome + ", casa=" + casaId + ", equipes=" + nomesEquipes + "]";
	}

}
