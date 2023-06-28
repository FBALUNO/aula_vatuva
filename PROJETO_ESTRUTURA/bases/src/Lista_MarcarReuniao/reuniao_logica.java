package Lista_MarcarReuniao;

import java.util.UUID;

public class reuniao_logica {

  private UUID isbn;
  private String NomeReuniao;
  private boolean especial;

  public reuniao_logica(UUID isbn, String NomeAviao, boolean especial) {
    this.isbn = isbn;
    this.NomeReuniao = NomeAviao;
    this.especial = especial;
  }

  public UUID getIsbn() {
    return isbn;
  }

  public String getNomeAviao() {
    return NomeReuniao;
  }

  public boolean isEspecial() {
    return especial;
  }
}