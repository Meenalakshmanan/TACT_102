package com.user;

public class User {

		private String id;
		private String name; 
		private String reputation;  
	    private String goldBadges;
	    private String silverBadges;
	    private String bronzeBadges;
	    
	    public User(){	       
	    }
	    
	    public User(String userid,String name,String reputation,String goldBadges,String silverBadges,String bronzeBadges){
	    	this.id =userid;
	    	this.name = name;
	    	this.reputation = reputation;
	    	this.goldBadges = goldBadges;
	    	this.silverBadges = silverBadges;
	    	this.bronzeBadges = bronzeBadges;
	    }
	    
	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getReputation() {
			return reputation;
		}

		public void setReputation(String reputation) {
			this.reputation = reputation;
		}

		public String getGoldBadges() {
			return goldBadges;
		}

		public void setGoldBadges(String goldBadges) {
			this.goldBadges = goldBadges;
		}

		public String getSilverBadges() {
			return silverBadges;
		}

		public void setSilverBadges(String silverBadges) {
			this.silverBadges = silverBadges;
		}

		public String getBronzeBadges() {
			return bronzeBadges;
		}

		public void setBronzeBadges(String bronzeBadges) {
			this.bronzeBadges = bronzeBadges;
		}

	    
	    @Override
	    public String toString() {
	        return "User [id=" + id + ", name=" + name + ", reputation=" + reputation + ", " +
	        		"goldBadges=" + goldBadges + ", silverBadges= "+ silverBadges +",bronzeBadges="+bronzeBadges+"]";
	    }
}
