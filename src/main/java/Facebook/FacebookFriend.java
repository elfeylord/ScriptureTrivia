/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facebook;
/**
 *
 * @author Cole
 */
public class FacebookFriend {
    private String name;
    private String id;
    private String profile;

    public FacebookFriend(){
        name = "";
        id = "";
        profile = ""; //src url to profile pic
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getProfile(){
       return profile;
    }
    
    public void setProfile(String profile){
        this.profile = profile;
    }
    
    
}
