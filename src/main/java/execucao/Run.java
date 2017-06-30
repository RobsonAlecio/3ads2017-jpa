package execucao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.persistencia.Casa;

public class Run {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-da-alegria-in-postgres");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		Part 1
//		Casa casa = new Casa("Rua dos Bobos, 0");
//		Pessoa pessoa = new Pessoa("Fulano");
//		
//		entityManager.getTransaction().begin();
//		
//		entityManager.persist(casa);
//		entityManager.persist(pessoa);
//		
//		entityManager.getTransaction().commit();
		
//		Casa casa = new Casa("Rua dos Bobos, 2");
//		Pessoa pessoa = new Pessoa("Fulano Mais Legal");
//		Pessoa outraPessoa = new Pessoa("Beltrano Massa");
//		
//		casa.adicionarMorador(pessoa);
//		casa.adicionarMorador(outraPessoa);
//		
//		entityManager.getTransaction().begin();
//		
//		entityManager.persist(casa);
//		
//		entityManager.getTransaction().commit();
		

		Casa casa = entityManager.find(Casa.class, new Long(3L));
		System.out.println(casa);
	}
}
