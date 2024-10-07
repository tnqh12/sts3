package springaop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springaop.service.PersonService;

public class PersonMain {
	
	private ApplicationContext context;
	private PersonService personService;
	
	public PersonMain(){
		context = new GenericXmlApplicationContext("classpath:/springaop/conf/applicationContext.xml");
	}
	
	public static void main(String[] args) {
		
		PersonMain personMain = new PersonMain();
		
		personMain.personService = (PersonService)personMain.context.getBean("personService");
		
		personMain.personService.printPerson();
		
		System.out.println("------------------------------------------------");
		
		personMain.personService.getPereson();
		
	}
	
	
}
