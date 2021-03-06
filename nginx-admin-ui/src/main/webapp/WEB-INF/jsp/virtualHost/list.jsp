<%@include file="../app/taglibs.jsp"%>
<html:view title="{title}">

	<html:block>
		<html:alert state="success" label="{virtualHost.delete.success}"
			rendered="${ operation == 'DELETE' }"></html:alert>
	</html:block>

	<html:block>

		<html:grid
		 search="true" url="/virtualHost/list"
		 data="${ virtualHostList }" var="virtualHost" label="{virtualHost.list}" paginate="false">
			<html:gridColumn label="{virtualHost.aliases}">
				<html:listGroup>
					<c:forEach items="${ virtualHost.aliases }" var="virtualHostAlias">
						<html:listGroupItem>${ virtualHostAlias.alias }</html:listGroupItem>
					</c:forEach>
				</html:listGroup>
			</html:gridColumn>
			<html:gridColumn label="{virtualHost.https}" booleanType="true" exportable="true">
				${ virtualHost.https }
			</html:gridColumn>
			<html:gridColumn label="{ssl.common.name}" exportable="true">
				${ virtualHost.sslCertificate.commonName }
			</html:gridColumn>
			<html:gridColumn label="{virtualHost.locations}" collapsable="true">
				<html:grid data="${ virtualHost.locations }" var="virtualHostLocation" simple="true">
					<html:gridColumn label="{virtualHost.location}">
						${ virtualHostLocation.path }
					</html:gridColumn>
					<html:gridColumn label="{upstream.name}">
						${ virtualHostLocation.upstream.name }
					</html:gridColumn>
				</html:grid>
			</html:gridColumn>
			<html:gridColumn>
				<html:buttonGroup spaced="true">
					<html:button icon="pencil" url="/virtualHost/edit/${ virtualHost.id }"></html:button>
					<html:button state="danger" id="${ virtualHost.id }" icon="trash" url="#"></html:button>
					<html:confirm attachTo="${ virtualHost.id }" url="/virtualHost/delete/${ virtualHost.id }">
						<fmt:message key="virtualHost.delete.confirm">
							<c:forEach items="${ virtualHost.aliases }" var="virtualHostAlias">
								<fmt:param value="${ virtualHostAlias.alias }"></fmt:param>
							</c:forEach>
						</fmt:message>
					</html:confirm>
				</html:buttonGroup>
			</html:gridColumn>
			
			<html:toolbar>
				<html:button icon="plus" url="/virtualHost/form"></html:button>
			</html:toolbar>
			
		</html:grid>
	</html:block>

</html:view>