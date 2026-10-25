package siga;

public abstract class DecoradorRelatorio implements Relatorio {
    protected Relatorio relatorio;

    public DecoradorRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public String gerar() {
        return relatorio.gerar();
    }
}