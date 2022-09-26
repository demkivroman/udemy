package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee rDemkiv = new Employee("Ivan", "Ivanov", "HR", 2);
            session.beginTransaction();
            session.save(rDemkiv);
            session.getTransaction().commit();

            int myId = rDemkiv.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();

            System.out.println(employee);
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
