package sysexp;



public class RegleComposee {
	private String[] premisse ;
	private String conclusion;
	public String[] getPremisse() {
		return premisse;
	}
	public void setPremisse(String[] premisse) {
		this.premisse = premisse;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public RegleComposee(String premisse, String conclusion) {
		this.premisse = premisse.split("&");
		this.conclusion = conclusion;
	}
	public RegleComposee() {
	}
}
