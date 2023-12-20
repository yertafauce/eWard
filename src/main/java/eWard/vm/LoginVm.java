package eWard.vm;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.Notification;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zkplus.spring.SpringUtil;

import eWard.entity.Usuario;
import eWard.service.UsuarioManager;

import java.io.IOException;
import java.util.Set;	


@Slf4j
@Getter
@Setter
@VariableResolver(DelegatingVariableResolver.class)
public class LoginVm {

	
	
	 private Usuario userlogin;
	 private String error;
	 private String	 errorDominio;
	 private String artifact="";
	 private String errorConexionDDBB;
	 
	 
	 
	
	 
	 @WireVariable
		private UsuarioManager usuarioMag;

	// private Config config;
    /**
     * Called once on upon the initial request.
     */
			
		
	 
	 
    @Init
    public void init() {

    	log.info("Iniciamos LoginVm");
    	
    	try {
			
			usuarioMag.getAll();
			
			
		}catch (Exception e) {
			errorConexionDDBB="true";
			log.warn("there is no connection to the database");
		}
		
    
//			Sessions.getCurrent().setAttribute("onLine", String.valueOf( cnxsercomMag.isOnline()));
		
			
       
        this.userlogin = new Usuario();
       
		try {
			
			
			
		} catch (Exception e ) {
			
			
			log.error("Error Version: "+e); 
		}

        
    }
    @AfterCompose
    public void doAfterComposer() {
    	log.info("Entramos doAfterComposer");
    	 	Execution exec = Executions.getCurrent();
    	    String param=exec.getParameter("error");
    	    this.error = param;
    	    String paramDominio=exec.getParameter("errorDominio");
    	    this.errorDominio = paramDominio;
    	    
    	    
    }
 

    @Command
	public void logon() throws IOException {
    	
   
    	
    	Clients.submitForm("formLogin");
    }
  

    private void showError(String error) {
        Notification.show(error,
                Notification.TYPE_ERROR, null,
                400,
                400, 2000, false);
    }
}
