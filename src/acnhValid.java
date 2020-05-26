import javax.swing.JTextField;

public class acnhValid
{
   public static boolean visitorExists(String input)
   {
      for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
      {
         if(input.equalsIgnoreCase(acnhData.chancers[i]))
            return true;
      }
   
      for(int i = 0; i < acnhData.GUARANTEE_LENGTH; i++)
      {
         if(input.equalsIgnoreCase(acnhData.guaranteers[i]))
            return true;
      }
   
      return false;
   }

   public static boolean isGuaranteer(String input)
   {
      for(int i = 0; i < acnhData.GUARANTEE_LENGTH; i++)
      {
         if(input.equalsIgnoreCase(acnhData.guaranteers[i]))
            return true;
      }
      
      return false;
   }

   public static boolean isChancer(String input)
   {
      for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
      {    
         if(input.equalsIgnoreCase(acnhData.chancers[i]))
            return true;
      }

      return false;
   }
   
   public static boolean fieldsFilled(JTextField[] tfs)
   {
	   for(int i = 0; i < tfs.length; i++)
	   {
		   if(tfs[i].getText().equals(""))
			   return false;
	   }
	   
	   return true;
   }
   
   public static boolean fieldsEmpty(JTextField[] tfs)
   {
	   for(int i = 0; i < tfs.length; i++)
	   {
		   if(!tfs[i].getText().equals(""))
			   return false;
	   }
	   
	   return true;
   }
   
   public static boolean isDupe(JTextField[] tfs, String input, int ignore)
   {
	   for(int i = 0; i < tfs.length; i++)
	   {
		   if(i != ignore && input.equalsIgnoreCase(tfs[i].getText()))
			   return true;
	   }

	   return false;
   }
   
   public static int findDupe(JTextField[] tfs, String input, int ignore)
   {
	   int i = 0;
	   
	   for(; i < tfs.length; i++)
	   {
		   if(i != ignore && input.equalsIgnoreCase(tfs[i].getText()))
			   return i;
	   }
	   
	   return -1;
   }
}