package model;

import java.util.ArrayList;
import java.util.List;

public class StatusEnum {
    private ProcessoState state;
    private List<Assinante> alunos = new ArrayList<>();
    private List<Assinante> coordenadores = new ArrayList<>();

    public void setEstado(ProcessoState state) {
        this.state = state;
        notificarAlunos("O estado do processo foi alterado para: " + state.getDescricao());
        notificarCoordenadores(state);
    }

    public void adicionarAlunoAssinante(Assinante aluno) {
        alunos.add(aluno);
    }

    public void adicionarCoordenadorAssinante(Assinante coordenador) {
        coordenadores.add(coordenador);
    }

    private void notificarAlunos(String mensagem) {
        for (Assinante aluno : alunos) {
            aluno.atualizar(mensagem);
        }
    }

    private void notificarCoordenadores(ProcessoState state) {
        if (state instanceof EmPautaState || state instanceof EmJulgamentoState) {
            String mensagem = "O estado do processo está: " + state.getDescricao();
            for (Assinante coordenador : coordenadores) {
                coordenador.atualizar(mensagem);
            }
        }
    }


    // Métodos públicos para executar ações no estado atual
    public void distribuir(Processo processo) {
        state.distribuir(processo);
    }

    public void pautar(Processo processo) {
        state.pautar(processo);
    }

    public void julgar(Processo processo) {
        state.julgar(processo);
    }

    public String getDescricao() {
        return state.getDescricao();
    }
}
