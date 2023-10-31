package com.demo.springdemo;
 
import java.util.Scanner;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
import com.demo.springdemo.library.ProductComponent;
 
public class App {
  public static void main(String[] args) {
//ProductComponent product = new ProductComponent();	  
	    ProductComponent product;
	    ProductComponent product2;
	    ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
		product=context.getBean(ProductComponent.class);
		product2=context.getBean(ProductComponent.class);
		if(product==product2)
		{
			System.out.println("Same Object");
		}
		else {
			System.out.println("Differnt Object");
		}
//		product.setCart();
  Scanner sc = new Scanner(System.in);
  while(true) {
	  System.out.println("Enter Products: ");
	  String prd = sc.nextLine();
	  if(prd.equals("end")){
		  break;
	  }
	  System.out.println(product.viewAddProduct(prd));
  }
  }
}