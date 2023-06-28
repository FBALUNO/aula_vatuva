package ArvoreBinaria_Atividade_Diária;

import java.util.UUID;

class Atividade {
    private UUID isbn;
    private String nomeAviao;
    private boolean especial;

    public Atividade(UUID isbn, String nomeAviao, boolean especial) {
        this.isbn = isbn;
        this.nomeAviao = nomeAviao;
        this.especial = especial;
    }

    public UUID getIsbn() {
        return isbn;
    }

    public String getNomeAviao() {
        return nomeAviao;
    }

    public boolean isEspecial() {
        return especial;
    }

    @Override
    public String toString() {
        return "Aviao [ISBN=" + isbn + ", Nome=" + nomeAviao + ", Especial=" + especial + "]";
    }
}