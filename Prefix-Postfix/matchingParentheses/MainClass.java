package matchingParentheses;

public class MainClass {

	public static boolean isMatched(String expression)
	{
		final String opening = new String("({[");
		final String closing = new String(")}]");
		ArrayStack<Character> buffer = new ArrayStack<>(50);
		
		for(char c: expression.toCharArray())
		{
			if(opening.indexOf(c) != -1)
			{
                buffer.push(c);				
			}
			else if(closing.indexOf(c) != -1)
			{
				if(buffer.isEmpty())
					return false;
				if(closing.indexOf(c) != opening.indexOf(buffer.pop()))
					return false;
			}
		}
		return buffer.isEmpty();
	}
	public static boolean isHTMLMatched(String html)
	{
		ArrayStack<String> buffer = new ArrayStack<String>(50);
		int j = html.indexOf('<');
		while(j != -1)
		{
			int k = html.indexOf('>', j+1);
			if(k == -1)
				return false;
			String tag = html.substring(j+1, k);
			if(!tag.startsWith("/"))
			{
				buffer.push(tag);
			}
			else {
				if(buffer.isEmpty())
					return false;
				if(!tag.substring(1).equals(buffer.pop()))
					return false;
			}
			j = html.indexOf('<', k+1);
		}
		return buffer.isEmpty();
	}
	
	public static void main(String[] args) {
		
		String s = new String("[{(5+6)/100}-8]");
		System.out.println(isMatched(s));
		String html = new String("<body><center><h1> The Little Boat </h1></center>"+
"<p> The storm tossed the little boat like a cheap sneaker in an"
+"old washing machine. The three drunken fishermen were used to"+
"such treatment, of course, but not the tree salesman, who even as"+
"a stowaway now felt that he had overpaid for the voyage. </p>"+
"<ol> <li> Will the salesman die? </li> <li> What color is the boat? </li>"+
"<li> And what about Naomi? </li> </ol> </body>");
		System.out.println(isHTMLMatched(html));
	}
}
