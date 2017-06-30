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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity(name = "casa")
public class Casa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "endereco")
	private String endereco;
	
	@OneToMany(mappedBy = "casa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("nome")
	private List<Pessoa> moradores;
	
	public Casa() {
		moradores = new ArrayList<Pessoa>();
	}
	
	public Casa(String endereco) {
		this();
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Pessoa> getMoradores() {
		return Collections.unmodifiableList(moradores);
	}
	
	public void adicionarMorador(Pessoa novoMorador) {
		moradores.add(novoMorador);
		novoMorador.setCasa(this);
	}

	@Override
	public String toString() {
		return "Casa [id=" + id + ", endereco=" + endereco + ", moradores="
				+ moradores + "]";
	}
	
}
