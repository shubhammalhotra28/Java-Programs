import java.io.File;

public class Info implements Comparable< Info >{
private File fileObject;
private long CRC;

	public Info(long crcVal, File file){
		CRC = crcVal;
		fileObject = file;
	}

	public long getCRC(){
		return CRC;
	}

	public void setCRC(long CRC_2){
		CRC = CRC_2;
	}

   public void setFileObj(File fileObject){
		this.fileObject = fileObject;
	}

	public File getFileObj(){
		return fileObject;
	}


	@Override
	public int compareTo(Info o) {
		return Long.compare(this.getCRC(),o.getCRC());
	}


}
