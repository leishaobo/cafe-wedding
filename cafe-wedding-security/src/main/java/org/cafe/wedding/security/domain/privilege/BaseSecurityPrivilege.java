package org.cafe.wedding.security.domain.privilege;


import java.util.HashSet;
import java.util.Set;

import org.cafe.wedding.security.domain.operate.BaseSecurityOperate;
import org.cafe.wedding.security.domain.resources.BaseSecurityResource;
import org.cafe.wedding.security.exception.CommonSecurityException;

/**
 * 权限表
 * 资源+操作行为
 * @author leishaobo
 *
 */
public class BaseSecurityPrivilege {
	
	private BaseSecurityResource resource;
	private BaseSecurityOperate operate;
	
	
	
	public BaseSecurityPrivilege() {
		super();
	}
	
	public BaseSecurityPrivilege(BaseSecurityResource resource) {
		super();
		this.resource = resource;
	}

	public BaseSecurityPrivilege(BaseSecurityResource resource, BaseSecurityOperate operate) {
		super();
		this.resource = resource;
		this.operate = operate;
	}

	public BaseSecurityResource getResource() {
		return resource;
	}
	public void setResource(BaseSecurityResource resource) {
		this.resource = resource;
	}
	public BaseSecurityOperate getOperate() {
		return operate;
	}
	public void setOperate(BaseSecurityOperate operate) {
		this.operate = operate;
	}
	@Override
	public String toString() {
		if(this.resource==null || this.operate==null){
			throw new CommonSecurityException("resource or operate is null");
		}
		return String.format("%s_%s", resource.getCode(),operate.getCode());
	}
	
	public static Set<BaseSecurityPrivilege> generateAllPrivileges(BaseSecurityResource resource){
		if(resource==null){
			throw new CommonSecurityException("resource is null");
		}
		Set<BaseSecurityPrivilege> privilegesSet=new HashSet<BaseSecurityPrivilege>();
		
		for(BaseSecurityOperate operate:BaseSecurityOperate.values()){
			BaseSecurityPrivilege newPrivilege=new BaseSecurityPrivilege(resource,operate);
			privilegesSet.add(newPrivilege);
		}
		return privilegesSet;
		
	}
}
