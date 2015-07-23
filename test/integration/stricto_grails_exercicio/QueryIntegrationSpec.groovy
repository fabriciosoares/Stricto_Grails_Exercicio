package stricto_grails_exercicio

import com.stricto_grails_exercicio.*
import grails.test.spock.IntegrationSpec
import org.apache.commons.logging.LogFactory

class QueryIntegrationSpec extends IntegrationSpec {

	def setup() {
	}

	def cleanup() {
	}
	
	def log = LogFactory.getLog(getClass())

	void testBasicDynamicFinders() {
		log.debug "================== Início finders =================="
		when: "O usuário tem senha sesame"
			new User(userId: 'glen', password: 'secret',
				profile: new Profile(email: 'glen@glensmith.com')).save()
				new User(userId: 'peter',
					password: 'sesame',
					profile: new Profile(homepage: 'http://www.peter.com/')).save()
				def user = User.findByPassword('sesame')
		then: "O id do usuário é igual a peter"
			'peter' == user.userId
		when: "O id e a senha são glen/secret"
			user = User.findByUserIdAndPassword('glen', 'secret')
		then: "O id do usuário é igual a glen"
			'glen' == user.userId
		when: "A data de criação está entre ontem e hoje"
			def now = new Date()
			def users = User.findAllByDateCreatedBetween(now-1, now)
		then: "O resultado da consulta de usuários é igual a 2"
			2 == users.size()
		when: "Os e-mails dos perfis não estão nulos"
			def profiles = Profile.findAllByEmailIsNotNull()
		then: "A quantidade de perfis é 1"
			1 == profiles.size()
		log.debug "================== Fim =================="
	}
	
	void testEager() {
		log.debug "================== testEager =================="
		when:
			def user = new User(userId: 'glen', password: 'secret')
			user.save()
			user.addToPosts(new Post(content: "First"))
			log.debug "================== Início eager =================="
			def findUser = User.findByUserId('glen', [fetch:[posts:'eager']])
			log.debug "================== Fim eager =================="
		then:
			1 == findUser.posts.size()
			log.debug "================== Fim =================="
	}

}