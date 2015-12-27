package bst;
public class MyBinaryTreeV3{
     public BTNode root;
     
     public MyBinaryTreeV3()
     {
          root = null;
          nodeCount = 0;
          leafCount = 0;
     }
     
     public void BSTInsert(int item)
     {
       if (isEmpty())
       {
         BTNode x = new BTNode(item);
         root = x;
       }
       else
       {
         BTNode temp = root;
         
         while(temp.getLeft()!=null&&temp.getRight()!=null)
         {
           if (item>temp.getInfo())
             temp = temp.getRight();
           else temp = temp.getLeft();
         }
         
         if (item>temp.getInfo())
           temp.setRight(item);
         else
         temp.setLeft(item);
       }
     }

     public void BSTInsertALt(int item) {
    	 if (isEmpty()) {
    		 BTNode x=new BTNode(item);
    		 root=x;
    	 }
    	 else {
    		 BTNode temp=root;
    		 BTNode q=null;

    		 while(temp!=null && temp.getInfo()!=item)
    		 {
    			 q=temp;
    			 if (item>temp.getInfo()) {
    				 temp=temp.getRight();	
    			 }
    			 else {
    				 temp=temp.getLeft();
    			 }	
    		 }
    		 //System.out.println(q.getInfo());
    		 //q points to the node after which the new node is to be inserted
    		 if (temp!=null) {
    			 return;	
    		 }
    		 else {
    			 if (item>q.getInfo()) {
    				 q.setRight(item);
    				 //System.out.println("r"+q.getInfo());	
    			 }
    			 else {
    				 q.setLeft(item);

    				 //System.out.println("l"+q.getInfo());	
    			 }	
    		 }	
    	 }	
     }
     //delete an item from BSt
     public void delete(int item)
     {
    	 BTNode temp = root;
    	 BTNode deleteNode;
    	 int left=0;
    	 int right=0;
    	 BTNode parent = null;
    	 int flag = 0;
    	 //jodi root e delete item hoy
    	 //BTNode extra = null;
    	 if(temp.getInfo() == item)
    	 {
    		 deleteNode = temp;
    		 parent = new BTNode(0);
    		 parent.setLeftNode(deleteNode);
    		 right = 0;
			 left = 1;
			 flag = 1;
    	 }
    	 //searching delete item
    	 else {
			while(temp.getInfo() != item)
			{
				if(item>temp.getInfo())
				{
					parent = temp;
					temp = temp.getRight();
					right = 1;
					left = 0;
				}
				else {
					parent = temp;
					temp = temp.getLeft();
					right = 0;
					left = 1;
				}
			}
			deleteNode = temp;
		}
    	 //jodi deleteNode er child na thake
    	if(countChild(deleteNode) == 0)
    	{
    		if(left == 1)
    		{
    			parent.setLeftNode(null);
    		}
    		else if(right == 1)
    		{
    			parent.setRightNode(null);
    		}
    	}
    	//jodi deleteNode er 1 ta child thake
    	else if(countChild(deleteNode) == 1)
    	{
    		if(left == 1)
    		{
    			if(deleteNode.getLeft()!=null)
    				parent.setLeftNode(deleteNode.getLeft());
    			else {
    				parent.setLeftNode(deleteNode.getRight());
				}
    		}
    		else if(right == 1)
    		{
    			if(deleteNode.getLeft()!=null)
    				parent.setRightNode(deleteNode.getLeft());
    			else {
    				parent.setRightNode(deleteNode.getRight());
				}
    		}
    	}
    	//jodi deleteNode er 2 ba nicher dike aro child thake
    	else if(countChild(deleteNode) == 2)
    	{
    		BTNode max = maximumNode(deleteNode.getLeft());
    		temp = deleteNode.getLeft();
    		BTNode tempParent = deleteNode;
    	
    		//finding the parent of the maximum node
    		while(temp.getInfo() != max.getInfo())
    		{
    			if(max.getInfo()<temp.getInfo())
    			{
    				tempParent = temp;
    				temp = temp.getLeft();
    			}
    				
    			else {
    				tempParent = temp;
    				temp = temp.getRight();
    			}
    		}
            
    		if(tempParent.getRight() != null)        //jodi right e child na thake
    		    tempParent.setRightNode(null);
    		else
    			tempParent.setLeftNode(null);
    		//delete deleteItem
    		if(left == 1)
    		{
    			parent.setLeftNode(max);
    		}
    		else if(right == 1)
    		{
    			parent.setRightNode(max);
    		}
    		if(deleteNode.getLeft().getInfo() != max.getInfo())
    		    max.setLeftNode(deleteNode.getLeft());
    		max.setRightNode(deleteNode.getRight());

    	}
     }
     
   //kono node er child koyta seta count hochse
     public int countChild(BTNode temp)
     {
    	 int count = 0;
    	 if(temp.getLeft()!=null && temp.getRight()!=null)
    	 {
    		 count = 2;
    		 return count;
    	 }
    	 else if(temp.getLeft()!=null || temp.getRight()!=null)
    	 {
    		 count = 1;
    		 return count;
    	 }
    	 else
    		 return count;
    	 
     }
     
     BTNode maximum;
     int flag = 0;
     //current node theke suru kore er niche porjonto maximum node ta ber kore
     public BTNode maximumNode(BTNode current)
     {
    	 flag = 1;
    	 postorderTraversal(current);
    	 flag = 0;
    	 return maximum;
     }
     public boolean isEmpty(){   return root == null;  }
     
     
     public void preorderTraversal(BTNode current)
     {
    	 
          if ( current != null )
          {
               nodeCount++;
              
               if(current.getLeft() == null && current.getRight() == null)
                    leafCount++;
               if(flag==0)
                   System.out.print(current.getInfo()+"  ");
               preorderTraversal(current.getLeft());
               preorderTraversal(current.getRight());
          }
     }

     public void inorderTraversal(BTNode current)
     {
    	 
    	 if ( current != null )
    	 {
    		 
    		 
    		 inorderTraversal(current.getLeft());
    		 System.out.print(current.getInfo()+"  ");
    		 inorderTraversal(current.getRight());
    	 }
     }
     
     //eikhane maximum node ber kora hoise
     int k=0;
     public void postorderTraversal(BTNode current)
     {
    	 if(k==0)
    		 maximum = current;
    	 k++;
    	 if ( current != null )
    	 {
    		 postorderTraversal(current.getLeft());
    		 postorderTraversal(current.getRight());
    		 if(flag==0)
    		     System.out.print(current.getInfo()+"  ");
    		 if(maximum.getInfo() < current.getInfo())
    			 maximum = current;
    	 }
     }
     
     public int TreeHeight(BTNode temp)
     {
        if(temp==null)
          return 0;
        else
          return 1 + max(TreeHeight(temp.getLeft()), TreeHeight(temp.getRight()));
     }
     
     private int max(int heightLeft, int heightRight)
     {
       if (heightLeft>heightRight)
         return heightLeft;
       else
         return heightRight;
     }
     
     public int TreeNodeCount()
     {
          nodeCount = 0; 
          flag = 1;
          preorderTraversal(root);
          flag = 0;
          return nodeCount;
     }
     
     private int nodeCount = 0;
     private int leafCount = 0;
     
     public int TreeLeavesCount()
     {
          leafCount = 0;
          flag = 1;
          preorderTraversal(root);
          flag=0;
          return leafCount;
     }
     
}