package model;

public class EmJulgamentoState implements ProcessoState {
    @Override
    public void distribuir(Processo processo) {
        // Lógica adicional, se necessário, quando estiver em julgamento
    }

    @Override
    public void pautar(Processo processo) {
        // Lógica adicional, se necessário, quando estiver em julgamento
    }

    @Override
    public void julgar(Processo processo) {
        // Lógica adicional, se necessário, quando já estiver em julgamento
        processo.setEstado(new JulgadoState());
    }

    @Override
    public String getDescricao() {
        return "EM JULGAMENTO";
    }
}