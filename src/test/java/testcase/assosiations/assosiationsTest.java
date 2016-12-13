package testcase.assosiations;

import org.hibernate.Session;
import org.junit.Test;

import hibernate.assosiations.Person1;
import hibernate.assosiations.Phone1;
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
}
