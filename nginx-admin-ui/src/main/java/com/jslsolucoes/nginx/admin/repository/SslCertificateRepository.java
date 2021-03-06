package com.jslsolucoes.nginx.admin.repository;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.jslsolucoes.nginx.admin.model.SslCertificate;
import com.jslsolucoes.nginx.admin.repository.impl.OperationResult;
import com.jslsolucoes.nginx.admin.repository.impl.OperationType;

public interface SslCertificateRepository {

	public List<SslCertificate> listAll();

	public OperationType delete(SslCertificate sslCertificate);

	public SslCertificate load(SslCertificate sslCertificate);

	public OperationResult saveOrUpdate(SslCertificate sslCertificate, InputStream certificate, InputStream privateKey)
			throws Exception;

	public InputStream download(String hash) throws FileNotFoundException;
}
