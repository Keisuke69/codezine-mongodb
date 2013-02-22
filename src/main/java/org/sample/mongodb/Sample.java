package org.sample.mongodb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class Sample {
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
		
		Person person = new Person();
		person.setName("John");
		person.setAge(25);
		
		mongoTemplate.insert(person);
		
		Person result = mongoTemplate.findOne(new Query(Criteria.where("name").is("John")), Person.class);
		System.out.println(result.getId() + ":" + result.getName());
		
	}
}
