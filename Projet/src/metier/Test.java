package metier;

import lpsolve.LpSolve;

import lpsolve.LpSolveException;

public class Test {

	public static void main(String[] args) throws Exception {
		
		/* Vector p = new Vector(10) ;
		 p.addElement(new Double(0.1)) ;
		  p.addElement(new Double(0.1)) ;
		  p.addElement(new Double(0.25)) ;
		  p.addElement(new Double(0.05)) ;
		  p.addElement(new Double(0.5)) ;
		  
		  Vector w = new Vector(10) ;
		  w.addElement(new Float(0.7)) ;
		  w.addElement(new Float(0.8)) ;
		  w.addElement(new Float(0.6)) ;
		  w.addElement(new Float(0.7)) ;
		  w.addElement(new Float(0.15)) ;
		 
		  double[][] inter={ {0, 0.05, 0.05, 0, 0},{0.05,0,0,0,0.1},{0.05,0,0,0,0.3},{0,0,0,0,0},{0,0.1,0.3,0,0}};
		  
		 OptimisationPerFix per=new OptimisationPerFix() ;
		   Vector<Double> r= per.preparerCoeff(p, w  ,inter) ;
		   for(int i=0;i<r.size();i++){
		     System.out.println( " r[ "+ i + "] = " + r.get(i))  ;
		   }
		   
		   */
		
		try {
			System.loadLibrary("lpsolve55");
		
		      LpSolve solver = LpSolve.makeLp(0, 3);

		      // add constraints
		      solver.strAddConstraint("1 0 0 ", LpSolve.LE, 0.757576);
		      solver.strAddConstraint("0 1 0", LpSolve.LE, 0.656566);
		      solver.strAddConstraint("0 0 1", LpSolve.LE, 0.131313);
		      solver.strAddConstraint("0.757576 0.656566 0.131313", LpSolve.EQ, 0.6174);
		      // set objective function
		      solver.strSetObjFn("5420.0 1265.0 2013.0");

		      // solve the problem
		      solver.solve();

		      // print solution
		      System.out.println("Value of objective function: " + solver.getObjective());
		      double[] var = solver.getPtrVariables();
		      for (int i = 0; i < var.length; i++) {
		        System.out.println("Value of var[" + i + "] = " + var[i]);
		      }

		      // delete the problem and free memory
		      solver.deleteLp();
		    }
		    catch (LpSolveException e) {
		       e.printStackTrace();
		    }
		  }

}  
		   
		   
		
		
