# 🟣 Nivelamento Kotlin

Repositório criado para registrar meu **nivelamento em Kotlin**, utilizando meu conhecimento prévio em **Java e JavaScript** como base para compreender a sintaxe e os principais conceitos da linguagem.

O objetivo não é apenas aprender uma nova sintaxe, mas entender:

> **Como os conceitos que já conheço em Java são escritos e aplicados em Kotlin?**

Kotlin é uma linguagem estaticamente tipada desenvolvida pela JetBrains, com forte integração com a JVM e interoperabilidade com Java.

---

## 📚 O que este repositório aborda

* Variáveis com `val` e `var`
* Tipos básicos
* Strings e String Templates
* Estruturas condicionais
* `if` como expressão
* Operadores
* `when`
* Loops
* Funções
* Funções simplificadas
* Classes
* Construtores
* Propriedades
* Getters e Setters
* Encapsulamento
* Herança
* Interfaces
* `override`
* Collections
* Lambdas
* `data class`
* Enums
* Tratamento de exceções
* Modificadores de acesso
* Packages e Imports
* `this`
* `companion object`
* `object`
* Relação entre Kotlin, Java e JavaScript

---

# ☕ Kotlin para quem já conhece Java

A melhor maneira de estudar Kotlin vindo do Java é **não tentar reaprender programação do zero**.

A lógica continua praticamente a mesma.

O que muda principalmente é a forma de escrever.

| Java                     | Kotlin                                  |
| ------------------------ | --------------------------------------- |
| `String nome = "Pedro";` | `val nome: String = "Pedro"`            |
| `int idade = 23;`        | `var idade: Int = 23`                   |
| `System.out.println()`   | `println()`                             |
| `final`                  | `val`                                   |
| `switch`                 | `when`                                  |
| método                   | `fun`                                   |
| `extends`                | `:`                                     |
| `implements`             | `:`                                     |
| getters/setters          | propriedades                            |
| `static`                 | `companion object` / `object`           |
| `equals()`               | `==`                                    |
| `instanceof`             | `is`                                    |
| `ArrayList`              | `mutableListOf()`                       |
| Streams                  | funções como `map`, `filter`, `forEach` |

A ideia é:

**Java → mesma lógica, mais código**

**Kotlin → mesma lógica, sintaxe mais enxuta e expressiva**

---

# 1. Variáveis

Kotlin possui duas formas principais de declarar variáveis:

```kotlin
val nome = "Pedro"
var idade = 23
```

### `val`

`val` representa uma referência que **não pode ser reatribuída**.

```kotlin
val nome = "Pedro"

nome = "João" // ERRO
```

É semelhante à ideia de:

```java
final String nome = "Pedro";
```

### `var`

`var` permite reatribuição:

```kotlin
var idade = 23

idade = 24
```

### Regra recomendada

Prefira:

```kotlin
val
```

e utilize:

```kotlin
var
```

quando realmente precisar alterar a variável.

---

# 2. Inferência de tipos

Kotlin consegue descobrir automaticamente o tipo:

```kotlin
val nome = "Pedro"
val idade = 23
val altura = 1.75
val vivo = true
```

Não é necessário escrever:

```kotlin
val nome: String = "Pedro"
val idade: Int = 23
```

Mas também é possível declarar explicitamente:

```kotlin
val nome: String = "Pedro"
```

### Comparação com Java

Java:

```java
String nome = "Pedro";
int idade = 23;
```

Kotlin:

```kotlin
val nome: String = "Pedro"
val idade: Int = 23
```

Ou simplesmente:

```kotlin
val nome = "Pedro"
val idade = 23
```

---

# 3. Tipos básicos

Alguns dos principais tipos:

```kotlin
String
Int
Double
Float
Long
Boolean
Char
```

Exemplo:

```kotlin
val nome: String = "Pedro"
val idade: Int = 23
val altura: Double = 1.75
val peso: Double = 67.0
val vivo: Boolean = true
val sexo: Char = 'M'
```

### Atenção

`String` utiliza:

```kotlin
"Pedro"
```

Enquanto `Char` utiliza:

```kotlin
'P'
```

---

# 4. Strings e String Templates

Kotlin possui uma forma muito prática de inserir variáveis dentro de Strings.

```kotlin
val nome = "Pedro"
val idade = 23

println("Meu nome é $nome e tenho $idade anos")
```

Também podemos utilizar expressões:

```kotlin
println("Daqui a 5 anos terei ${idade + 5} anos")
```

A sintaxe:

```kotlin
$variavel
```

é usada para variáveis.

A sintaxe:

```kotlin
${expressao}
```

é utilizada quando precisamos executar uma expressão dentro da String.

---

# 5. `if` e `else`

A estrutura é muito parecida com Java:

```kotlin
if (idade >= 18) {
    println("Maior de idade")
} else {
    println("Menor de idade")
}
```

Também existe `else if`:

```kotlin
if (idade >= 18) {
    println("Maior de idade")
} else if (idade >= 14) {
    println("Adolescente")
} else {
    println("Criança")
}
```

---

# 6. `if` como expressão

Uma diferença muito interessante em relação ao Java é que `if` pode produzir um valor.

```kotlin
val situacao = if (idade >= 18) {
    "Maior de idade"
} else {
    "Menor de idade"
}
```

A variável `situacao` recebe o resultado do `if`.

Isso permite escrever código mais próximo de uma expressão:

```kotlin
val maior = if (idade >= 18) "Sim" else "Não"
```

---

# 7. Operadores

Os operadores básicos são praticamente os mesmos do Java.

### Aritméticos

```text
+
-
*
/
%
```

### Comparação

```text
>
<
>=
<=
==
!=
```

### Lógicos

```text
&&
||
!
```

Uma diferença importante:

```kotlin
a == b
```

em Kotlin representa igualdade estrutural.

Para comparação de referência existe:

```kotlin
a === b
```

---

# 8. `when` — o "Switch Case" do Kotlin

Kotlin não utiliza `switch`.

O equivalente é:

```kotlin
when (opcao) {
    1 -> println("Um")
    2 -> println("Dois")
    3 -> println("Três")
    else -> println("Inválido")
}
```

Além disso, `when` também pode retornar um valor:

```kotlin
val resultado = when (opcao) {
    1 -> "Um"
    2 -> "Dois"
    3 -> "Três"
    else -> "Inválido"
}
```

### Comparação

Java:

```java
switch (opcao) {
    case 1:
        System.out.println("Um");
        break;
    case 2:
        System.out.println("Dois");
        break;
    default:
        System.out.println("Inválido");
}
```

Kotlin:

```kotlin
when (opcao) {
    1 -> println("Um")
    2 -> println("Dois")
    else -> println("Inválido")
}
```

---

# 9. Loops

## `for`

Kotlin utiliza:

```kotlin
for (nome in nomes) {
    println(nome)
}
```

Para intervalos:

```kotlin
for (i in 0 until 10) {
    println(i)
}
```

Isso equivale aproximadamente a:

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

### `..`

```kotlin
for (i in 0..10) {
    println(i)
}
```

Inclui o `10`.

Resultado:

```text
0 1 2 3 4 5 6 7 8 9 10
```

### `until`

```kotlin
0 until 10
```

Não inclui o `10`.

Resultado:

```text
0 1 2 3 4 5 6 7 8 9
```

### `downTo`

Permite fazer a contagem regressiva:

```kotlin
for (i in 10 downTo 0) {
    println(i)
}
```

### `step`

Permite definir o intervalo:

```kotlin
for (i in 0..10 step 2) {
    println(i)
}
```

Resultado:

```text
0 2 4 6 8 10
```

---

# 10. `while` e `do while`

São praticamente iguais ao Java.

```kotlin
while (contador < 10) {
    contador++
}
```

E:

```kotlin
do {
    contador++
} while (contador < 10)
```

---

# 11. Funções

Em Kotlin utilizamos `fun`.

```kotlin
fun somar(a: Int, b: Int): Int {
    return a + b
}
```

Estrutura:

```text
fun nome(parametros): tipoDeRetorno
```

Chamando:

```kotlin
println(somar(10, 20))
```

### Função simplificada

Quando a função possui apenas uma expressão:

```kotlin
fun somar(a: Int, b: Int): Int = a + b
```

E podemos deixar o compilador inferir o retorno:

```kotlin
fun somar(a: Int, b: Int) = a + b
```

---

# 12. Classes

Uma classe Kotlin pode ser extremamente compacta.

```kotlin
class Pessoa(
    val nome: String,
    val idade: Int
)
```

Isso já cria uma classe com propriedades e construtor.

Podemos adicionar métodos:

```kotlin
class Pessoa(
    val nome: String,
    val idade: Int
) {
    fun saudar() {
        println("Olá, sou $nome e tenho $idade anos")
    }
}
```

---

# 13. Propriedades

Kotlin trabalha muito com **propriedades**, em vez da quantidade de getters e setters explícitos comum no Java.

```kotlin
class Pessoa(
    var nome: String,
    var idade: Int
)
```

Podemos acessar:

```kotlin
val pessoa = Pessoa("Pedro", 23)

println(pessoa.nome)

pessoa.nome = "João"
```

Por baixo dos panos, a JVM pode utilizar getters e setters, mas a linguagem permite trabalhar diretamente com a propriedade.

---

# 14. Setter privado

Podemos permitir que uma propriedade seja lida externamente, mas modificada apenas pela própria classe.

```kotlin
class Pessoa(nome: String) {

    var nome: String = nome
        private set
}
```

Agora:

```kotlin
println(pessoa.nome)
```

é permitido.

Mas:

```kotlin
pessoa.nome = "João"
```

fora da classe não é permitido.

Isso é muito útil para **encapsulamento**.

---

# 15. Construtores

O construtor primário fica diretamente na declaração:

```kotlin
class Pessoa(
    val nome: String,
    val idade: Int
)
```

Também podemos utilizar um construtor secundário:

```kotlin
class Pessoa {

    val nome: String
    val idade: Int

    constructor(nome: String, idade: Int) {
        this.nome = nome
        this.idade = idade
    }
}
```

O primeiro formato é o mais idiomático em Kotlin.

---

# 16. Herança

Por padrão:

> **Classes Kotlin são `final`.**

Ou seja, não podem ser herdadas.

Para permitir herança:

```kotlin
open class Pessoa(
    val nome: String
)
```

Agora podemos criar:

```kotlin
class Aluno(
    nome: String,
    val curso: String
) : Pessoa(nome)
```

### Comparação com Java

Java:

```java
class Aluno extends Pessoa {
}
```

Kotlin:

```kotlin
class Aluno : Pessoa()
```

---

# 17. `super`

Quando precisamos chamar o construtor da classe pai:

```kotlin
class Pessoa(
    val nome: String,
    val idade: Int
)

class Aluno(
    nome: String,
    idade: Int,
    val curso: String
) : Pessoa(nome, idade)
```

A chamada da classe pai ocorre diretamente depois dos dois-pontos:

```kotlin
: Pessoa(nome, idade)
```

---

# 18. Interfaces

Interfaces são muito parecidas com Java.

```kotlin
interface Animal {
    fun emitirSom()
}
```

Implementação:

```kotlin
class Cachorro : Animal {

    override fun emitirSom() {
        println("Au au")
    }
}
```

Outro exemplo:

```kotlin
class Gato : Animal {

    override fun emitirSom() {
        println("Miau")
    }
}
```

A palavra:

```kotlin
override
```

é usada diretamente, sem `@`.

---

# 19. Collections

Kotlin possui funções próprias para criação de collections.

Lista somente leitura:

```kotlin
val nomes = listOf(
    "Eduardo",
    "Erik",
    "Lucas",
    "Pedro",
    "Rubio"
)
```

Lista mutável:

```kotlin
val nomes = mutableListOf(
    "Eduardo",
    "Erik",
    "Lucas"
)
```

Podemos modificar:

```kotlin
nomes.add("Pedro")
```

### Comparação

Java:

```java
List<String> nomes = new ArrayList<>();
nomes.add("Pedro");
```

Kotlin:

```kotlin
val nomes = mutableListOf("Pedro")
```

---

# 20. Lambdas

Kotlin possui suporte forte a programação funcional.

Exemplo:

```kotlin
nomes.forEach { nome ->
    println(nome)
}
```

Podemos utilizar `it` quando existe apenas um parâmetro:

```kotlin
nomes.forEach {
    println(it)
}
```

A estrutura geral é:

```kotlin
{ parametro -> expressão }
```

---

# 21. `map`

Transforma cada elemento de uma collection.

```kotlin
val numeros = listOf(1, 2, 3, 4)

val dobrados = numeros.map {
    it * 2
}
```

Resultado:

```text
[2, 4, 6, 8]
```

---

# 22. `filter`

Filtra elementos:

```kotlin
val numeros = listOf(1, 2, 3, 4, 5, 6)

val pares = numeros.filter {
    it % 2 == 0
}
```

Resultado:

```text
[2, 4, 6]
```

Essa abordagem lembra bastante a Stream API do Java.

Java:

```java
numeros.stream()
    .filter(n -> n % 2 == 0)
    .toList();
```

Kotlin:

```kotlin
numeros.filter {
    it % 2 == 0
}
```

---

# 23. `data class`

Uma `data class` é usada principalmente para representar dados.

```kotlin
data class Pessoa(
    val nome: String,
    val idade: Int
)
```

O compilador gera automaticamente funcionalidades como:

* `equals()`
* `hashCode()`
* `toString()`
* `copy()`

Por exemplo:

```kotlin
val pessoa1 = Pessoa("Pedro", 23)

val pessoa2 = pessoa1.copy(
    idade = 24
)
```

### ⚠️ Importante

Esses métodos não são gerados automaticamente para **qualquer classe Kotlin**.

Esse comportamento especial está relacionado principalmente às `data class`.

---

# 24. Enum

Kotlin possui enums de maneira muito semelhante ao Java:

```kotlin
enum class Dia {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA
}
```

Uso:

```kotlin
val dia = Dia.SEGUNDA
```

Também pode ser combinado com `when`:

```kotlin
when (dia) {
    Dia.SEGUNDA -> println("Começo da semana")
    Dia.SEXTA -> println("Sextou")
    else -> println("Outro dia")
}
```

---

# 25. Tratamento de exceções

A estrutura é semelhante ao Java:

```kotlin
try {
    // código
} catch (e: Exception) {
    println(e.message)
} finally {
    // código
}
```

Uma diferença importante:

> Kotlin não possui checked exceptions como Java.

Não existe a mesma obrigação de declarar:

```java
throws IOException
```

---

# 26. Modificadores de acesso

Kotlin possui:

```text
public
private
protected
internal
```

`public` é o padrão.

Portanto:

```kotlin
class Pessoa
```

já é pública.

Não é necessário escrever:

```kotlin
public class Pessoa
```

---

# 27. Packages e Imports

A sintaxe é praticamente igual ao Java.

```kotlin
package br.com.pedro.projeto
```

Import:

```kotlin
import java.util.Scanner
```

---

# 28. `this`

Kotlin possui `this`:

```kotlin
this.nome
```

Mas devido à sintaxe mais enxuta da linguagem, muitas vezes ele não é necessário.

Por exemplo:

```kotlin
class Pessoa(
    val nome: String
)
```

já resolve o problema que normalmente exigiria:

```java
this.nome = nome;
```

no Java.

---

# 29. `static` e `companion object`

Kotlin não possui `static` da mesma maneira que Java.

Quando queremos algo associado à classe, podemos utilizar:

```kotlin
class Calculadora {

    companion object {

        fun somar(a: Int, b: Int) = a + b

        fun subtrair(a: Int, b: Int) = a - b
    }
}
```

Uso:

```kotlin
Calculadora.somar(10, 20)
```

### Pensamento Java

Isso lembra:

```java
Calculadora.somar(10, 20);
```

com um método `static`.

O `companion object` é uma das ferramentas utilizadas para representar esse tipo de comportamento no Kotlin/JVM.

---

# 30. `object`

Kotlin também possui `object`.

```kotlin
object Configuracao {
    val nome = "Sistema"
}
```

Esse objeto possui uma única instância.

Podemos acessar diretamente:

```kotlin
println(Configuracao.nome)
```

É um conceito semelhante ao padrão Singleton, mas fornecido diretamente pela linguagem.

---

# 31. Null Safety

Um dos recursos mais importantes do Kotlin.

No Java:

```java
String nome = null;
```

é permitido.

Em Kotlin:

```kotlin
var nome: String = null
```

não é permitido.

Se quisermos permitir `null`:

```kotlin
var nome: String? = null
```

O `?` indica que o valor pode ser nulo.

### Safe Call

```kotlin
println(nome?.length)
```

Se `nome` for `null`, a operação não causa `NullPointerException`.

### Elvis Operator

```kotlin
val tamanho = nome?.length ?: 0
```

Significa:

```text
Se nome não for null:
    retorna nome.length

Caso contrário:
    retorna 0
```

Esse é um dos conceitos que merecem atenção especial ao avançar nos estudos de Kotlin.

---

# 🧠 O que este nivelamento me ensinou

O principal aprendizado deste estudo foi perceber que **Kotlin não muda a lógica de programação que já conheço do Java**.

A maior mudança está na forma de expressar essa lógica.

Por exemplo:

### Java

```java
String nome = "Pedro";

if (nome != null) {
    System.out.println(nome.length());
}
```

### Kotlin

```kotlin
val nome = "Pedro"

println(nome?.length)
```

Outro exemplo:

### Java

```java
List<Integer> pares = numeros.stream()
        .filter(n -> n % 2 == 0)
        .toList();
```

### Kotlin

```kotlin
val pares = numeros.filter {
    it % 2 == 0
}
```

A lógica continua sendo:

```text
receber dados
↓
processar
↓
filtrar
↓
transformar
↓
retornar resultado
```

Kotlin apenas permite expressar isso de maneira mais compacta.

---

# ☕ Java → Kotlin: o que já domino

Como já possuo conhecimento de Java, os seguintes conceitos não precisam ser reaprendidos do zero:

* Variáveis
* Tipos
* Operadores
* Condicionais
* Loops
* Funções
* Classes
* Objetos
* Encapsulamento
* Herança
* Polimorfismo
* Interfaces
* Abstração
* Collections
* Enums
* Exceções
* Packages
* Imports

O foco deve ser aprender **como Kotlin implementa esses conceitos**.

---

# 🎯 Próximos conceitos para aprofundar

Depois deste nivelamento, os próximos assuntos importantes para dominar Kotlin são:

1. **Null Safety**
2. **Collections**
3. **Lambdas**
4. **Higher-Order Functions**
5. **Extension Functions**
6. **Scope Functions**

   * `let`
   * `run`
   * `with`
   * `apply`
   * `also`
7. **Data Classes**
8. **Sealed Classes**
9. **Generics**
10. **Delegation**
11. **Coroutines**
12. **Java Interoperability**
13. **Kotlin + Gradle**
14. **Kotlin para Back-End**

---

# 🚀 Objetivo do estudo

Este repositório representa meu primeiro nivelamento em Kotlin, utilizando **Java como principal referência para entender a linguagem**.

A ideia é evoluir da sintaxe básica para o desenvolvimento de aplicações reais na JVM, aproveitando os conhecimentos já adquiridos em Java e explorando os recursos que tornam Kotlin uma linguagem mais concisa, segura e expressiva.

> **Java me ensinou a lógica. Kotlin está me ensinando novas formas de expressá-la.**

---

## 👨‍💻 Autor

**Pedro Augusto**

Estudante e desenvolvedor com foco em **Back-End**, atualmente aprofundando conhecimentos em:

* Java
* Kotlin
* JavaScript
* Node.js
* TypeScript
* C
* Python
* Bancos de dados
* Hibernate / JPA

---
