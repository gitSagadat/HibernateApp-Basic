package io.saga.hibernate;


import io.saga.hibernate.model.Passport;
import io.saga.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).
                addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person = session.get(Person.class,1);
            session.remove(person);


            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
//##Меняем владельца товара также, удалем товар с листа старого валедльца
//Person person= session.get(Person.class,4);
//Item item = session.get(Item.class,6);
//item.getOwner().getItems().remove(item);
//item.setOwner(person);
//
//person.getItems().add(item);


///Удаляем человека из списка в таблице и ставим значение NULL,на его товары
//Person person =session.get(Person.class,5);
//Создаем SQL Команду
//session.remove(person);
//Для того чтобы было правильное состояние хэша Hibernate
//person.getItems().forEach(i->i.setOwner(null));

//Delete OwnItem from Person
//Person person= session.get(Person.class,5);
//List<Item>items =person.getItems();
//for (Item item: items){
//    session.remove(item);
//}
//person.getItems().clear();


            ///////Create Person and set item for Person
            //Person person = new Person("Test Person",44);

            //Item newItem=new Item("Smart-TV SONY",person);

            //person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
            //session.save(person);
            //session.save(newItem);


            /////////////// Create new item or Create new Item + Set ItemOwner
            //Person person= session.get(Person.class,3);
            //Item newItem=new Item("Corsar Vengeance DDR5 64Gb",person);
            //person.getItems().add(newItem);
            //session.save(newItem);
                ///// Find ItemOwner by Item
            //Item item=session.get(Item.class,10);
            //System.out.println(item);

            //Person person= item.getOwner();
            //System.out.println(person);
            //////// Receive Person items
            //Person person= session.get(Person.class,2);
            //System.out.println(person);

            //List<Item>items= person.getItems();
            //System.out.println(items);


            /////////////// Receive all people from table
           //List<Person>people=session.createQuery("from Person").getResultList();

           // ///////////Receive people with age>30
            // List<Person>people=session.createQuery("from Person where age>30").getResultList();

            ////////////Receive people with name start by T letter.
            //List<Person>people=session.createQuery("from Person name LIKE 'T%'").getResultList();

          // for (Person person:people){
          //     System.out.println(person);
          // }

            ///////////////// Change person name in table with age < less 21
            //session.createQuery("UPDATE Person set name='Katty' where age<21").executeUpdate();

            ///////////////DELETE From Table Person who have name start by T letter
            //session.createQuery("delete from Person where name LIKE 'R%'").executeUpdate();

