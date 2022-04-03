import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Collections;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
import java.util.Set;
import java.util.Iterator;
import java.util.*;


/**Motuba MP **/
 
class Ranks
{
   
    public static void main(String[] args)
    {
    	
    	try (Scanner sc = new Scanner(System.in)) {
    		
    		//map for match result
			Map<String, String> map = new HashMap<>();
								
			//map for ordering results
			Map<String, Integer> orderedTable = new HashMap<>();
			
			//map for displaying sorted results
			Map<String, Integer> sortedWin = new HashMap<>();
			Map<String, Integer> AlphabeticalysortedWin = new HashMap<>();
			
			Map<String, Integer> sortedLose = new HashMap<>();
			
			Map<String, Integer> sortedDraw = new HashMap<>();
			
			
			Map<String, Integer> winTable = new HashMap<>();
			
			Map<String, Integer> drawTable = new HashMap<>();
			
			Map<String, Integer> loseTable = new HashMap<>();
			
			String TeamAGoals  ;
			String TeamAName = "" ;
			
			String TeamBGoals  ;
			String TeamBName = "" ;
			
			Integer win = 3 ;
			Integer lose = 0;
			Integer draw = 1;
			
			
			
			System.out.println("Hi there, Welcome to the ranking table of Tournament_2022.") ;
			
			System.out.print("The Tournament_2022 is allowed to have a maximum number of 5 games to be played. " +  "\n");
			//takes the number of teams to make array size
			Integer matches = 5 ;
			//consuming the <enter> from input above
			//sc.nextLine();
			
			System.out.print("You can now enter results of the games in the following manner"  +  "\n" + "TeamName then <enter> -->"
			+ " TeamGoals then <enter>. Do this once more for the opponent....." + "\n" );
			 
			 
			
			
			
			
			
				//Entering team names 
			    //System.out.print("You can now enter " + teams.length + "team names, each confirmed by the enter key"  +  "\n");
			    for(int i = 0; i < matches; i++) {
			    		    	
			    	//adding teams names after every <enter> button
			    	System.out.println("Match:" + (i + 1)) ;
			    	
			    	TeamAName = sc.nextLine() ;
			    	TeamAGoals = sc.nextLine() ;			    	
			    	map.put(TeamAName , TeamAGoals);
			    	
			    	
			    	System.out.println("VRS") ;
			    	
			    	
			    	TeamBName = sc.nextLine() ;
			    	TeamBGoals = sc.nextLine() ;			    	
			    	map.put(TeamBName , TeamBGoals);
			    	
			    	
			    	
			    	/**Accumulating team A points in case team A win**/    	
			    	if(Integer.parseInt(TeamAGoals) > Integer.parseInt(TeamBGoals)) {
			    		
			    			
			    		
			    	       
			    			
			    			 /**If team A exists....accumulate win points**/
			    			 if(winTable.containsKey(TeamAName)) {
			    				
			    				
			    				winTable.put(TeamAName, win + 3);
			    				loseTable.put(TeamBName, lose) ;
			    			
			    			}
			    			
			    			/**If team A  don't exists in the league.....give it normal win points**/
			    			
			    			else 
			    			{
			    				
			    				
			    				winTable.put(TeamAName, win) ;
			    				loseTable.put(TeamBName , lose) ;
				    					    		
			    			}
			    		
			    					    		
			    						    		
			    	}
			    	
			    	/**Accumulating team B points in case team B wins **/    
			    	
			    	else if(Integer.parseInt(TeamBGoals) > Integer.parseInt(TeamAGoals)) {
			    		
			    		
			    
			    		
			    		    		
			    		 /**If team B exists....accumulate win points	**/		    	
			    		if(winTable.containsKey(TeamBName)) {
		    				
		    				loseTable.put(TeamAName ,  lose ) ;
		    				winTable.put(TeamBName , win + 3 ) ; 
		    			}
			    		
			    		else  //If team B doesnt exists in the league.....give it normal win points
		    			{
				    				    				
		    			loseTable.put(TeamAName ,  lose ) ;
			    		winTable.put(TeamBName , win ) ;                    
			    					    		
		    			}
				    		    	
			    				    		
			    	}		
			    		
			    		/**Accumulating team A and team B points in case of a Draw Match**/    
			    		
			    	else if(TeamAGoals.equals(TeamBGoals)) {
			    		
			   
			    				    	
			    		 /**If team A & B exist.....accumulate draw points**/
			    		if(drawTable.containsKey(TeamAName) && drawTable.containsKey(TeamBName) ) {
			    			
			    			drawTable.put(TeamAName , draw + 1) ;
				    		drawTable.put(TeamBName , draw + 1 ) ;
			    				
			    		}
				    		
			    		 //If team B exists.....accumulate draw points
			    		 if(!(drawTable.containsKey(TeamAName)) && drawTable.containsKey(TeamBName) ) {
			    			
			    			drawTable.put(TeamAName , draw  ) ;
				    		drawTable.put(TeamBName , draw + 1 ) ;
			    				
			    		}
			    	
			    		// If team A exists.....accumulate draw points
                       else if(drawTable.containsKey(TeamAName) && !(drawTable.containsKey(TeamBName)) ) {
			    			
			    			drawTable.put(TeamAName , draw + 1  ) ;
				    		drawTable.put(TeamBName , draw  ) ;
			    				
			    		}
                       else {
                    	 /**If team A & B do not exist.....accumulate draw points**/
                    	    drawTable.put(TeamAName , draw ) ;
				    		drawTable.put(TeamBName , draw ) ;
			    				
                    	   
                      }
			    		
			    		
			    				    			    		
			    				
				    		
			    	}
			    		 
			    		
			    				    		
			    		
			    	
		  	}	
			    	
			    	
			    			    	
			        			    			    		    		    			    
					    
			    
			    /**sort map by value**/
			    sortedWin = winTable.entrySet().stream().sorted(comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(),(e1 , e2) -> e2, LinkedHashMap::new)) ;
			    
			    /**sort map in decreasing order of value**/
			    sortedWin = winTable.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue , (e1 , e2) -> e2, LinkedHashMap::new)) ;
			    
			    
		
			    		
			    		
			    
			    
			    
			    
			    
			    /**sort map by value**/
			    sortedDraw = drawTable.entrySet().stream().sorted(comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(),(e1 , e2) -> e2, LinkedHashMap::new)) ;
			    
			    
			    /**sort map in decreasing order of value**/
			    sortedDraw = drawTable.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue , (e1 , e2) -> e2, LinkedHashMap::new)) ;
			    
			    
			    
			    /**sort map by value**/
			  //  sortedLose = loseTable.entrySet().stream().sorted(comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(),(e1 , e2) -> e2, LinkedHashMap::new)) ;
			    
			    /**sort map in decreasing order of value**/
			  //  sortedLose = loseTable.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue , (e1 , e2) -> e2, LinkedHashMap::new)) ;
			    
			    
			    
			    
			    
			    /**Display a sorted win table**/
			
				int count = matches ;
				System.out.println("Ranked table.") ;
				//sortAlphabetical(sortedWin) ;
			        for (Entry<String, Integer> pair : sortedWin.entrySet()) {
			        	
			        	
			        	
			        	
			        	if(sortedDraw.containsKey(pair.getKey())) {
			        		
			        		//If the sorted win contains a team with two draws
			        		
			        		if(pair.getValue() >=2 ) {
			        			
			        			sortedDraw.remove(pair.getKey()) ;
					       		sortedWin.replace(pair.getKey(), pair.getValue() + 2  ) ;
			        		}
			        		else
			        			
			        			
			        		{
			        			sortedDraw.remove(pair.getKey()) ;
					       		sortedWin.replace(pair.getKey(), pair.getValue() + 1  ) ;
			        		}
			        		
			        	
			         		
			         		
			         		
			        		
                            System.out.println(  ((matches + 1) - count) + "." + String.format( "%s, points: %s", pair.getKey(), pair.getValue())); 
				        	
			                count = count - 1 ;	
			        		
			        	}
			        	else
			        	{
			        		System.out.println(  ((matches + 1) - count) + "." + String.format( "%s, points: %s", pair.getKey(), pair.getValue())); 
				        	
			                count = count - 1 ;	
			        	}
			        	
			        	
			        		
			    		 	
			    	}
			        
			        
			        
			        /**Display a sorted draw table**/ 
			//	sortAlphabetical(sortedDraw) ;
				
			        for (Entry<String, Integer> pair : sortedDraw.entrySet()) {
			        	
		        		System.out.println(  ((matches + 1) - count) + "." + String.format( "%s, points: %s", pair.getKey(), pair.getValue())); 
		        	
		                count = count - 1 ;
		    		 	
		    	}
			        
			        
			        
			        
			        /**Display a sorted lose table**/ 
			        
			        for (Entry<String, Integer> pair : sortedDraw.entrySet()) {
			        	
  			          
				         if(sortedLose.containsKey(pair.getKey())) {
				        	  
				        	 sortedLose.remove(pair.getKey() ) ;
				        	  
				       	  //  System.out.println(  ((matches + 1) - count) + "." + String.format( "%s, points: %s", pair.getKey(), pair.getValue())); 
					        	
				          //  count = count - 1 ;
				    		 			        	  
				         }
				         
			        }
			        
			        
			        for (Entry<String, Integer> pair : sortedLose.entrySet()) {  
			        	
				        	  
				        	 System.out.println(  ((matches + 1) - count) + "." + String.format( "%s, points: %s", pair.getKey(), pair.getValue())); 
					        	
				             count = count - 1 ; 
				        	  
				        	  
			        }     
				        	  
				        	  		        	  
			  
				       
			        
			        
			        
			        
			        
			
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		        
                      //sort lose table again
			    //    for (Entry<String, Integer> pair : sortedLose.entrySet()) {
			        	
			        			        	
			        //	if(sortedDraw.containsKey(pair.getKey())) {
			        		
			        //      sortedLose.remove(pair.getKey()) ;
			       
			         					        		
			        //	}
			        	
			     //   }	
			     //   
			        
			        //Display  lose	
			     //   for (Entry<String, Integer> pair : sortedLose.entrySet()) { 	
			      //  		System.out.println(  ((matches + 1) - count) + "." + String.format( "%s, points: %s", pair.getKey(), pair.getValue())); 
				        	
			      //          count = count - 1 ;	
			        	
			        	
			     //   } 	
			        		
			    		 	
			    	
			        
			    		        			  		       
			  
          	}		    
    	}
    	
    	
    	public static void sortAlphabetical(Map<String , Integer> map1) {
    		int count = 5 ;
			//TreeMap to store values of HashMap
			TreeMap<String , Integer> sortedAplhabetical = new TreeMap<>() ;

			
			//Copy all data from hashMap into treeMap
			sortedAplhabetical.putAll(map1);
			
			//Display the TreeMap which is naturally sorted
			for (Map.Entry<String , Integer> entry : sortedAplhabetical.entrySet())
				System.out.println(  ((5 + 1) - count) + "." + String.format( "%s, points: %s", entry.getKey(), entry.getValue())); 
		      	
	            count = count - 1 ;
			
		
    	
    	
    }
    
    
} 

