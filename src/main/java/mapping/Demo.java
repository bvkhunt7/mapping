package mapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class Demo {
	
	public static void main(String[] args) {
	
		System.out.println("enter human name");

		Scanner nm = new Scanner(System.in);

		String name = nm.nextLine();

		System.out.println("enter Contact number");

		Scanner mn = new Scanner(System.in);

		int cno = mn.nextInt();

		Configuration config = new Configuration().configure().addAnnotatedClass(Contact.class)
				.addAnnotatedClass(Per.class);
		@SuppressWarnings("unused")
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		@SuppressWarnings("deprecation")
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();

		session.getTransaction().begin();

		
		
		List<Per> humanList = session.createQuery("from Per where pname ='" + name + "'").list();
		List<Contact> contactList = session.createQuery("from Contact where cno ='" + cno + "'").list();
		Contact ct = new Contact();
		ct.setCno(cno);
		
		List<Contact> list1 = new ArrayList<Contact>();
		list1.add(ct);
		
		Per h = new Per();
		h.setPname(name);
		List<Per> list2 = new ArrayList<Per>();
		list2.add(h);
		
		h.setLaps(list1);
		ct.setPer(list2);
		
		if (humanList.isEmpty() && contactList.isEmpty()) {
		    	
			h =new Per();
			ct.setCno(cno);
			// ct.setPer(h);
			list1.add(ct);
			h.setLaps(list1);
			h.setPname(name);
			session.save(h);
			
			

		} else 
		{   if(!contactList.isEmpty())
	      {
		     ct = contactList.get(0);
		     h.setPname(name);
		     ct.getPer().add(h);
		     session.save(h);
	      }
		else
		{
			h = humanList.get(0);
			ct.setCno(cno);
			h.getLaps().add(ct);
			session.save(h);	
		}
		}

		session.getTransaction().commit();

	}

}
