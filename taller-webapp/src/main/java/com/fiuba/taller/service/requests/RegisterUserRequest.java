package com.fiuba.taller.service.requests;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "register-user-request")
public class RegisterUserRequest {
	
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private Integer padron;
	private String fechaNac;
	private String email;
	private Integer rol;

    public RegisterUserRequest(){}
    
    public RegisterUserRequest(String username,
					    		String password,
					    		String nombre,
					    		String apellido,
					    		Integer padron,
					    		String fechaNac,
					    		String email,
					    		Integer rol)
    {
        super();
        this.setUsername(username);
	    this.setPassword(password);
	    this.setNombre(nombre);
	    this.setApellido(apellido);
	    this.setPadron(padron);
	    this.setFechaNac(fechaNac);
	    this.setEmail(email);
	    this.setRol(rol);
        
        
    }
    
    @Override 
    public String toString(){
    	String urlEncoded ="";
    	
    	urlEncoded += "username="+username+"&";
    	urlEncoded += "password="+password+"&";
    	urlEncoded += "nombre="+nombre+"&";
    	urlEncoded += "apellido="+apellido+"&";
    	urlEncoded += "padron="+padron+"&";
    	urlEncoded += "fechaNac="+fechaNac+"&";
    	urlEncoded += "email="+email+"&";
    	urlEncoded += "rol="+rol;
    	
    	
    	return urlEncoded;
    }
    
    public Form toForm(){
    	
    	Form dataAsForm = new Form() ;
    	
    	dataAsForm = dataAsForm.param("username", username)
			    			   .param("password", password)
			    			   .param("nombre", nombre)
			    			   .param("apellido", apellido)
			    			   .param("padron", Integer.toString(padron))
			    			   .param("fechaNac", fechaNac)
			    			   .param("email", email)
			    			   .param("rol", Integer.toString(rol));
    	
    	return dataAsForm; 
    }
    
    public Map<String, String> toMap(){
    	
    	Map<String, String> dataAsMap= new HashMap<String, String>() ;
    	
    	dataAsMap.put("username", username);
    	dataAsMap.put("password", password);
    	dataAsMap.put("nombre", nombre);
    	dataAsMap.put("apellido", apellido);
    	dataAsMap.put("padron", Integer.toString(padron));
    	dataAsMap.put("fechaNac", fechaNac);
    	dataAsMap.put("email", email);
    	dataAsMap.put("rol", Integer.toString(rol));
    	
    	return dataAsMap; 
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

	@XmlElement(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name = "padron")
	public Integer getPadron() {
		return padron;
	}

	public void setPadron(Integer padron) {
		this.padron = padron;
	}

	@XmlElement(name = "fechaNac")
	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "rol")
	public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
	}

	@XmlElement(name = "apellido")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
