package com.fiuba.taller.service;

import java.io.IOException;
import java.io.StringReader;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.fiuba.taller.service.requests.EnableAccountRequest;
import com.fiuba.taller.service.requests.LoginRequest;
import com.fiuba.taller.service.requests.PasswordChangeRequest;
import com.fiuba.taller.service.requests.RegisterUserRequest;
import javax.ws.rs.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import wtp.LoginAPIHelperStub;


@Path("/securityservice")
@Produces(MediaType.APPLICATION_JSON)
public class SecurityService {

	private Document getDoc(String xml) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		Document doc = dBuilder.parse(is);
		doc.getDocumentElement().normalize();
		
		return doc;
	} 
	
	private Node getNode(Document doc, String nodeName){
		
		return doc.getElementsByTagName(nodeName).item(0);
	}
	
	private String getFirstElementValue(Node node, String eName){
		
		Element elem = (Element) node;
		
		return elem.getElementsByTagName("success").item(0).getTextContent();
	}

	@POST
	@Path("registeruser")
	@Consumes("application/json")
	public Response registerUser(RegisterUserRequest request)
			throws ParserConfigurationException, SAXException, IOException
	{
		
		System.out.println(request);
		
		// Init
		SecurityResponse response = new SecurityResponse();
		
		LoginAPIHelperStub api = new LoginAPIHelperStub();  
		LoginAPIHelperStub.RegisterUser securityRequest = new LoginAPIHelperStub.RegisterUser();
		LoginAPIHelperStub.RegisterUserResponse wsResponse = new LoginAPIHelperStub.RegisterUserResponse();
		
		// Armar el request
		securityRequest.setUsername(request.getUsername());
		securityRequest.setPassword(request.getPassword());
		securityRequest.setNombres(request.getNombre());
		securityRequest.setApellido(request.getApellido());
		securityRequest.setPadron(Integer.toString(request.getPadron()));
		securityRequest.setFecha(request.getFechaNac());
		securityRequest.setEmail(request.getEmail());
		securityRequest.setRol(request.getRol());
		
		// Hacer el request
		wsResponse = api.registerUser(securityRequest);
			
		// Parsear el response
		Document doc = getDoc(wsResponse.get_return());
		Node node = getNode(doc, "response");

		String success = getFirstElementValue( node, "success");

		if (success == "1"){
			response.setSuccess(true);
			response.setReason("Usuario creado exitosamente");

		}else{
			response.setSuccess(false);
			response.setReason(getFirstElementValue(node, "reason"));
		}

		return Response.ok().entity(response).build();
	}
	

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(LoginRequest request)
			throws ParserConfigurationException, SAXException, IOException
	{

		System.out.println(request);
		
		// Init
		SecurityResponse response = new SecurityResponse();
		
		LoginAPIHelperStub api = new LoginAPIHelperStub();  
		LoginAPIHelperStub.Login securityRequest = new LoginAPIHelperStub.Login();
		LoginAPIHelperStub.LoginResponse wsResponse = new LoginAPIHelperStub.LoginResponse();
		
		securityRequest.setUsername(request.getUsername());
		securityRequest.setPassword(request.getPassword());
		
		// Hacer el request
		wsResponse = api.login(securityRequest);

		// Parsear el response
		Document doc = getDoc(wsResponse.get_return());
		Node node = getNode(doc, "response");

		String success = getFirstElementValue( node, "success");

		if (success == "1"){

			return Response.ok()
					.cookie(new NewCookie("authToken",
							getFirstElementValue(node, "authToken")))
					.build();

		}else{
			response.setSuccess(false);
			response.setReason(getFirstElementValue(node, "reason"));
			
			return Response.ok()
					.entity(response)
					.build();
		}

	}

	@POST
	@Path("logout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logout(@CookieParam("authToken") String authToken) 
			throws ParserConfigurationException, SAXException, IOException
	{
		System.out.println("@CookieParam: " + authToken);
		// Init
		SecurityResponse response = new SecurityResponse();

		LoginAPIHelperStub api = new LoginAPIHelperStub();  
		LoginAPIHelperStub.Logout securityRequest = new LoginAPIHelperStub.Logout();
		LoginAPIHelperStub.LogoutResponse wsResponse = new LoginAPIHelperStub.LogoutResponse();

		securityRequest.setAuthToken(authToken);

		// Hacer el request
		wsResponse = api.logout(securityRequest);

		// Parsear el response
		Document doc = getDoc(wsResponse.get_return());
		Node node = getNode(doc, "response");

		String success = getFirstElementValue( node, "success");

		if (success == "1"){

			return Response.ok()
					.header("Set-Cookie",
							"authToken=deleted;Expires=Thu, 01-Jan-1970 00:00:01 GMT")
					.build();

		}else{
			response.setSuccess(false);
			response.setReason(getFirstElementValue(node, "reason"));
			
			return Response.ok()
					.entity(response)
					.build();
		}
	}


	@POST
	@Path("isloggedin")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response isLoggedIn(@CookieParam("authToken") String authToken) 
			throws ParserConfigurationException, SAXException, IOException
	{
		
		System.out.println("@CookieParam: " + authToken);
		// Init
		SecurityResponse response = new SecurityResponse();

		LoginAPIHelperStub api = new LoginAPIHelperStub();  
		LoginAPIHelperStub.IsTokenValid securityRequest = new LoginAPIHelperStub.IsTokenValid();
		LoginAPIHelperStub.IsTokenValidResponse wsResponse = new LoginAPIHelperStub.IsTokenValidResponse();

		securityRequest.setAuthToken(authToken);

		// Hacer el request
		wsResponse = api.isTokenValid(securityRequest);

		// Parsear el response
		Document doc = getDoc(wsResponse.get_return());
		Node node = getNode(doc, "response");

		String success = getFirstElementValue( node, "success");

		if (success == "1"){

			return Response.ok()
					.build();

		}else{
			response.setSuccess(false);
			response.setReason(getFirstElementValue(node, "reason"));
			
			return Response.ok()
					.entity(response)
					.build();
		}
	}

	@POST
	@Path("activateuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response activateUser(LoginRequest request) 
			throws ParserConfigurationException, SAXException, IOException
	{
		System.out.println(request);
		SecurityResponse response = new SecurityResponse();
		
		if (request.getUsername() == "") {
			response = new SecurityResponse(false, "Parametros Invalidos: username vacio");
			
			return Response.ok().entity(response).build();
		
		} else {
			
			LoginAPIHelperStub api = new LoginAPIHelperStub();  
			LoginAPIHelperStub.ActivateUser securityRequest = new LoginAPIHelperStub.ActivateUser();
			LoginAPIHelperStub.ActivateUserResponse wsResponse = new LoginAPIHelperStub.ActivateUserResponse();
			
			securityRequest.setUsername(request.getUsername());
			
			// Hacer el request
			wsResponse = api.activateUser(securityRequest);

			// Parsear el response
			Document doc = getDoc(wsResponse.get_return());
			Node node = getNode(doc, "response");

			String success = getFirstElementValue( node, "success");

			if (success == "1"){
				response.setSuccess(true);
				response.setReason("Usuario activado exitosamente");
				
			}else{
				response.setSuccess(false);
				response.setReason(getFirstElementValue(node, "reason"));
				
			}
			
			return Response.ok()
					.entity(response)
					.build();
		}
	}

	@POST
	@Path("changepassword")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response changePassword(PasswordChangeRequest request,@CookieParam("authToken") String authToken) 
			throws ParserConfigurationException, SAXException, IOException
	{
		System.out.println(request);
		SecurityResponse response = new SecurityResponse();
		

		if (request.getOldPassword() == "" || request.getNewPassword() == "") {
			response = new SecurityResponse(false,
					"Parametros Invalidos");
			
			return Response.ok().entity(response).build();
			
		} else {
			
			LoginAPIHelperStub api = new LoginAPIHelperStub();  
			LoginAPIHelperStub.ChangePassword securityRequest = new LoginAPIHelperStub.ChangePassword();
			LoginAPIHelperStub.ChangePasswordResponse wsResponse = new LoginAPIHelperStub.ChangePasswordResponse();
			
			securityRequest.setNewPassword(request.getNewPassword());
			securityRequest.setOldPassword(request.getOldPassword() );
			securityRequest.setAuthToken(authToken);
			
			// Hacer el request
			wsResponse = api.changePassword(securityRequest);

			// Parsear el response
			Document doc = getDoc(wsResponse.get_return());
			Node node = getNode(doc, "response");

			String success = getFirstElementValue( node, "success");

			if (success == "1"){
				response.setSuccess(true);
				response.setReason("Contaseña actualizada");
				
			}else{
				response.setSuccess(false);
				response.setReason(getFirstElementValue(node, "reason"));
				
			}
			
			return Response.ok()
					.entity(response)
					.build();
		}
	}

	@POST
	@Path("resetpassword")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response resetPassword(LoginRequest request,@CookieParam("authToken") String authToken)
			throws ParserConfigurationException, SAXException, IOException
	{
		
		System.out.println(request);
		SecurityResponse response = new SecurityResponse();
		
		if (request.getUsername() == "") {
			response = new SecurityResponse(false, "Parametros Invalidos: username vacio");
			
			return Response.ok().entity(response).build();
		
		} else {
			
			LoginAPIHelperStub api = new LoginAPIHelperStub();  
			LoginAPIHelperStub.ResetPassword securityRequest = new LoginAPIHelperStub.ResetPassword();
			LoginAPIHelperStub.ResetPasswordResponse wsResponse = new LoginAPIHelperStub.ResetPasswordResponse();
			
			securityRequest.setAuthToken(authToken);
			securityRequest.setUserId(request.getUsername());
			
			// Hacer el request
			wsResponse = api.resetPassword(securityRequest);

			// Parsear el response
			Document doc = getDoc(wsResponse.get_return());
			Node node = getNode(doc, "response");

			String success = getFirstElementValue( node, "success");

			if (success == "1"){
				response.setSuccess(true);
				response.setReason("Contraseña Reseteada");
				
			}else{
				response.setSuccess(false);
				response.setReason(getFirstElementValue(node, "reason"));
				
			}
			
			return Response.ok()
					.entity(response)
					.build();
		}
	}

	@POST
	@Path("disableaccount")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response disableAccount(LoginRequest request,@CookieParam("authToken") String authToken)
			throws ParserConfigurationException, SAXException, IOException
	{
		System.out.println(request);
		SecurityResponse response = new SecurityResponse();
		
		if (request.getUsername() == "") {
			response = new SecurityResponse(false, "Parametros Invalidos: username vacio");
			
			return Response.ok().entity(response).build();
		
		} else {
			
			LoginAPIHelperStub api = new LoginAPIHelperStub();  
			LoginAPIHelperStub.DisableAccount securityRequest = new LoginAPIHelperStub.DisableAccount();
			LoginAPIHelperStub.DisableAccountResponse wsResponse = new LoginAPIHelperStub.DisableAccountResponse();
			
			securityRequest.setAuthToken(authToken);
			securityRequest.setUserId(request.getUsername());
			
			// Hacer el request
			wsResponse = api.disableAccount(securityRequest);

			// Parsear el response
			Document doc = getDoc(wsResponse.get_return());
			Node node = getNode(doc, "response");

			String success = getFirstElementValue( node, "success");

			if (success == "1"){
				response.setSuccess(true);
				response.setReason("Cuenta suspendida");
				
			}else{
				response.setSuccess(false);
				response.setReason(getFirstElementValue(node, "reason"));
				
			}
			
			return Response.ok()
					.entity(response)
					.build();
		}
	}

	@POST
	@Path("enableaccount")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response enableAccount(EnableAccountRequest request,@CookieParam("authToken") String authToken)
			throws ParserConfigurationException, SAXException, IOException
	{
		
		System.out.println(request);
		SecurityResponse response = new SecurityResponse();
		
		if (request.getUsername() == "") {
			response = new SecurityResponse(false, "Parametros Invalidos: username vacio");
			
			return Response.ok().entity(response).build();
		
		} else {
			
			LoginAPIHelperStub api = new LoginAPIHelperStub();  
			LoginAPIHelperStub.EnableAccount securityRequest = new LoginAPIHelperStub.EnableAccount();
			LoginAPIHelperStub.EnableAccountResponse wsResponse = new LoginAPIHelperStub.EnableAccountResponse();
			
			securityRequest.setAuthToken(authToken);
			securityRequest.setUserId(request.getUsername());
			
			// Hacer el request
			wsResponse = api.enableAccount(securityRequest);

			// Parsear el response
			Document doc = getDoc(wsResponse.get_return());
			Node node = getNode(doc, "response");

			String success = getFirstElementValue( node, "success");

			if (success == "1"){
				response.setSuccess(true);
				response.setReason("Cuenta habilitada");
				
			}else{
				response.setSuccess(false);
				response.setReason(getFirstElementValue(node, "reason"));
				
			}
			
			return Response.ok()
					.entity(response)
					.build();
		}
	}

	
//	@POST
//	@Path("enableaccountfromemaill")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response enableAccountFromEmaill(EnableAccountRequest request) 
//			throws ParserConfigurationException, SAXException, IOException
//	{
//		
//		System.out.println(request);
//		SecurityResponse response = new SecurityResponse();
//
//		if (request.getEnabledToken() == "") {
//			response = new SecurityResponse(false,
//					"Parametros Invalidos: token vacio");
//			return Response.ok().entity(response).build();
//		} else {
//
//			LoginAPIHelperStub api = new LoginAPIHelperStub();  
//			LoginAPIHelperStub.EnableAccountFromEmail securityRequest = new LoginAPIHelperStub.EnableAccountFromEmail();
//			LoginAPIHelperStub.EnableAccountFromEmailResponse wsResponse = new LoginAPIHelperStub.EnableAccountFromEmailResponse();
//			
//			securityRequest.setAuthToken(request.getEnabledToken());
//			securityRequest.setUserId(request.getUsername());
//			
//			// Hacer el request
//			wsResponse = api.enableAccount(securityRequest);
//
//			// Parsear el response
//			Document doc = getDoc(wsResponse.get_return());
//			Node node = getNode(doc, "response");
//
//			String success = getFirstElementValue( node, "success");
//
//			if (success == "1"){
//				response.setSuccess(true);
//				response.setReason("Cuenta habilitada");
//				
//			}else{
//				response.setSuccess(false);
//				response.setReason(getFirstElementValue(node, "reason"));
//				
//			}
//			
//			return Response.ok()
//					.entity(response)
//					.build();
//		}
//	}
}