package com.jslsolucoes.nginx.admin.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "server", schema = "admin")
public class Server implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ip")
	private String ip;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="server")
	private Set<UpstreamServer> upstreamServers;
	
	public Server() {
	
	}
	
	public Server(Long id) {
		this.id = id;
	}

	public Server(Long id, String ip) {
		this.id = id;
		this.ip = ip;
	}

	public Server(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<UpstreamServer> getUpstreamServers() {
		return upstreamServers;
	}

}
