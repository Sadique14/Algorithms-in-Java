package infixToPostfix;


public class MainClass {

	public static String infixToPostfixOperation(String infix) 
	{
		LinkedStack<Character> buffer = new LinkedStack<>();
		
		String opening = new String("({[");
		String closing = new String(")}]");
		String operator = new String("$*/+-");
		
		String postfix = new String("");
		
		for(char c: infix.toCharArray())
		{
			if(c>= '0' && c<= '9')
			{
				postfix+=c;
			}
			else if(opening.indexOf(c) != -1)
			{
				buffer.push(c);
			}
			
			else if(operator.indexOf(c) !=-1)
			{
				char sym = buffer.peek();
				char currentSym = c;
				if(operator.indexOf(sym) == -1)
					buffer.push(c);
				else {
					//while(operator.indexOf(buffer.peek()) != -1)
					//{
						if(operator.indexOf(sym) <= operator.indexOf(c))
						{
							postfix+= buffer.pop();
							buffer.push(c);
						}
						else {
							buffer.push(c);
						}
					//}
				}
			}
			else if(closing.indexOf(c) != -1)
			{
				while(true)
				{
					char temp = buffer.peek();
					if(opening.indexOf(temp) == -1)
					    postfix += buffer.pop();
					else {
						buffer.pop();
						break;
					}
				}
			}
		}
		if(!buffer.isEmpty())
		{
			postfix += buffer.pop();
		}
		return postfix;
	}
	public static int evalutaionOfPostfix(String expression)
	{
		LinkedStack<Integer> buffer = new LinkedStack<>();
		int r;
		for(char c: expression.toCharArray())
		{
			if(c>='A' && c<='B')
			{
				buffer.push((int)c -48);
			}
			else {
				int op1 = buffer.pop();
				int op2 = buffer.pop();
				
				switch(c)
				{
				case '+': r = op1+op2;
				break;
				case '-': r = op2 - op1;
				break;
				case '*': r = op2 * op1;
				break;
				case '/': r = op2/op1;
				break;
				default: r=0;
				}
				buffer.push(r);
			}
		}
		if(buffer.size()>1)
		{
			System.out.println("Error");
			return 0;
		}
		else {
			r = buffer.pop();
			return r;
		}
		
	}
	public static void main(String[] args) {
		String s = new String("(A+B)+C");
		String postfix = infixToPostfixOperation(s);
		//System.out.println(postfix);
	    //int ans = evalutaionOfPostfix(postfix);
	    //System.out.println(ans);
	}
}
