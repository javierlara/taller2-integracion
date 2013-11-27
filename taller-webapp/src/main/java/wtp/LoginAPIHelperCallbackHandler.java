
/**
 * LoginAPIHelperCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package wtp;

    /**
     *  LoginAPIHelperCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class LoginAPIHelperCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public LoginAPIHelperCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public LoginAPIHelperCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for login method
            * override this method for handling normal response from login operation
            */
           public void receiveResultlogin(
                    wtp.LoginAPIHelperStub.LoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from login operation
           */
            public void receiveErrorlogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disableAccount method
            * override this method for handling normal response from disableAccount operation
            */
           public void receiveResultdisableAccount(
                    wtp.LoginAPIHelperStub.DisableAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disableAccount operation
           */
            public void receiveErrordisableAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for activateUser method
            * override this method for handling normal response from activateUser operation
            */
           public void receiveResultactivateUser(
                    wtp.LoginAPIHelperStub.ActivateUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from activateUser operation
           */
            public void receiveErroractivateUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resetPassword method
            * override this method for handling normal response from resetPassword operation
            */
           public void receiveResultresetPassword(
                    wtp.LoginAPIHelperStub.ResetPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resetPassword operation
           */
            public void receiveErrorresetPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for logout method
            * override this method for handling normal response from logout operation
            */
           public void receiveResultlogout(
                    wtp.LoginAPIHelperStub.LogoutResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logout operation
           */
            public void receiveErrorlogout(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enableAccount method
            * override this method for handling normal response from enableAccount operation
            */
           public void receiveResultenableAccount(
                    wtp.LoginAPIHelperStub.EnableAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enableAccount operation
           */
            public void receiveErrorenableAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for registerUser method
            * override this method for handling normal response from registerUser operation
            */
           public void receiveResultregisterUser(
                    wtp.LoginAPIHelperStub.RegisterUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from registerUser operation
           */
            public void receiveErrorregisterUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for isTokenValid method
            * override this method for handling normal response from isTokenValid operation
            */
           public void receiveResultisTokenValid(
                    wtp.LoginAPIHelperStub.IsTokenValidResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isTokenValid operation
           */
            public void receiveErrorisTokenValid(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changePassword method
            * override this method for handling normal response from changePassword operation
            */
           public void receiveResultchangePassword(
                    wtp.LoginAPIHelperStub.ChangePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changePassword operation
           */
            public void receiveErrorchangePassword(java.lang.Exception e) {
            }
                


    }
    