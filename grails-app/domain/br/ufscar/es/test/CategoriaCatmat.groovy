package br.ufscar.es.test

class CategoriaCatmat {

	String nome

	static mapping = {
		id generator: 'assigned'
	}

	static searchable = true

	String toString(){
		return "${nome}"
	}

	static constraints = {
	}
}
