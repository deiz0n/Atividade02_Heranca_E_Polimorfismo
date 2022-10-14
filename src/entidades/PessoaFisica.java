package entidades;

public class PessoaFisica extends TipoPessoa {

    private Double gastosSaude;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double taxa() {
        if (getGastosSaude() != 0.0) {
            if (getRendaAnual() < 20000.00) {
                return (getRendaAnual() * 0.15) - (getGastosSaude() * 0.5);
            } else {
                return (getRendaAnual() * 0.25) - (getGastosSaude() * 0.5);
            }
        } else {
            if (getRendaAnual() < 20000.00) {
                return (getRendaAnual() * 0.15) - (getGastosSaude() * 0.5);
            } else {
                return (getRendaAnual() * 0.25) - (getGastosSaude() * 0.5);
            }
        }
    }
}
