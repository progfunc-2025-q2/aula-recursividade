# Recursividade em Scala

Este projeto demonstra conceitos fundamentais de recursão em Scala, incluindo recursão de cauda (tail recursion), stack overflow, e conversão de loops para recursão.

## 📚 Conceitos Abordados

- **Recursão Regular vs. Recursão de Cauda**
- **Otimização de Tail Call**
- **Stack Overflow e suas causas**
- **Conversão de loops imperativos para recursão funcional**
- **Anotação `@tailrec` do Scala**

## 🗂️ Estrutura do Projeto

```
src/main/scala/
├── RecursiveSum.scala           # Recursão regular (não-otimizada)
├── TailRecursiveSum.scala       # Recursão de cauda (otimizada)
├── LoopConversion.scala         # Conversão de loop para recursão
├── TailCall.scala               # Exemplos de tail calls vs non-tail calls
├── RecursiveStackOverflow.scala # Demonstração de stack overflow
├── RecursiveTailCall.scala      # Exemplos abrangentes de recursão
├── FibonacciRecursive.scala     # Fibonacci naive (exponencial)
├── FibonacciMemoized.scala      # Fibonacci com memoização (otimizado)
├── FibonacciTailRecursive.scala # Fibonacci tail-recursive (funcional)
├── FibonacciIterative.scala     # Fibonacci iterativo (imperativo)
├── FibonacciPerformance.scala   # Comparação de performance Fibonacci
└── Factorial.scala              # Factorial: 4 implementações comparadas
```

## 📝 Descrição dos Arquivos

### 1. RecursiveSum.scala
Implementa soma recursiva usando **recursão regular** (não-otimizada):
- Demonstra como a recursão tradicional funciona
- Mostra limitações para entradas grandes (stack overflow)
- Exemplo de função que **NÃO** é tail-recursive

### 2. TailRecursiveSum.scala
Implementa a mesma soma usando **recursão de cauda**:
- Usa a anotação `@tailrec` para garantir otimização
- Emprega padrão de acumulador
- Funciona eficientemente com entradas grandes (sem stack overflow)

### 3. LoopConversion.scala
Demonstra como converter loops imperativos para recursão funcional:
- Padrão de função auxiliar (helper function)
- Simula comportamento de loop através de recursão de cauda
- Separação clara entre lógica principal e mecânica de iteração

### 4. TailCall.scala
Exemplos didáticos de tail calls vs non-tail calls:
- Funções com tail calls (última operação é a chamada)
- Funções com non-tail calls (operações após a chamada)
- Casos mistos com ambos os tipos

### 5. RecursiveStackOverflow.scala
Demonstração prática de stack overflow:
- Executa função recursiva regular com entrada grande
- Captura e trata `StackOverflowError`
- Mostra a importância da recursão de cauda

### 6. RecursiveTailCall.scala
Coleção abrangente de exemplos:
- Fibonacci (regular vs tail-recursive)
- Exponenciação (regular vs tail-recursive)
- Funções com múltiplos casos recursivos
- Comparação de eficiência entre abordagens

### 7. FibonacciRecursive.scala
Implementação naive da sequência de Fibonacci:
- Demonstra recursão com complexidade exponencial O(2^n)
- Exemplo clássico de ineficiência em recursão
- Mostra o problema de subproblemas sobrepostos
- Comparação de performance para diferentes entradas

### 8. FibonacciMemoized.scala
Fibonacci otimizado com memoização:
- Técnica de cache para evitar recálculos
- Transforma O(2^n) em O(n) usando memoização
- Demonstra funções de alta ordem e closures
- Exemplo de otimização sem alterar estrutura recursiva

### 9. FibonacciTailRecursive.scala
Fibonacci implementado com recursão de cauda:
- Demonstra conversão de loop iterativo para recursão funcional
- Usa padrão de função auxiliar com acumuladores
- Eficiência O(n) com segurança de pilha (stack-safe)
- Comparação direta com abordagem iterativa

### 10. FibonacciIterative.scala
Fibonacci implementado com abordagem iterativa tradicional:
- Loop while com variáveis mutáveis (estilo imperativo)
- Eficiência máxima: O(n) tempo, O(1) espaço
- Baseline para comparação com abordagens funcionais
- Familiar para programadores de linguagens imperativas

### 11. FibonacciPerformance.scala
Análise empírica de performance entre todas as implementações:
- Medição de tempo de execução real
- Demonstração prática de complexidade algorítmica
- Comparação entre O(2^n) vs O(n) na prática
- Framework de timing usando funções de alta ordem
- Insights educacionais sobre escolhas algorítmicas

### 12. Factorial.scala
Comparação completa de implementações de factorial:
- **Naive**: Recursão simples (não tail-recursive)
- **Tail Recursive**: Versão otimizada com acumulador
- **Imperative**: Loop tradicional com estado mutável
- **Functional Conversion**: Conversão de loop para recursão
- Análise de complexidade e trade-offs entre abordagens

## 🚀 Como Executar

### Pré-requisitos
- Scala 3.7.1 ou superior
- SBT (Scala Build Tool)

### 🐳 Execução em Devcontainer/Codespaces

Este projeto está configurado para funcionar em **GitHub Codespaces** e **VS Code Dev Containers**:

#### GitHub Codespaces
1. Abra o repositório no GitHub
2. Clique em **"Code"** → **"Codespaces"** → **"Create codespace on main"**
3. Aguarde o ambiente ser configurado automaticamente
4. O Scala e SBT já estarão instalados e prontos para uso

#### VS Code Dev Container
1. Instale a extensão **"Dev Containers"** no VS Code
2. Abra o projeto no VS Code
3. Pressione `Ctrl+Shift+P` e execute **"Dev Containers: Reopen in Container"**
4. O ambiente será configurado automaticamente com todas as dependências

#### Vantagens do Ambiente Containerizado
- ✅ **Configuração automática** do Scala e SBT
- ✅ **Ambiente consistente** entre diferentes máquinas
- ✅ **Extensões do VS Code** pré-configuradas para Scala
- ✅ **Sem necessidade de instalação local** de ferramentas
- ✅ **Metals (Scala Language Server)** já configurado

### 💻 Execução Local

Se preferir executar localmente, instale:
- Scala 3.7.1 ou superior
- SBT (Scala Build Tool)

### Comandos

1. **Compilar o projeto:**
   ```bash
   sbt compile
   ```

2. **Executar exemplos específicos:**
   ```bash
   # Recursão regular (pode gerar stack overflow)
   sbt "runMain recursivesum.run"
   
   # Recursão de cauda (sem stack overflow)
   sbt "runMain tailrecursivesum.run"
   
   # Demonstração de stack overflow
   sbt "runMain recursivestackoverflow.run"
   
   # Conversão de loop para recursão
   sbt "runMain runDeclarativeSum"
   
   # Exemplos abrangentes de recursão
   sbt "runMain RecursiveTailCall.run"
   
   # Fibonacci naive (atenção: lento para números grandes)
   sbt "runMain fibonacciNaive.runFibonacciNaive"
   
   # Fibonacci com memoização (rápido mesmo para números grandes)
   sbt "runMain fibonacciMemoized.runFibonacciMemoized"
   
   # Fibonacci tail-recursive (funcional e eficiente)
   sbt "runMain talRecursiveFibonacci.runFibonacciTailRecursive"
   
   # Fibonacci iterativo (imperativo tradicional)
   sbt "runMain iterativeFibonacci.runFibonacciIterative"
   
   # Comparação de performance entre todas as implementações Fibonacci
   sbt "runMain fibonacciPerformance.runPerformanceComparison"
   
   # Factorial: comparação de 4 implementações
   sbt "runMain run"
   
   # Factorial: apenas conversão funcional
   sbt "runMain runFactorialFromImperative"
   ```

3. **Executar todos os testes:**
   ```bash
   sbt test
   ```

## 🎯 Objetivos de Aprendizagem

Após estudar este projeto, você deve compreender:

1. **Diferença entre recursão regular e recursão de cauda**
2. **Por que recursão de cauda é mais eficiente**
3. **Como usar a anotação `@tailrec` corretamente**
4. **Padrão de acumulador em funções recursivas**
5. **Quando e por que ocorre stack overflow**
6. **Como converter loops imperativos para recursão funcional**
7. **Técnicas de memoização para otimizar recursão**
8. **Análise de complexidade algorítmica (O(n) vs O(2^n))**
9. **Funções de alta ordem e closures**
10. **Trade-offs entre diferentes paradigmas de programação**
11. **Análise empírica de performance algorítmica**
12. **Medição de tempo de execução e profiling**
13. **Comparação prática entre abordagens funcionais e imperativas**
14. **Quando usar cada técnica de otimização**

## � Conceitos Importantes

### Recursão de Cauda (Tail Recursion)
Uma função é tail-recursive quando a chamada recursiva é a **última operação** executada antes do retorno. Isso permite ao compilador otimizar a recursão em um loop, evitando o crescimento da pilha de chamadas.

### Memoização
Técnica de otimização que armazena resultados de computações caras em cache para evitar recálculos. Especialmente útil para funções recursivas com subproblemas sobrepostos, como Fibonacci.

### Complexidade Algorítmica
- **O(n)**: Complexidade linear - tempo cresce proporcionalmente ao input
- **O(2^n)**: Complexidade exponencial - tempo dobra a cada incremento do input
- **O(1)**: Complexidade constante - tempo independe do tamanho do input

### Anotação @tailrec
```scala
@tailrec
def exemplo(n: Int, acc: Int = 0): Int = {
    if (n <= 0) acc
    else exemplo(n - 1, acc + n)  // Última operação = tail call
}
```

### Padrão de Acumulador
Técnica comum em recursão de cauda onde mantemos o resultado parcial em um parâmetro adicional (acumulador), evitando operações após a chamada recursiva.

### Funções de Alta Ordem
Funções que recebem outras funções como parâmetros ou retornam funções. Exemplo: a função `memoize` que transforma qualquer função em sua versão memoizada.

### Análise de Performance
O projeto inclui ferramentas para medir empiricamente o desempenho dos algoritmos:

```scala
def time[T](operation: => T): (T, Long) = {
    val start = System.nanoTime()
    val result = operation
    val end = System.nanoTime()
    (result, end - start)
}
```

### Comparação Fibonacci
O projeto demonstra quatro abordagens diferentes para Fibonacci:

1. **Naive O(2^n)**: Torna-se impraticável por volta de F(40)
2. **Memoized O(n)**: Transforma algoritmo ruim em bom
3. **Tail Recursive O(n)**: Estilo funcional com performance imperativa
4. **Iterative O(n)**: Abordagem tradicional, ainda muito eficiente

### Insights Educacionais
- Algoritmos exponenciais tornam-se impraticáveis rapidamente
- Memoização pode transformar algoritmos ruins em bons
- Recursão de cauda atinge performance de nível imperativo
- Todos os métodos otimizados produzem resultados idênticos
- A escolha depende da preferência de estilo, não da performance

## �🛠️ Ambiente de Desenvolvimento

### Configuração Recomendada

#### GitHub Codespaces (Recomendado para Iniciantes)
- **Vantagem**: Ambiente pronto em segundos, sem instalação
- **Acesso**: Qualquer navegador, tablet ou VS Code
- **Recursos**: 60 horas gratuitas por mês para estudantes

#### VS Code Dev Container
- **Vantagem**: Desenvolvimento local com ambiente isolado
- **Requisitos**: Docker instalado + VS Code + extensão Dev Containers
- **Ideal para**: Desenvolvimento offline ou recursos limitados de rede

#### Configuração Manual
- **Para usuários avançados** que preferem configurar o ambiente localmente
- **Requisitos**: Scala, SBT, Java JDK, Metals (Language Server)

### Extensões do VS Code Incluídas

O ambiente containerizado inclui:
- **Scala (Metals)**: Language server para Scala
- **Scala Syntax**: Destacamento de sintaxe
- **SBT**: Integração com Scala Build Tool

---

**Curso:** MCCC015-23 - Programação Funcional  
**Professor:** Diogo Santana Martins
**Tópico:** Recursividade e Otimização de Tail Call  
**Ano:** 2025