package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		
//		User user=new User();
//		user.setName("Ismail Shaikh");
//		user.setCity("Mumbai");
//		user.setStatus("I am a java programmer");
//		
//		User user2=userRepository.save(user);
//		System.out.println(user2);
		
		//create object of user
		/*
		 * User user1=new User(); user1.setName("Salik Shaikh");
		 * user1.setCity("Banglore"); user1.setStatus("Python programmer");
		 * 
		 * User user2=new User(); user2.setName("Salik shailh"); user2.setCity("city2");
		 * user2.setStatus("Java programmer");
		 * 
		 * //saving single user //User reUser=userRepository.save(user1); List<User>
		 * users = List.of(user1,user2); //save multiple user Iterable<User> result =
		 * userRepository.saveAll(users);
		 * result.forEach(user->{System.out.println(user);});
		 * System.out.println("done");
		 */
		
		//update the user by id
		/*
		 * Optional<User> optional = userRepository.findById(3); User
		 * user=optional.get(); user.setName("Kalim"); User
		 * result=userRepository.save(user); System.out.println(result);
		 */
		
		//how to get the data
		//findById(id)-return Optional Containing your data
//		Iterable<User> itr = userRepository.findAll();
//		Iterator<User> iterator = itr.iterator();
		/*
		 * while(iterator.hasNext()) { User user=iterator.next();
		 * System.out.println(user); }
		 */
		/*
		 * itr.forEach(new Consumer<User>() {
		 * 
		 * @Override public void accept(User t) { // TODO Auto-generated method stub
		 * System.out.println(t); } });
		 */
//		itr.forEach(user->{System.out.println(user);});
		
		//Deleting the user(Derived query method or customize finder method)
//		userRepository.deleteById(4);
//		System.out.println("deleted");
		
		/*
		 * Iterable<User> allUsers = userRepository.findAll();
		 * allUsers.forEach(user->{System.out.println(user);});
		 * userRepository.deleteAll(allUsers);
		 */
//		List<User> users = userRepository.findByNameAndCity("Ismail Shaikh","Mumbai");
//		users.forEach(e->{System.out.println(e);});
		
		List<User> allUsers=userRepository.getAllUser();
		allUsers.forEach(e->{System.out.println(e);});
		System.out.println("______________________________________");
		
		List<User> userByName = userRepository.getUserByName("Durgesh","Dehli");
		userByName.forEach(e->{System.out.println(e);});
		System.out.println("______________________________________");
		
		userRepository.getUsers().forEach(e->{System.out.println(e);});
	}
}
