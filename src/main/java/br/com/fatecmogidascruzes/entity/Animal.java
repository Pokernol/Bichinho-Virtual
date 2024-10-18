package br.com.fatecmogidascruzes.entity;

public class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private int caloria;
    private int forca;
    private boolean vivo;

    public Animal() {
        this.caloria = 0;
        this.classe = "";
        this.familia = "";
        this.idade = 0;
        this.forca = 0;
        this.nome = "";
        this.vivo = false;
    }

    public Animal(String classe, String familia, String nome) {
        this.caloria = 10;
        this.classe = "";
        this.familia = "";
        this.forca = 10;
        this.nome = "";
        this.vivo = true;
    }

    public void nascer(String classe, String familia, String nome) {
        this.caloria = 10;
        this.classe = classe;
        this.familia = familia;
        this.forca = 10;
        this.nome = nome;
        this.vivo = true;
        this.idade = 0;
    }

    public void morrer() {
        this.forca = 0;
        this.vivo = false;
    }

    public void comer() throws Exception {
        if (this.forca < 2) {
            throw new Exception("Animal Exausto!");
        }
        if (!this.vivo) {
            throw new Exception("Animal morto!");
        }
        if (this.caloria > 100) {
            throw new Exception("Animal cheio!");
        }
        this.caloria += 10;
        this.forca -= 2;
    }

    public void correr() throws Exception {
        if (this.forca < 5) {
            throw new Exception("Animal Exausto!");
        }
        if (!this.vivo) {
            throw new Exception("Animal morto!");
        }
        if (this.caloria < 5) {
            throw new Exception("Animal faminto!");
        }
        this.caloria -= 5;
        this.forca -= 5;
    }

    public void dormir() throws Exception {
        if (!this.vivo) {
            throw new Exception("Animal morto!");
        }
        if (this.caloria < 2) {
            throw new Exception("Animal faminto!");
        }
        this.forca += 5;
        this.caloria -= 2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCaloria() {
        return caloria;
    }

    public void setCaloria(int caloria) {
        this.caloria = caloria;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}