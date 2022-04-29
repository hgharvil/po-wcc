public class StringCompressor {
	
	private String original;
	
	StringCompressor(String string){
		this.original = string;
	}
	
	public void show() {
		System.out.println("Original String: "+this.original);
	}
	
	public String compress() {
		String product = this.original;
		char current = '.';
		int count = 0;
		String answer = "";
		for(int i = 0; i < product.length(); i++) {
			if(i == 0) {
				current = product.charAt(i);
				count = 1;
			} else if(current == product.charAt(i)) {
				count++;
			} else { //if character chain is broken
					answer +=  Character.toString(current)+count;
					current = product.charAt(i);
					count = 1;
					
			} if(i == product.length()-1) { // last char
				if(answer.charAt(answer.length()-1) != current){
					answer +=  Character.toString(current)+count;
				}
			}
		}
		
		if(product.length() > answer.length()) {
			product = answer;
		}
		
		return product;
		
	}

	public static void main(String[] args) {
		
		StringCompressor sc = new StringCompressor("abbbb");
		sc.show();
		System.out.println("Result: "+sc.compress());
		
	}

}
