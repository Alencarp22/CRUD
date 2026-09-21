package model;

public class PontoColeta {
    private int id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String materiaisAceitos;
    private String horarioFuncionamento;
    private Double latitude;
    private Double longitude;

    public PontoColeta() {
    }

    public PontoColeta(int id, String nome, String endereco, String bairro, String cidade,
                       String materiaisAceitos, String horarioFuncionamento,
                       Double latitude, Double longitude) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.materiaisAceitos = materiaisAceitos;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getMateriaisAceitos() { return materiaisAceitos; }
    public void setMateriaisAceitos(String materiaisAceitos) { this.materiaisAceitos = materiaisAceitos; }

    public String getHorarioFuncionamento() { return horarioFuncionamento; }
    public void setHorarioFuncionamento(String horarioFuncionamento) { this.horarioFuncionamento = horarioFuncionamento; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}
