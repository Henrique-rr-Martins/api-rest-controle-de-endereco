package com.projetozup.projetozup.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe para teste de conexão com o banco. Assim é  possível verificar  se o problema é na abstração de alguma dependência ou na conexão em si.
 * 
 * @author Henrique Martins
 *
 */
public class JpaUtil {
	
	/**
	 * Checa se a aplicação se conecta ao banco.
	 */
	public static void testaConexao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ZUP");
		EntityManager em = factory.createEntityManager();
		System.out.println(em.isOpen());
		em.close();
	}
}
