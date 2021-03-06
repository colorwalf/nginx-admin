package com.jslsolucoes.nginx.admin.repository;

import java.util.List;

import com.jslsolucoes.nginx.admin.model.Upstream;
import com.jslsolucoes.nginx.admin.model.UpstreamServer;
import com.jslsolucoes.nginx.admin.repository.impl.OperationResult;
import com.jslsolucoes.nginx.admin.repository.impl.OperationType;

public interface UpstreamRepository {

	public List<Upstream> listAll();

	public OperationType delete(Upstream upstream) throws Exception;

	public Upstream load(Upstream upstream);

	public OperationResult saveOrUpdate(Upstream upstream, List<UpstreamServer> upstreamServers) throws Exception;
	
	public List<String> validateBeforeSaveOrUpdate(Upstream upstream, List<UpstreamServer> upstreamServers);

	public Upstream findByName(String name);

	public Upstream hasEquals(Upstream upstream);

}
