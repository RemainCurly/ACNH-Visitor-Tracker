public class acnhPrioritize
{
   public static boolean allTrue = false;
   
   public static void prioritize(String visitor)
   {
      for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
      {
         if(visitor.equalsIgnoreCase(acnhData.chancers[i]))
            acnhData.isPriority[i] = true;
      }
   }
   
   public static void reversePrioritize(String visitor)
   {
      if(!allTrue)
      {
         for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
         {
            acnhData.isPriority[i] = true;
         }
         allTrue = true;
      }
      
      for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
      {
         if(visitor.equalsIgnoreCase(acnhData.chancers[i]))
            acnhData.isPriority[i] = false;
      }
   }
   
   public static void resetPriorities()
   {
	   for(int i = 0; i < acnhData.isPriority.length; i++)
	   {
		   acnhData.isPriority[i] = false;
	   }
   }

}