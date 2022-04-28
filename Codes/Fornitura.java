
//pippo
public class Fornitura {
    private String id;
    public enum TipoFornitura  {ENERGIA_ELETTRICA, GAS, ACQUA };
    private double tariffa;
    private String unitaFornitura;
    private TipoFornitura tipo;

    public Fornitura(String id, TipoFornitura tipo, double tariffa ) {
        this.id = id;
        this.tariffa = tariffa;
        this.tipo = tipo;

        switch (tipo) {
            case ENERGIA_ELETTRICA:
                this.unitaFornitura = "KiloWattOra";
                break;
            case GAS:
                this.unitaFornitura = "MetriCubi";
                break;
            case ACQUA:
                this.unitaFornitura = "MetriCubi";
                break;
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTariffa(double tariffa) {
        this.tariffa = tariffa;
    }

    public void setTipo(TipoFornitura tipo) {
        this.tipo = tipo;
        switch (tipo) {
            case ENERGIA_ELETTRICA:
                this.unitaFornitura = "KiloWattOra";
                break;
            case GAS:
                this.unitaFornitura = "MetriCubi";
                break;
            case ACQUA:
                this.unitaFornitura = "MetriCubi";
                break;
        }
    }

    public String getId() {
        return this.id;
    }

    public double getTariffa() {
        return this.tariffa;
    }

    public TipoFornitura getTipo() {
        return  this.tipo;
    }

    public String getUnitaFornitura() {
        return this.unitaFornitura;
    }
}
//cazsss
//ddss