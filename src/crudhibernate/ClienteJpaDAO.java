package crudhibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class ClienteJpaDAO {
 
         private static ClienteJpaDAO instance;
         protected EntityManager entityManager;
          
         
         public static ClienteJpaDAO getInstance(){
                   if (instance == null){
                            instance = new ClienteJpaDAO();
                   }
                   
                   return instance;
         }
 
         private ClienteJpaDAO() {
                   entityManager = getEntityManager();
         }
         
         //INSTACIA UM OBJETO ENTITY MANAGER E USANDO PP SINGLETON
         private EntityManager getEntityManager() {
        	 /*LINHA RESPONSAVEL POR APONTAR A CONFIGURAÇÃO DE ACORDO COM O 
        	 NOME DE PARAMETRO SETADO NO PERSISTENCE.XML*/ 
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernate");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
 
                   return entityManager;
         }
 
         public Cliente getById(final int id) {
                   return entityManager.find(Cliente.class, id);
         }
 
         @SuppressWarnings("unchecked")
         public List<Cliente> findAll() {
                   return entityManager.createQuery("FROM " + Cliente.class.getName()).getResultList();
         }
         
         //SETANDO DADOS NO BANCO
         public void persist(Cliente cliente) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.persist(cliente);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
         
         //REALIZANDO UPDATE NO BANCO 
         public void merge(Cliente cliente) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.merge(cliente);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         //EXCLUINDO DO BANCO
         public void remove(Cliente cliente) {
                   try {
                            entityManager.getTransaction().begin();
                            cliente = entityManager.find(Cliente.class, cliente.getId());
                            entityManager.remove(cliente);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
         

         //EXCLUINDO DE ACORDO COM ID PASSADO
         public void removeById(final int id) {
                   try {
                            Cliente cliente = getById(id);
                            remove(cliente);
                   } catch (Exception ex) {
                            ex.printStackTrace();
                   }
         }
 
}
