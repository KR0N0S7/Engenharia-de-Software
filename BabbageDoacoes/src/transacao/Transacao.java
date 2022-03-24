package transacao;

public abstract class Transacao {

	protected long data;

	public long getData() {	return data;}
	public void setData(long data) { this.data = data;}
	
	public void geraLog() {
		
	}
}
