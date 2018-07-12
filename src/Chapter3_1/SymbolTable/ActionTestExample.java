package Chapter3_1.SymbolTable;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ActionTestExample {
	/*––Œ™≤‚ ‘”√¿˝*/
	
	public static void main(String[] args) {
		SybolTable st;
		st=new SybolTable();
		for (int i = 0;!StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (Object s : st.keys()) {
			StdOut.print(s+" "+st.get((Comparable) s));
		}
	}

}
