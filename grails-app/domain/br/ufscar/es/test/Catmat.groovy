package br.ufscar.es.test

class Catmat {

	String descricao
	Boolean sustentavel
	CategoriaCatmat categoriaMaterial
	Date dateCreated
	
	Date lastSync
	Boolean ativo

	static mapping = {
		id generator: 'assigned'
	}

	static constraints = { descricao maxSize: 2048 }

	String toString(){
		return id
	}
	
	static searchable = {
		except = ['dateCreated', 'lastSync']
		id  boost:2.0
		descricao boost: 0.5
	}
}
