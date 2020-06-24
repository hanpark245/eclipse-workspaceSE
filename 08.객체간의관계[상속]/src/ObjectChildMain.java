
public class ObjectChildMain {

	public static void main(String[] args) {
		ObjectChild oc=new ObjectChild();
		int hashCode=oc.hashCode();
		System.out.println(hashCode);
		String str=oc.toString();
		System.out.println(str);
	}

}
