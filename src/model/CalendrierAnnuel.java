package model;

public class CalendrierAnnuel {
	private Mois[] calendrier;
	
	public CalendrierAnnuel() {
		this.calendrier = new Mois[]{
	            new Mois("Janvier", 31),
	            new Mois("Février", 28),
	            new Mois("Mars", 31),
	            new Mois("Avril", 30),
	            new Mois("Mai", 31),
	            new Mois("Juin", 30),
	            new Mois("Juillet", 31),
	            new Mois("Aoutt", 31),
	            new Mois("Septembre", 30),
	            new Mois("Octobre", 31),
	            new Mois("Novembre", 30),
	            new Mois("Décembre", 31)
		};
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour-1);
	}
	
	public boolean reserver(int jour, int mois) {
		try {
			calendrier[mois-1].reserver(jour-1);
		}
		catch (IllegalStateException e) {
			return false;
		}
		return true;
	}
	
	private static class Mois {
		private String nom;
		private boolean[] jours;
		
		public Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
		}
		
		private boolean estLibre(int jour) {
			return jours[jour-1]==false;
		}
		
		private void reserver(int jour) throws IllegalStateException {
			if(!estLibre(jour)) {
				throw new IllegalStateException("Le jour n'est pas libre\n");
			}
			jours[jour-1]=true;
		}
	}
}
