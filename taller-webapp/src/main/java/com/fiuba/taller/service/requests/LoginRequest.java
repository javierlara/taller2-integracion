package com.fiuba.taller.service.requests;

import javax.ws.rs.core.Form;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "login-request")
public class LoginRequest {
	
	private String username;
	private String password;

    public LoginRequest(){
    	username = "";
    	password = "";
    }
    
    public LoginRequest(String username, String password)
    {
        super();
        this.setUsername(username);
	    this.setPassword(password);
    }
    
    @Override 
    public String toString(){
    	String urlEncoded ="";
    	
    	urlEncoded += "username="+username+"&";
    	urlEncoded += "password="+password+"&";
    	
    	return urlEncoded;
    }
    
    public Form toForm(){
    	
    	Form dataAsForm = new Form() ;
    	
    	dataAsForm = dataAsForm.param("username", username)
			    			   .param("password", password);
    	
    	return dataAsForm; 
    }

	@XmlElement(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@XmlElement(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
