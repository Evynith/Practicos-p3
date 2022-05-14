package tp6;

import java.util.Hashtable;

public class HashtablePractica {

	public static void main(String[] args) {
		Hashtable<Integer, String> myhash = new Hashtable<Integer, String>(3, 1.7f);
		myhash.put(27, "primero");
		myhash.put(4, "segundo");
		myhash.put(12, "tercero");
		myhash.put(16, "cuarto");
		myhash.put(91, "quinto");
		//esos iniciales
		myhash.put(33, "a");
		myhash.put(31, "b");
		System.out.println(myhash.size());
	}

}
