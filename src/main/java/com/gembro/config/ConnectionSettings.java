/**
 * 
 */
package com.gembro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author quocanh
 *
 */
@Component
@ConfigurationProperties(prefix="connection")
public class ConnectionSettings {
	private String port; //server.port

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	
}
