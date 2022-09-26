package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            Department department = new Department("HR", 5000, 300);
//            Employee emp1 = new Employee("Victor", "Mezhevivkin", 2500);
//            Employee emp2 = new Employee("Valeriy", "Venzik", 3500);
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
            session = factory.getCurrentSession();
            session.beginTransaction();
            Department dep = session.get(Department.class, 1);
            session.delete(dep);
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }
}
