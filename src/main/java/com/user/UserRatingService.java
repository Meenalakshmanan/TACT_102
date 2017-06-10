package com.user;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserRatingService {
	
	 private static List<User> users = new ArrayList<User>();
		 static{
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
					        users.add(user1);
					        
				}
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			 
				
		 }
		 
		 public List<User> retrieveAllUsers() {
				return users;
			}
		public User retrieveUser(String userid) {
			    for(User user : users){
			        if(user.getId().equals(userid)){
			            return user;
			        }
			    }
			    return null;
			}
}
