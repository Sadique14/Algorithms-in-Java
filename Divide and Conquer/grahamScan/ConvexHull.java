package grahamScan;

public class ConvexHull {
	
	boolean end;
	public ConvexHull(Node ptsList)
	{
		end = false;
		Scan(ptsList);
		PrintList(ptsList);
	}
	
	public void Scan(Node list)
	{
		Node p = list;
		Node p1 = list;
		Node p2 = null;
		Node p3 = null;
		do {
			p2 = p1.getNext();
			if(p2.getNext() != null)
			{
				p3 = p2.getNext();
				double temp = Area(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
				if(temp>=0.0)
					p1 = p1.getNext();
				else
				{
					p1.setNext(p3);
					p3.setPrev(p1); //p2 is deleted
					p1 = p1.getPrev();
				}
			}
			else
				end = true;
		} while (!end);
	}
	public double Area(double x1, double y1, double x2, double y2, double x3, double y3)
	{
		return (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
	}
	public void PrintList(Node ptsList)
	{
		Node temp = ptsList;
		while(temp!=null)
		{
			System.out.print(temp.getX()+" ");
			System.out.println(temp.getY());
			temp = temp.getNext();
		}
	}
}
