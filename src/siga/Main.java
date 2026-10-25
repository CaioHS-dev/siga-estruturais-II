package siga;

/**
 * Demonstra os três deslizes acontecendo. Execute e observe a saída:
 * é dela que partem as etapas da ficha de atividade prática.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 11: Decorator e Composite ===\n");
        
        System.out.println("1) Relatorios (Decorator)");
        Relatorio relatorioBase = new RelatorioDeAlunos();
        
        Relatorio pilha1 = new ComMarcaDagua(new ComNumeracao(new ComCabecalho(relatorioBase)));
        System.out.println("--- Pilha 1: Cabecalho -> Numeracao -> Marca D'agua ---");
        System.out.println(pilha1.gerar());
        
        Relatorio pilha2 = new ComCabecalho(new ComNumeracao(relatorioBase));
        System.out.println("\n--- Pilha 2: Numeracao -> Cabecalho (Apenas numeros no corpo) ---");
        System.out.println(pilha2.gerar());

        System.out.println("\n2) Estrutura curricular (Composite)");
        Modulo curso = new Modulo("DSM - Desenvolvimento de Software Multiplataforma");
        
        Modulo primeiro = new Modulo("1° semestre");
        primeiro.adicionar(new Disciplina("Algoritmos", 80));
        primeiro.adicionar(new Disciplina("Banco de Dados I", 60));
        
        Modulo segundo = new Modulo("2° semestre");
        segundo.adicionar(new Disciplina("Tecnicas de Programacao II", 80));
        segundo.adicionar(new Disciplina("Desenvolvimento Web II", 80));
        
        Modulo trilhaExtra = new Modulo("Trilha de Especializacao");
        trilhaExtra.adicionar(new Disciplina("Seguranca da Informacao", 40));
        segundo.adicionar(trilhaExtra);

        curso.adicionar(primeiro);
        curso.adicionar(segundo);
        curso.adicionar(new Disciplina("Projeto Integrador", 40));

        curso.imprimir(1);
        System.out.println("   Carga total: " + curso.getCargaHoraria() + "h");
    }
}