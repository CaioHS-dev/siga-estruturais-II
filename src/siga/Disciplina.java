package siga;

/**
 * Folha da estrutura curricular — hoje sem nenhuma interface em comum
 * com Modulo. É essa ausência que obriga o cliente a usar instanceof.
 */

public class Disciplina implements ItemCurricular {
    private final String nome;
    private final int cargaHoraria;

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public void imprimir(int nivel) {
        System.out.println("  ".repeat(nivel) + nome + " (" + cargaHoraria + "h)");
    }
}
