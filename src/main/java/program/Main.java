package program;

import entities.Author;
import entities.Book;
import entities.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.DbContextZibert;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Session context = DbContextZibert.getSessionFactory().openSession();
       // System.out.println("Hello");
       // Role role = new Role();
        //role.setName("admin");
       // context.save(role);

//        Query query = context.createQuery("FROM Role");
//        List<Role> roles = query.list();
//        for (Role role : roles)
//            System.out.println(role);
//        context.close();
        Author peter = new Author();
        peter.setFullName("Peter Mogylov");
        Author ivan = new Author();
        ivan.setFullName("Ivan Pidcabl");


        Book garik = new Book();
        garik.setName("Harry Potter");
        garik.setAuthor(peter);

        Book mermaid = new Book();
        mermaid.setName("Mermaid on vikend");
        mermaid.setAuthor(ivan);


        Book slavik = new Book();
        slavik.setName("Slavik on vikend");
        slavik.setAuthor(peter);


        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try{
            sessionFactory = DbContextZibert.getSessionFactory();
            session = sessionFactory.openSession();
            System.out.println("Session open ");
            tx = session.beginTransaction();

            session.save(ivan);
            session.save(peter);

            session.save(garik);
            session.save(mermaid);
            session.save(slavik);


            tx.commit();

        }
        catch (Exception ex){
            System.out.println("Exeption" + ex.getMessage());
            ex.printStackTrace();
        }finally {
            if (!sessionFactory.isClosed()){
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }

    }

}
