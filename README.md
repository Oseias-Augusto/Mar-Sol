# 🚕 Rádio Táxi Mar & Sol

Projeto desenvolvido em Java com o objetivo de simular o funcionamento de uma central de rádio táxi, aplicando conceitos de **orientação a objetos**, **arquitetura em camadas** e princípios do **SOLID**.

---

## Funcionalidades

* Cadastro de **Clientes**

  * Simples (apenas nome)
  * Completo (endereço + telefones)

* Cadastro de **Cooperadores (taxistas)**

  * Dados pessoais (CPF, CNH, categoria)
  * Veículo
  * Endereço e telefones

* Controle de **Corridas**

  * Solicitação de corrida
  * Atribuição de VR (taxista)
  * Aviso ao cliente
  * Início da corrida
  * Cancelamentos

* Controle de **Logradouros válidos**

  * Apenas corridas em logradouros cadastrados são permitidas

---

## Arquitetura

O projeto segue uma arquitetura em camadas:

```
Fronteira → Controller → Service → Repository → Entidades
```

### Camadas

* **Fronteira**

  * Interface com o usuário (console)
  * Entrada e saída de dados

* **Controller**

  * Intermedia a comunicação entre fronteira e regras de negócio

* **Service**

  * Contém as regras de negócio do sistema

* **Repository**

  * Responsável pelo armazenamento dos dados (simulado com `Map` e `List`)

* **Entidades**

  * Representam os objetos do domínio (Cliente, Corrida, etc.)

---

## Conceitos aplicados

* Programação Orientada a Objetos (POO)
* Princípios **SOLID**
* Separação de responsabilidades (SRP)
* Baixo acoplamento entre camadas
* Simulação de persistência em memória

---

## Estrutura do Projeto

* `Pessoa` (classe abstrata)

* `Cliente`

* `Cooperador`

* `Corrida`

* `Endereco`

* `Telefone`

* `Veiculo`

* `ClienteService`, `CooperadorService`, `CorridaService`

* `Repositories` (simulação de banco)

* `Controllers`

* `Front` (interface em console)

---

## Como executar

1. Compile o projeto:

```
javac *.java
```

2. Execute:

```
java SistemaFront
```

---

## Regras de Negócio

* Cliente pode ser cadastrado apenas com nome inicialmente
* Máximo de **2 telefones por pessoa**
* Corridas só podem ocorrer em **logradouros válidos**
* Status da corrida:

  * Aguardando VR
  * Aguardando aviso
  * Aviso efetuado
  * Tripulado
  * Cancelado (passageiro/cooperativa)

---

## Objetivo

Este projeto foi desenvolvido com fins educacionais para praticar:

* Modelagem de sistemas
* Organização de código
* Boas práticas de desenvolvimento

---

## Autor

Desenvolvido por **Oséias Augusto**
