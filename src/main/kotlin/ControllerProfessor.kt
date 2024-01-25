class ControllerProfessor {

    private val professores =  mutableListOf<Professor>()

    fun menu(){
        do {
            println("1 - Criar")
            println("2 - Atualizar")
            println("3 - Listar")
            println("4 - Excluir")
            println("0 - Sair")
            print("Digite uma das opções: ")
            val escolha = readlnOrNull()
            when(escolha){
                "1" -> criar()
                "2" -> atualizar()
                "3" -> listar()
                "4" -> excluir()
                "0" -> println("Até logo!")
            }
        } while (escolha != "0")

    }

    private fun criar(){
        print("Id: ")
        val id = readln().toInt()

        print("Nome: ")
        val nome = readln()

        print("Idade: ")
        val idade = readln().toInt()

        val professor = Professor(id, nome, idade)
        professores.add(professor)

        println("Professor(a) $nome adicionado(a) com sucesso!")
    }

    private fun atualizar(){
        print("Insira o ID do professor: ")
        val id = readln().toInt()
        var existe = false
        for (professor in professores){
            if(professor.id == id){

                print("Novo nome: ")
                val nome = readln()

                print("Nova idade: ")
                val idade = readln().toInt()

                professor.nome = nome
                professor.idade = idade

                println("Professor(a) atualizado com sucesso!")

                existe = true
            }
        }
        if(!existe){
            println("Não existe professor com o ID $id")
        }

    }

    private fun listar(){
        if (professores.isNotEmpty()) {
            println("---------------")
            professores.forEach { professor: Professor ->
                println("ID: ${professor.id} \nNome: ${professor.nome} \nIdade: ${professor.idade}")
            }
            println("---------------")
        } else{
            println("Lista vazia.")
        }
    }

    private fun excluir(){
        print("Insira o ID do professor: ")
        val id = readln().toInt()
        var existe = false
        for (professor in professores){
            if(professor.id == id){
                professores.remove(professor)
                existe = true
            }
        }
        if(!existe){
            println("Não existe professor com o ID $id")
        }
    }
}

fun main(){
    val controlador =  ControllerProfessor()
    println("Bem vindo!!!")
    controlador.menu()
}