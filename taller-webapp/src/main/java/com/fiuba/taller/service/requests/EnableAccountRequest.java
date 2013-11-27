package com.fiuba.taller.service.requests;

import javax.ws.rs.core.Form;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class EnableAccountRequest {
	
	private String username;
	private String enabledToken;

    public EnableAccountRequest(){
    	username = "";
    	enabledToken = "";
    }
    
    public EnableAccountRequest(String username, String enabledToken)
    {
        super();
        this.setUsername(username);
	    this.setEnabledToken(enabledToken);
    }
    
    @Override 
    public String toString(){
    	String urlEncoded ="";
    	
    	urlEncoded += "username="+username+"&";
    	urlEncoded += "enabledToken="+enabledToken+"&";
    	
    	return urlEncoded;
    }
    
    public Form toForm(){
    	
    	Form dataAsForm = new Form() ;
    	
    	dataAsForm = dataAsForm.param("username", username)
			    			   .param("enabledToken", enabledToken);
    	
    	return dataAsForm; 
    }

	@XmlElement(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@XmlElement(name = "enabledToken")
	public String getEnabledToken() {
		return enabledToken;
	}

	public void setEnabledToken(String enabledToken) {
		this.enabledToken = enabledToken;
	}
}
