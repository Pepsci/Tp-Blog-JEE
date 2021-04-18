package bean;

public class Article {

	private int id;
	private String titre;
	private String resume;
	private String contenu;
	private String created_at;
	private String auteur;
	
	
	public Article(String titre, String resume, String contenu) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
	}

	public Article(String titre, String resume, String contenu, String created_at, String auteur) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.created_at = created_at;
		this.auteur = auteur;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
}
