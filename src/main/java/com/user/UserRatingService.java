package com.user;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserRatingService {
	
	 
	private static HashMap<String,Object> users = new HashMap<String,Object>();
		 
		 
		 public HashMap<String,Object> retrieveAllUsers() {
				return this.users;
			}
		 
		 public HashMap<String,Object> retrieveUser(String userid){
             
			 Document doc;
				try {
					
					doc = Jsoup.connect("https://stackoverflow.com/users/919514/olivier").get();
					String userName = doc.select("h2.user-card-name").text();
					System.out.println("User Name: " + userName);
					Elements el = doc.select("div#avatar-card");
					//System.out.println("element: " + el); 
					for(Element element : el.select("div.avatar")){
						String id = el.select("a").attr("href");
						//System.out.println("User ID:"  + id);
						String uid = id.substring(32, 38);
						System.out.println("User ID:"  + uid);
												
						String userReputation = el.select("div.reputation").text();
						System.out.println("Reputation:"  + userReputation);
						String userGoldBadges = el.select("span.badge1-alternate").attr("title");
						String userSilverBadges = el.select("span.badge2-alternate").attr("title");
						String userBronzeBadges = el.select("span.badge3-alternate").attr("title");
						//String userBadges = el.select("div.badges").text();
						System.out.println("Medals: " + userGoldBadges +", "+ userSilverBadges +", "+ userBronzeBadges);
					
						users.put("id", uid);
						users.put("userName", userName);
						users.put("userReputation", userReputation);
						users.put("userGoldBadges", userGoldBadges);
						users.put("userSilverBadges", userSilverBadges);
						users.put("userBronzeBadges", userBronzeBadges);
						System.out.println(users);
				}
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return users;	
 }
		
		 
}



/*static{
Document doc;
	try {
		
		doc = Jsoup.connect("https://stackoverflow.com/users/919514/olivier").get();
		String userName = doc.select("h2.user-card-name").text();
		System.out.println("User Name: " + userName);
		Elements el = doc.select("div#avatar-card");
		//System.out.println("element: " + el); 
		for(Element element : el.select("div.avatar")){
			String id = el.select("a").attr("href");
			//System.out.println("User ID:"  + id);
			String userid = id.substring(32, 38);
			System.out.println("User ID:"  + userid);
			int uid = Integer.parseInt(userid);
			System.out.println("User ID:"  + uid);
			
			String userReputation = el.select("div.reputation").text();
			System.out.println("Reputation:"  + userReputation);
			String userGoldBadges = el.select("span.badge1-alternate").attr("title");
			String userSilverBadges = el.select("span.badge2-alternate").attr("title");
			String userBronzeBadges = el.select("span.badge3-alternate").attr("title");
			//String userBadges = el.select("div.badges").text();
			System.out.println("Medals: " + userGoldBadges +", "+ userSilverBadges +", "+ userBronzeBadges);
			User user1 = new User(userid,userName,userReputation, userGoldBadges,userSilverBadges,userBronzeBadges);
		        users.put(id, user1);
		       
		        //users.putAll(users);
		        
	}
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	

	
}*/		 

/*public User retrieveUser(String userid) {		
for(User user : users){
        if(user.getId().equals(userid)){
            return user;
        }
    }
    return null;
}*/
/*public HashMap<String,User> retrieveUser(String userid) {
Iterator<Map.Entry<String, User>> it = users.entrySet().iterator();
while(it.hasNext()){
    it.next();
    System.out.println(users.get(it));
}
return users;
}*/
