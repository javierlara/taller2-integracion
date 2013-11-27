package com.fiuba.taller.service.requests;

import javax.ws.rs.core.Form;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "password-change-request")
public class PasswordChangeRequest {
	
	private String oldPassword;
	private String newPassword;

    public PasswordChangeRequest(){
    	oldPassword = "";
    	newPassword = "";
    }
    
    public PasswordChangeRequest(String oldPassword, String newPassword)
    {
        super();
        this.setOldPassword(oldPassword);
	    this.setNewPassword(newPassword);
    }
    
    @Override 
    public String toString(){
    	String urlEncoded ="";
    	
    	urlEncoded += "oldPassword="+oldPassword+"&";
    	urlEncoded += "newPassword="+newPassword+"&";
    	
    	return urlEncoded;
    }
    
    public Form toForm(){
    	
    	Form dataAsForm = new Form() ;
    	
    	dataAsForm = dataAsForm.param("oldPassword", oldPassword)
			    			   .param("newPassword", newPassword);
    	
    	return dataAsForm; 
    }

	@XmlElement(name = "oldPassword")
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	@XmlElement(name = "newPassword")
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
