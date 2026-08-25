fun main(){
    // val e var em Kotlin são os dois tipos de variáveis:
        // val: uma constante, não pode ser reatribuida
        // var: variável. Pode ser reatribuida!
        
    // Tudo é tratado como objeto em Kotlin
    // Teoricamente são Wrappers (Conceito de Java/POO)
    
    val nome: String = "Pedro"; // String usa ""
    var idade: Int = 23;
    var altura: Double = 1.75; 
    var peso: Double = 67.00;
    var isVivo: Boolean = true;
    
    val sexo: Char = 'M'; // Char usa ''
    
    // podemos colocar variáveis num print dessas 2 formas:
        // Assim como no JS: ${var}
            // dessa forma permite usar formatadores .format
        // Mais resumido: $var
    
    println("Meu nome é ${nome} e tenho ${idade} anos");
    println("Peso $peso quilos e tenho $altura metros");
    
    if(sexo == 'M') {
        println("Sou homem!");
    } else if(sexo == 'F') {
        println("Sou Mulher!");
    }
    
    // No Kotlin, if é permitido ser usado como expressão
    val isMaior = if(idade >= 18) {
        "Maior de idade";
    } else {
        "Menor de idade";
    }
    println(isMaior);
    
    // Os operadores são padrão:
        // + - * / %
        // > < >= <= == !=
        // && || !
    
    // Kotlin não tem Switch Case mas...
    // Temos when, o Swith Case fodão:
    
    val opcao: Int = 3;
    when(opcao) {
        1 -> println("Um");
        2 -> println("Dois");
        3 -> println("Três");
        else -> println("Invalido");
    }
    
    // Loop For:
        // for in (valor in coleção)
        // for in until (for "padrão")
        // for in downTo ("padrão" de trás para frente)
        // for in step (ao inves de usar i+2, usamos step 2)
        
    val nomes: List<String> = listOf("Eduardo", "Erik", "Lucas", "Pedro", "Rubio"); // Um Array
    
    for(nome: String in nomes) { // lembrando, não precisa tipar em Kotlin
        println(nome);
    }
    for(i in 0 until 10) { // teoricamente: for(int i = 0; i < 10; i++)
        println(i);
    }
    // se colocassemos in 0..10 ele contaria de 0 - 10 /// Poderia tirar o until
    
    // loop while/do while são iguais
    
    // Estrutura das funções em Kotlin:
        // fun nome(parametro: tipo): tipoParâmetro {}
    
    fun somar(a: Int, b: Int): Int {
        return a + b;
    }
    println("Soma de 1 e 2 é: " + somar(1, 2));
    
    // Simplificando a função:
    fun subtrair(a: Int, b: Int): Int = a - b;
}

// Classes em Kotlin são duas formas:

// Parecido com JS:
class PessoaKotlin(nome: String, idade: Int) {
    var nome: String = nome
        private set;
    var idade: Int = idade
        private set;
    fun saudar() {
        println("Olá sou $nome, tenho $idade anos");
    }
}
// Ou como em Java:
open class PessoaJava {
    val nome: String;
    var idade: Int;

    constructor(nome: String, idade: Int) {
        this.nome = nome;
        this.idade = idade;
    }
}

// Herança:
    // Toda classe Kotlin é final por nascimento;
    // Na classe pai temos que colocar a palavra open antes de class.
    
// Para herdas basta por : e na frente a classe a ser herdada
class PessoaJavaScript : PessoaJava {
    val isBom: Boolean;
    
    // o super vai na chamada
    constructor(nome: String, idade: Int, isBom: Boolean) : super(nome, idade) {
        this.isBom = isBom;
    }
}

// Interface:
    // usamos a palavra public inteface para criar uma interface;
    // para implementar ela basta colocar : igual na herança;

public interface Animal {
    fun emitirSom();
}
// Ao invés na notação @override usamos apenas override para sobreescrever.
class Cachorro : Animal {
    override fun emitirSom() {
        println("AUUUUUUUUUUUUUUUUUUUUUU");
    }
}
class Gato : Animal {
    override fun emitirSom() {
        println("MIAAAAAAAAAAAAAAAAAAAAU");
    }
}

// Collections: para lista mutável usamos mutableListOf();
// Lambda: depois da chamada ao método basta colocar { p => p }
    // Parecido com JS

// Diferente do Java, compilador do Kotlin cria: equals, hashCode, toString, copy

// Kotlin tem enum igual no Java

// Tratamento de exceções é igual mas vale atentar que no catch fazemos:
    // catch (e: Exception)
    
// Visibilidades de Kotlin: public, private, protected e internal
    // toda classe é public por padrão, não precisa declarar;
    
// Package e Import são iguais ao Java

// Existe this no Kotlin mas quase não se usa...

// Kotlin não possui static... Não da mesma forma do Java:
    // dentro de uma classe estatica criamos uma companion object
    
class Calculadora {
    companion object {
        fun somar(a: Int, b: Int) = a + b;
        fun subtrair(a: Int, b: Int) = a - b;
    }
}

// No Kotlin tem daqueles objetos de JS que só tem uma instancia:
object ObjetoJS {
    val nome: String = "Sou Feio";
} 