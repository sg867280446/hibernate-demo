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
	 * 测试单向一对多,会自动生成中间表，以为phone没有person_id
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
		 * 如果下面的操作发生在两个事务中，会发生先删除全部再插入的情况
		 * 如果下面的操作发生在一个事务中，就只会删除特定的数据。
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
	 * 双向映射测试，会自动在phone表生成person_id,且删除时是特定删除。
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
		 * 这样的方式会使两边的实体状态不一致，所以会导致phone表的per_id插入不成功
		 */
//		person.getPhones().add(phone1);
//		person.getPhones().add(phone2);
		
		/**
		 * 这样的方式才是正确的
		 */
		person.addPhone(phone1);
		person.addPhone(phone2);
		session.save(person);
		session.getTransaction().commit();
				
		session.beginTransaction();
		
		/**
		 * 以下两种方式的移除phone的方法都没有区别，估计是因为可以phone表找得到person_id(而添加操作没有person_id)
		 */
		//person.getPhones().remove( phone1 );
		person.removePhone(phone1);
		
		session.getTransaction().commit();
		session.close();
	}
}
