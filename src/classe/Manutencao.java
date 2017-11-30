package classe;

public class Manutencao {

	private int idManutencao;

	private String descricaoManutencao;

	private String tipoManutencao;

	private String dataManutencao;

	private String numeroOS;

	private String statusManutencao;
        
        private String placa;

	public void cadastrarManutencao(int idManutencao, String descricaoManutencao, String tipoManutencao, String dataManutencao, String carroMautencao, String statusManutencao) {

	}

	public void alterarManutencao(int idManutencao, String descricaoManutencao, String tipoManutencao, String dataManutencao, String carroMautencao, String statusManutencao) {

	}

	public void cancelarManutencao(int idManutencao, String descricaoManutencao, String tipoManutencao, String dataManutencao, String carroMautencao, String statusManutencao) {

	}

	public void setIdManutencao(int idManutencao) {

	}

	public int getIdManutencao() {
		return 0;
	}

	public void setDescricaoManutencao(String descricaoManutencao) {

	}

	public String getDescricaoManutencao() {
		return "";
	}

	public void setTipoManutencao(String tipoManutencao) {

	}

	public String getTipoManutencao() {
		return "";
	}

	public void setCarroManutencao(String carroManutencao) {

	}

	public String getCarroManutencao() {
		return "";
	}

	public void setDataManutencao(String dataManutencao) {

	}

	public String getDataManutencao() {
		return "";
	}

	public String listarManutencaoAberta() {
		return "";
	}

	public String listarManutencaoEncerrada() {
		return "";
	}

	public String listarManutencaoPreventiva() {
		return "";
	}

	public String listarManutencaoCorretiva() {
		return "";
	}

    /**
     * @return the numeroOS
     */
    public String getNumeroOS() {
        return numeroOS;
    }

    /**
     * @param numeroOS the numeroOS to set
     */
    public void setNumeroOS(String numeroOS) {
        this.numeroOS = numeroOS;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the statusManutencao
     */
    public String getStatusManutencao() {
        return statusManutencao;
    }

    /**
     * @param statusManutencao the statusManutencao to set
     */
    public void setStatusManutencao(String statusManutencao) {
        this.statusManutencao = statusManutencao;
    }

}
