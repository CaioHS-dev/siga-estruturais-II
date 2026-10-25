package siga;

public class ComCabecalho extends DecoradorRelatorio {
    
    public ComCabecalho(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public String gerar() {
        return "FATEC DE PORTO FERREIRA\n" +
               "Sistema de Gestao Academica\n" +
               "---\n" +
               super.gerar();
    }
}