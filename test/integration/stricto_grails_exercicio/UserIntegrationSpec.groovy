package stricto_grails_exercicio

import grails.test.spock.IntegrationSpec

class UserIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Salvar e obter usuário do banco"() {
        when:
        	def user = new User(userId: 'andre', password: 'secret', homepage: 'http://www.cin.ufpe.br/~alrd')
        then:
        	user.save() != null
			user.id != null
        when:
        	def foundUser = User.get(user.id)
        then:
        	'andre' == foundUser.userId
    }
	
	void "Salvar e atualizar no banco"() {
		when:
			def user = new User(userId: 'andre', password: 'secret', homepage: 'http://www.cin.ufpe.br/~alrd')
		then:
			user.save() != null
		when:
			def foundUser = User.get(user.id)
			foundUser.password = 'sesame'
			foundUser.save()
			def editedUser = User.get(user.id)
		then:
			'sesame' == editedUser.password
	}
	
	void "Salvar, então apagar usuário do banco"() {
		when:
			def user = new User(userId: 'andre', password: 'secret', homepage: 'http://www.cin.ufpe.br/~alrd')
		then:
			user.save() != null
		when:
			def foundUser = User.get(user.id)
			foundUser.delete(flush: true)
		then:
			!(User.exists(foundUser.id))
	}
	
	void "Verificando erros de validação"() {
		when:
			def user = new User(userId: 'chuck_norris', password: 'tiny', homepage: 'not­a­url')
		then:
			!(user.validate())
			user.hasErrors()
		when:
			def errors = user.errors
		then:
			"size.toosmall" == errors.getFieldError("password").code
			"tiny" == errors.getFieldError("password").rejectedValue
			"url.invalid" == errors.getFieldError("homepage").code
			"not­a­url" == errors.getFieldError("homepage").rejectedValue
			errors.getFieldError("userId") == null
	}
	
	void "Testar seguidores"() {
		when:
			def glen = new User(userId: 'glen', password:'password').save()
			def peter = new User(userId: 'peter', password:'password').save()
			def sven = new User(userId: 'sven', password:'password').save()
			glen.addToFollowing(peter)
			glen.addToFollowing(sven)
		then:
			2 == glen.following.size()
		when:
			sven.addToFollowing(peter)
		then:
			1 == sven.following.size()
	}

}
