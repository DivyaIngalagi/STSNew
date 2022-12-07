package com.spring.model;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component//2ndmethod
//@Primary//2ndmethod
@Profile("developer")//3rdmethod
public class Developer implements Deparement {

	@Override
	public void Operation() {
      System.out.println("This is Developer's  Profile ");
	}

}
