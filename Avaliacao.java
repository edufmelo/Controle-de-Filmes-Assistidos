public enum Avaliacao {
    // Enumeradores com suas respectivas notas associadas
    RUIM(1),
    REGULAR(2),
    BOM(3),
    MUITO_BOM(4),
    EXCELENTE(5);

    private int nota;

    // Construtor privado para associar uma nota a cada enumerador
    Avaliacao(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}


