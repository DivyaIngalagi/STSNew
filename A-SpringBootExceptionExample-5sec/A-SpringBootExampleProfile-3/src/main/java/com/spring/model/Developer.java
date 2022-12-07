package com.spring.model;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Profile("developer")
public class Developer implements Deparement {

	@Override
	public void Operation() {
      System.out.println("This is Developer's  Profile ");
	}

}
