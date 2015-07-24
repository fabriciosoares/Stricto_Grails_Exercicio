package stricto_grails_exercicio

import grails.test.spock.IntegrationSpec

class PostIntegrationSpec extends IntegrationSpec {

	def setup() {
	}

	def cleanup() {
	}

	void "Criando uma postagem"() {
		when:
			def user = new User(userId: 'joe', password: 'secret').save()
			def post1 = new Post(content: "First post... W00t!")
			user.addToPosts(post1)
			def post2 = new Post(content: "Second post...")
			user.addToPosts(post2)
			def post3 = new Post(content: "Third post...")
			user.addToPosts(post3)
		then:
			3 == User.get(user.id).posts.size()
	}
	
	void "Acessando uma postagem no gráfico de objetos"() {
		when:
			def user = new User(userId: 'joe', password: 'secret').save()
			user.addToPosts(new Post(content: "First"))
			user.addToPosts(new Post(content: "Second"))
			user.addToPosts(new Post(content: "Third"))
			def foundUser = User.get(user.id)
			def postNames = foundUser.posts.collect { it.content }
		then:
			['First', 'Second', 'Third'] == postNames.sort()
	}
	
}
