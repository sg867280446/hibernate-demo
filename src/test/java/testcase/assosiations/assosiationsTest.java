package testcase.assosiations;

import org.hibernate.Session;
import org.junit.Test;

import hibernate.assosiations.Person1;
import hibernate.assosiations.Person2;
import hibernate.assosiations.Phone1;
import hibernate.assosiations.Phone2;
import testcase.base.BaseSetup;

public class assosiationsTest extends BaseSetup{
	/**
	 * ���Ե���һ�Զ�,���Զ������м����Ϊphoneû��person_id
	 */
	@Test
    public void test1(){
		/**
		 * insert into person values ( )
		   insert into phone (number) values (?)
		   insert into phone (number) values (?)
		   insert into person_phone (person_id, phones_id) values (?, ?)
		   insert into person_phone (person_id, phones_id) values (?, ?)
		   delete from person_phone where person_id=?
		   insert into person_phone (person_id, phones_id) values (?, ?)
		   delete from phone where id=?
		 */
		/**
		 * �������Ĳ������������������У��ᷢ����ɾ��ȫ���ٲ�������
		 * �������Ĳ���������һ�������У���ֻ��ɾ���ض������ݡ�
		 */
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Person1 person = new Person1();
		Phone1 phone1 = new Phone1( "123-456-7890" );
		Phone1 phone2 = new Phone1( "321-654-0987" );

		person.getPhones().add( phone1 );
		person.getPhones().add( phone2 );
		session.save(person);
		session.getTransaction().commit();
				
		session.beginTransaction();
		person.getPhones().remove( phone1 );
		
		session.getTransaction().commit();
		session.close();

    }
	
	/**
	 * ˫��ӳ����ԣ����Զ���phone������person_id,��ɾ��ʱ���ض�ɾ����
	 */
	@Test
	public void test2(){
		/**
		 * 
		 */
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Person2 person = new Person2();
		Phone2 phone1 = new Phone2( "123-456-7890" );
		Phone2 phone2 = new Phone2( "321-654-0987" );
		/**
		 * �����ķ�ʽ��ʹ���ߵ�ʵ��״̬��һ�£����Իᵼ��phone���per_id���벻�ɹ�
		 */
//		person.getPhones().add(phone1);
//		person.getPhones().add(phone2);
		
		/**
		 * �����ķ�ʽ������ȷ��
		 */
		person.addPhone(phone1);
		person.addPhone(phone2);
		session.save(person);
		session.getTransaction().commit();
				
		session.beginTransaction();
		
		/**
		 * �������ַ�ʽ���Ƴ�phone�ķ�����û�����𣬹�������Ϊ����phone���ҵõ�person_id(����Ӳ���û��person_id)
		 */
		//person.getPhones().remove( phone1 );
		person.removePhone(phone1);
		
		session.getTransaction().commit();
		session.close();
	}
}
