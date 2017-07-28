package execucao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.persistencia.Equipe;
import classes.persistencia.Pessoa;

public class RunMany {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-da-alegria-in-postgres");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
//		Pessoa andre = new Pessoa("André");
//		Pessoa beatriz = new Pessoa("Beatriz");
//		Pessoa celia = new Pessoa("Célia");
//		Pessoa devanir = new Pessoa("Devanir");
//		Pessoa elizete = new Pessoa("Elizete");
//		
//		Equipe equipe1 = new Equipe("Trovão", andre, beatriz, celia);
//		Equipe equipe2 = new Equipe("Raio", andre, devanir, elizete);
//		Equipe equipe3 = new Equipe("Relampago", beatriz, celia, elizete, devanir);
//		
//		entityManager.getTransaction().begin();
//		
//		entityManager.persist(equipe1);
//		entityManager.persist(equipe2);
//		entityManager.persist(equipe3);
//		
//		entityManager.getTransaction().commit();
		
		
		Equipe equipe3 = entityManager.find(Equipe.class, new Long(3));
		System.out.println(equipe3);
		
		Pessoa pessoa4 = entityManager.find(Pessoa.class, new Long(4));
		System.out.println(pessoa4);

	}

}
