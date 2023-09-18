# Calculadora RMI

## Objetivo
Desenvolver um ' hello world' usando java RMI (Remote Method Invocation),

## Descrição
Esse programa é bem simples apenas uma calculadora que soma, subtrai e calcula fatoriais contudo
a foma de invocação do método é remota isto é, não é o mesmo programa java ( mesma jvm), o programa cliente está usando
o objeto que se encontra no programa servidor.

## Desenvolvimento
![Imagem de carregamento](misc/Desenvolvimento.drawio.png)
Nosso objetivo é transformar esse diagrama em código, mão na massa.

Dentro da pasta src ficou as seguintes classes:

 - [Cliente.java](#clientejava)
 - [Servidor.java](#servidorjava)
 - [Calculadora.java](#calculadorajava)
 - [CalculadoraImpl.java](#calculadoraimpljava)

Usando a seguinte hierarquia de modulos:

```yml
    src:
      java:
        - Cliente.java
        - Servidor.java
        - rmi:
          objects:
            - Calculadora.java
            - impl:
              - CalculadoraImpl.java
```
### Calculadora.java
Devemos criar uma interface para poder definir o comportamento nos dois lados da aplicação (cliente e servidor) mesmo que a implementação será somente pelo lado do servidor.

Um ponto importante a ser levantado é que todo objeto que deve ser exposto para a referencia remota deve sempre extender de _java.rmi.Remote_ e seus metodos devem lançar uma exceção _java.rmi.RemoteException_ do demais a implementação é normal a de qualquer outra interface usando java.

```java
public interface Calculadora extends Remote throws RemoteException {
  int soma(int x, int y) throws RemoteException;
  int subtracao(int x, int y) throws RemoteException;
  BigInteger fatorial(int num) throws RemoteException;
}
```

tendo a interface nos basta agora a implementação dela.
### CalculadoraImpl.java
Será a implementação da nossa classe calculadora isto é, todos os metodos descritos na interface Calculadora deverá ser realmente implementados aqui.

A implementação é como qualquer outra implementação de interfaces java, o que altera aqui é que ela deve extender de java.rmi.server.UnicastRemoteObject() e deve conter um construtor que inicialize o super()

```java
public class CalculadoraImpl extends UnicastRemoteOlbject implements Calculadora throws RemoteException {

public CalculadoraImpl(){
  super()
}

public int soma(int x, int y) throws RemoteException {
// implementacao
}

public int subtracao (int x, int y) throws RemoteException {
  // implementacao
}

public int fatorial (int num) throws RemoteException {
  //implementação
}
```


### Servidor.java
O intuito do servidor é apenas expor um objeto contido nele, nessa aplicação será uma implementação da classe Calculadora
(CalculadoraImpl), logo apos usamos um metodo do RMI para associar esse objeto a um nome no Registry da ferramenta,
o Registry nada mais é que um repositório de referências, que guarda valores no modo 
nome -> object
```json
{
  nome: {}
}
```
Assim quando uma consulta é feita por um objeto na rede, ele guarda a referência de onde está esse objeto.
Uma coisa importante é criar um registry para armazenar essas informações basta passar a porta que quer associar no contrutor ou passar _null_ para associar a porta padrão 1099

```java
Registry registry = LocateRegistry.createRegistry(8080)
// ou
Registry registry = LocateRegistry.createRegistry(null)
```

```java
  Calculadora calculadora = new CalculadoraImpl();
  Naming.rebind("rmi://localhost:8080/calc", calculadora);
```

O código completo do servidor se resume a:

```java
public static void main(String[] args) {
        try {
            Calculadora calculadora = new CalculadoraImpl();

            //criando um registry na porta especificada
            Registry registry = LocateRegistry.createRegistry(8080);
            //Associando o objeto a um nome no registry local
            Naming.rebind("rmi://localhost:8080/calc", calculadora);

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
```
### Cliente.java
A idéia da classe cliete é simplesmente invocar um método de um objeto que não está instanciado na própria VM nesse caso será um objeto do tipo Calculadora.

```java
  Calculadora calculadora = (Calculadora) Naming.lookout("rmi://localhost:8080/calc");
```

Tendo isso basta um código que invoque algum metodo do objeto calculadora, apresentarei um que apenas calcula o fatorial de um dado numero, repetindo infinitas veses.
```java
Scanner scanner = new Scanner(System.in);
int num;
while ( true ){
  num = scanner.nextInt();
  System.out.format(
    "o fatorial de %d é: %d\n", num, calculadora.fatorial( num )
  )
}
```




