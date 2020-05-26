public class acnhStats
{
	public static String finalStats()
	{
		String result = "<html><h2>You got better odds of seeing these visitors next week!</h2>"
				+ "<ul>";	
		
		for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
		{
			if(!acnhData.chancerVisited[i])
				result += "<li>" + acnhData.chancers[i] + "</li>";
		}
		
		result += "</ul><p>Thanks for using the tracker! :D</p></html>";
		
		return result;
	}
	
	public static String printStats()
   {
	   String result = "<html>";
	   
	   if(!guaranteersLeft() && !chancersLeft())
	   {
		   result += "<h2>Lol no.</h2>"
				   + "<p>There's no way <u>all</u> of them visited in one week</p>"
				   + "<p>Go hit clear week to start over, you silly banana</p></html>";
		   return result;
	   }
	   
	   if(guaranteersLeft())
	   {
		   	   result += "<h3>These visitors will ALL visit by Friday!</h3>"
		   			+ "<ul>";
		   
		   for(int i = 0; i < acnhData.GUARANTEE_LENGTH; i++)
		   {
			   if(!acnhData.guaranteerVisited[i])
			   {
				   result += "<li>" + acnhData.guaranteers[i] + "</li>";
			   }
		   }
		   
		   result += "</ul>";
	   }
	   else
	   {
		   result += "<h3>All Guaranteers have visited!</h3>";
	   }
	   
	   if(arePriorities())
	   {
		   if(prioritiesLeft())
		   {
			   result += "<h3>These visitors have a higher chance of visiting this week!"
					   + "<ul>";
			   
			   for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
			   {
				   if(acnhData.isPriority[i] && !acnhData.chancerVisited[i])
				   {
					   result += "<li>" + acnhData.chancers[i] + "</li>";
				   }
			   }
			   
			   result += "</ul>";
		   }
	   }
	   
       if(chancersLeft())
       {
          result += "<h3>These visitors MAY visit this week</h3>"
        		  + "<ul>";
          for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
          {
             if(!acnhData.chancerVisited[i] && !acnhData.isPriority[i])
                result += "<li>" + acnhData.chancers[i] + "</li>";
          }
          
          result += "</ul>";
       }	 
	   
	   result += "</html>";
	   
	   return result;
   }

   public static boolean arePriorities()
   {
      for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
      {
         if(acnhData.isPriority[i])
            return true;
      }
      
      return false;
   }

   public static boolean prioritiesLeft()
   {
      for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
      {
         if(acnhData.isPriority[i] && !acnhData.chancerVisited[i])
            return true;
      }
      
      return false;
   }

   public static boolean chancersLeft()
   {
      for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
      {
         if(!acnhData.chancerVisited[i] && !acnhData.isPriority[i])
            return true;
      }
      
      return false;
   }
   
   public static boolean guaranteersLeft()
   {
      for(int i = 0; i < acnhData.GUARANTEE_LENGTH; i++)
      {
         if(!acnhData.guaranteerVisited[i])
            return true;
      }
      
      return false;
   }

   public static void markChancer(String chancer)
   {
      for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
      {
         if(chancer.equalsIgnoreCase(acnhData.chancers[i]))
            acnhData.chancerVisited[i] = true;
      }
   }

   public static void markGuaranteer(String guaranteer)
   {
      for(int i = 0; i < acnhData.GUARANTEE_LENGTH; i++)
      {
         if(guaranteer.equalsIgnoreCase(acnhData.guaranteers[i]))
            acnhData.guaranteerVisited[i] = true;
      }
   }
   
   public static void resetVisitors()
   {
	   for(int i = 0; i < acnhData.GUARANTEE_LENGTH; i++)
	   {
		   acnhData.guaranteerVisited[i] = false;
	   }
	   
	   for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
	   {
		   acnhData.chancerVisited[i] = false;
	   }
   }
}