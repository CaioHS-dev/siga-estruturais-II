# Documentação de Refatoração: Padrões Decorator e Composite (SIGA)

## 1. Refatoração dos Relatórios (Padrão Decorator)

* O modelo original sofria de uma explosão combinatória de subclasses. Para cada combinação de características opcionais, existia uma classe inteira dedicada, como `RelatorioComCabecalhoENumeracao`. Consequentemente, havia duplicação de comportamento: o texto do cabeçalho e a lógica de numeração estavam copiados e colados em três classes diferentes. 

* Criei uma classe base abstrata `DecoradorRelatorio` que envolve a interface `Relatorio`. A partir dela, criei apenas três classes isoladas: `ComCabecalho`, `ComNumeracao` e `ComMarcaDagua`. Após transferir as lógicas individuais, excluí as quatro classes `RelatorioCom...` originais.

* O padrão Decorator substitui o uso rígido de herança por composição dinâmica. Ao isolar cada comportamento no seu próprio decorador, eu garanti que o texto do cabeçalho existisse em um único lugar. Agora, posso empilhar os opcionais em tempo de execução sem criar $2^n$ classes para cobrir todas as combinações matemáticas.

## 2. Refatoração da Estrutura Curricular (Padrão Composite)

* A classe `Modulo` armazenava seus itens em uma coleção genérica de `Object`. Isso forçava a classe `GradeCurricular` a usar laços com múltiplos `instanceof` para descobrir se o item era um `Modulo` ou uma `Disciplina` antes de executar qualquer ação. Isso violava frontalmente o Princípio Aberto/Fechado.

* Criei a interface `ItemCurricular` definindo os métodos essenciais: `getNome()`, `getCargaHoraria()` e `imprimir(int nivel)`. Ajustei `Disciplina` e `Modulo` para implementarem essa interface. A lista interna de `Modulo` passou a ser estritamente de `ItemCurricular`. Por fim, apaguei a classe `GradeCurricular`, pois os próprios itens assumiram a responsabilidade pelas operações.

* O padrão Composite me permitiu tratar objetos individuais e composições de objetos de forma idêntica e uniforme. O cliente não precisa mais investigar o tipo da instância; ele apenas chama o método definido na interface.

* Tomei a decisão de manter os métodos `adicionar()` e `remover()` estritamente dentro da classe `Modulo`, sem promovê-los para a interface `ItemCurricular`. Fiz isso para priorizar a **segurança de tipos**. Se colocasse na interface, a classe `Disciplina` seria obrigada a implementar métodos de adição que não fazem sentido prático, o que tensionaria o Princípio de Substituição de Liskov. Dessa forma, garanto em tempo de compilação que submódulos não possam ser adicionados indevidamente a disciplinas.