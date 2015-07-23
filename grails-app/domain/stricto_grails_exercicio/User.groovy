package stricto_grails_exercicio

class User {
	
	String userId
	String password
	String homepage
	Date dateCreated
	Profile profile
	
	static hasMany = [ posts : Post, tags : Tag, following : User ]
	
	static constraints = {
		userId(
//			matches: '[0­9]{7}[A­Za­z]',
			size:3..20,
			unique: true
		)
		password(
			size: 6..8,
			validator: {
				passwd, user -> return passwd != user.userId
			})
		homepage(url: true, nullable: true)
		profile(nullable: true)
		profile lazy:false
		dateCreated column: 'CREATED'
	}
	
}