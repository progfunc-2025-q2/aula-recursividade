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
└── RecursiveTailCall.scala      # Exemplos abrangentes de recursão
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
   
   # Conversão de loop
   sbt "runMain runDeclarativeSum"
   
   # Exemplos abrangentes
   sbt "runMain RecursiveTailCall.run"
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

## 🛠️ Ambiente de Desenvolvimento

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