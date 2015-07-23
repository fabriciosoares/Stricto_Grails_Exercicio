<%@ page import="stricto_grails_exercicio.Tag" %>



<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="tag.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${tagInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="tag.posts.label" default="Posts" />
		
	</label>
	<g:select name="posts" from="${stricto_grails_exercicio.Post.list()}" multiple="multiple" optionKey="id" size="5" value="${tagInstance?.posts*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: tagInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="tag.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${stricto_grails_exercicio.User.list()}" optionKey="id" required="" value="${tagInstance?.user?.id}" class="many-to-one"/>

</div>

