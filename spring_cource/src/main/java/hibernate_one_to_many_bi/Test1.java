package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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
            session = factory.getCurrentSession();
//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Roman", "Demkiv", 1300);
//            Employee emp2 = new Employee("Roman", "Zarutskiy", 1000);
//            Employee emp3 = new Employee("Petro", "Hnativ", 5000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
            session.beginTransaction();
            System.out.println("Get department");
            Department dep = session.get(Department.class, 5);
            System.out.println("Show department");
            System.out.println(dep);
            System.out.println("Load our employees");
            dep.getEmps().get(0);
            session.getTransaction().commit();
            System.out.println("Show employees of department");
            System.out.println(dep.getEmps());

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }
}
