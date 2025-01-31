
public class StringMeth {

	public StringMeth() {
		super();
	}
	
	public int nChar(String s, char c) {
		int tot = 0;
		for(int i = 0; i < s.length(); i++) {
			if(c == s.charAt(i))
				tot++;
		}
		return tot;
	}
	
	public boolean isPalindroma(String s) {
		for(int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
		
	}

}
