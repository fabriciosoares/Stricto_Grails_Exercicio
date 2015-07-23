<%@ page import="stricto_grails_exercicio.Profile" %>



<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'fullName', 'error')} ">
	<label for="fullName">
		<g:message code="profile.fullName.label" default="Full Name" />
		
	</label>
	<g:textField name="fullName" value="${profileInstance?.fullName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'bio', 'error')} ">
	<label for="bio">
		<g:message code="profile.bio.label" default="Bio" />
		
	</label>
	<g:textArea name="bio" cols="40" rows="5" maxlength="1000" value="${profileInstance?.bio}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'homepage', 'error')} ">
	<label for="homepage">
		<g:message code="profile.homepage.label" default="Homepage" />
		
	</label>
	<g:field type="url" name="homepage" value="${profileInstance?.homepage}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="profile.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${profileInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'photo', 'error')} ">
	<label for="photo">
		<g:message code="profile.photo.label" default="Photo" />
		
	</label>
	<input type="file" id="photo" name="photo" />

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'country', 'error')} ">
	<label for="country">
		<g:message code="profile.country.label" default="Country" />
		
	</label>
	<g:textField name="country" value="${profileInstance?.country}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'timezone', 'error')} ">
	<label for="timezone">
		<g:message code="profile.timezone.label" default="Timezone" />
		
	</label>
	<g:textField name="timezone" value="${profileInstance?.timezone}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'jabberAddress', 'error')} ">
	<label for="jabberAddress">
		<g:message code="profile.jabberAddress.label" default="Jabber Address" />
		
	</label>
	<g:field type="email" name="jabberAddress" value="${profileInstance?.jabberAddress}"/>

</div>

