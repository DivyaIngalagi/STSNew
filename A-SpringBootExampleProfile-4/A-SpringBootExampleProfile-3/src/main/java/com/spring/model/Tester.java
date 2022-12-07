package com.spring.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component//2ndmethod
@Profile("tester")//3rdmethod
public class Tester implements Deparement {

	@Override
	public void Operation() {
		  System.out.println("This is Tester's  Profile ");
	}

}
