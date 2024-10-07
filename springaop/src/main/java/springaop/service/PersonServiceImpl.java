package springaop.service;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public void printPerson() {
		System.out.print("<<printPerson()수행됨!>>");

	}

	@Override
	public void getPereson() {
		System.out.print("<<getPereson()수행됨!>>");

	}

}
