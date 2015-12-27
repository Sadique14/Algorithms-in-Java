package evaluationPostfixExpression;

public class MainClass {
	
	public static void main(String[] args) {
		String s = new String("63+2*");
		System.out.println(evalutaionOfPostfix(s));
	}

	public static int evalutaionOfPostfix(String expression)
	{
		LinkedStack<Integer> buffer = new LinkedStack<>();
		int r;
		for(char c: expression.toCharArray())
		{
			if(c>='0' && c<='9')
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
}
