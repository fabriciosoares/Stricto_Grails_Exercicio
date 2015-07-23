<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>	<html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>	<html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>	<html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<title>Hubbub &raquo; <g:layoutTitle default="Welcome" /></title>
		<link rel="stylesheet" href="
			<g:createLinkTo dir='css' file='hubbub.css'/>"
		/>
		<g:layoutHead />
	</head>
	<body>
		<div>
			<div id="hd">
					<a href="<g:createLinkTo dir="/"/>">
					<img id="logo" src="${createLinkTo(dir: 'images', file: 'headerlogo.png')}" alt="hubbub logo"/>
					</a>
			</div>
			<div id="bd"><!-- start body -->
					<g:layoutBody/>
			</div> <!-- end body -->
			<div id="ft">
					<div id="footerText">
						 Hubbub - Social Networking on Grails
					</div>
			</div>
		</div>
	</body>
</html>