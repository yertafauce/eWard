package eWard.vm;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import eWard.entity.Usuario;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@VariableResolver(DelegatingVariableResolver.class)
public class LoginVm {
	
	private Usuario userLogin;
	
	@Init
	public void init() {
		
		log.info("entramos en LoginVm");
		
	}
}
