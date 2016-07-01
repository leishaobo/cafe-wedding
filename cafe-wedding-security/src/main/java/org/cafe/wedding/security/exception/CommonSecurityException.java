package org.cafe.wedding.security.exception;

/**
 * 安全类库通用异常
 * @author leishaobo
 * @email leishaobo_cafe@163.com
 * @createime 2016年7月1日
 *
 */
public class CommonSecurityException extends RuntimeException {
	private static final long serialVersionUID = -775024054441014467L;
	
	public CommonSecurityException() {
		super();
	}
	public CommonSecurityException(String message) {
		super(message);
	}
	public CommonSecurityException(String message, Throwable cause) {
		super(message,cause);
	}
	

}
